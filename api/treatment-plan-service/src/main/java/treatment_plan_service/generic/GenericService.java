package treatment_plan_service.generic;

import org.springframework.data.jpa.domain.Specification;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GenericService <B, D, I, R extends GenericRepository<B, I>, M extends GenericMapper<B, D>> {
    Mono<D> findById(I id);
    public Mono<B> findBoById(I id);
    Flux<D> findAll(Specification specification);
    public Flux<D> findAll();
    Mono<D> save(D dto);
    Mono<D> delete(I id);
    Mono<D> update(I id, D dto);
}
