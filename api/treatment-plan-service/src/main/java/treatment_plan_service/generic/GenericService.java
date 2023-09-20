package treatment_plan_service.generic;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import treatment_plan_service.exception.EntityException;

import java.util.List;

import static java.util.Objects.nonNull;

/**
 * @param <B> Bo
 * @param <D> Dto
 * @param <I> id
 * @param <I> name
 * @param <R> Repository
 * @param <M> Mapper
 */
@Slf4j
@Transactional
@Getter
@Setter
@AllArgsConstructor
@NoRepositoryBean
public abstract class GenericService<B, D, I, R extends GenericRepository<B, I>, M extends GenericMapper<B, D>> {

    protected R repository;

    protected M mapper;

    public Mono<D> findById(final I id) {
        return Mono.justOrEmpty(repository
                .findById(id)
                .map(mapper::toDto));
    }


    public Mono<B> findBoById(final I id) {
        return Mono.justOrEmpty(repository
                        .findById(id))
                .switchIfEmpty(Mono.error(EntityException.toSupplier("id: " + id + " not found")));
    }

    public Flux<D> findAll(final Specification specification) {
        return Flux.fromIterable((List<B>)repository.findAll(specification))
                .map(mapper::toDto);
    }

    public Flux<D> findAll(final Specification specification, Pageable pageable) {
        return Flux.fromIterable((List<B>)repository.findAll(specification,pageable))
                .map(mapper::toDto);
    }

    public Flux<D> findAll() {
        return Flux.fromIterable(repository.findAll())
                .map(mapper::toDto);
    }

    public Mono<D> save(final D dto) {
        return Mono.justOrEmpty(dto)
                .switchIfEmpty(Mono.error(EntityException.toSupplier("input: is null")))
                .flatMap(this::createEntityFromDto)
                .switchIfEmpty(Mono.error(EntityException.toSupplier("id: is null")));
    }

    public Mono<D> createEntityFromDto(final D dto) {
        return Mono.justOrEmpty(repository
                        .save(mapper.toBo(dto)))
                .onErrorResume(DataAccessException.class, throwable -> Mono.error(EntityException.toSupplier("Failed to create entry", throwable)))
                .map(mapper::toDto);
    }

    public Mono<B> createEntityFromBo(final B bo) {
        return Mono.justOrEmpty(repository
                        .save(bo))
                .onErrorResume(DataAccessException.class, throwable -> Mono.error(EntityException.toSupplier("Failed to create entry", throwable)));
    }

    public Mono<D> delete(final I id) {
        return Mono.justOrEmpty(repository
                        .findById(id))
                .doOnNext(repository::delete)
                .switchIfEmpty(Mono.error(EntityException.toSupplier("id: " + id + " not found")))
                .map(mapper::toDto);
    }

    public Mono<D> deleteByUserName(final I id) {
        return Mono.justOrEmpty(repository
                        .findById(id))
                .doOnNext(repository::delete)
                .switchIfEmpty(Mono.error(EntityException.toSupplier("id: " + id + " not found")))
                .map(mapper::toDto);
    }

    public Mono<D> saveFromBo(final B bo) {
        return Mono.justOrEmpty(bo)
                .switchIfEmpty(Mono.error(EntityException.toSupplier("input: is null")))
                .flatMap(this::createEntityFromBo)
                .switchIfEmpty(Mono.error(EntityException.toSupplier("id: is null")))
                .map(mapper::toDto);

    }

    public Mono<D> update(final I id, final D dto) {
        return Mono
                .justOrEmpty(dto)
                .switchIfEmpty(Mono.error(EntityException.toSupplier("dto: is null")))
                .filter(product -> nonNull(id))
                .switchIfEmpty(Mono.error(EntityException.toSupplier("id: is null")))

                .flatMap(entity -> updateEntity(id, entity));
    }

    private Mono<D> updateEntity(final I id, final D dto) {
        return Mono.justOrEmpty(repository
                        .findById(id))
                .flatMap(entity -> Mono.justOrEmpty(repository.save(mapper.fillBo(dto, entity))))
                .map(mapper::toDto)
                .switchIfEmpty(Mono.error(EntityException.toSupplier("id: " + id + " not found")))
                .onErrorResume(
                        DataAccessException.class, throwable -> Mono.error(EntityException.toSupplier("Failed to update entry", throwable)));
    }

//    public Mono<D> update(final I id,final D dto){
//        return Mono.justOrEmpty(repository.findById(id))
//                .
//    }

}