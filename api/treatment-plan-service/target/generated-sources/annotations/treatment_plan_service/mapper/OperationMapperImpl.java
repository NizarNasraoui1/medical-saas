package treatment_plan_service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import treatment_plan_service.dto.OperationDto;
import treatment_plan_service.entity.Operation;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-13T15:57:33+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class OperationMapperImpl implements OperationMapper {

    @Override
    public List<OperationDto> toDtos(List<Operation> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<OperationDto> list = new ArrayList<OperationDto>( dtos.size() );
        for ( Operation operation : dtos ) {
            list.add( toDto( operation ) );
        }

        return list;
    }

    @Override
    public List<Operation> toBos(List<OperationDto> bos) {
        if ( bos == null ) {
            return null;
        }

        List<Operation> list = new ArrayList<Operation>( bos.size() );
        for ( OperationDto operationDto : bos ) {
            list.add( toBo( operationDto ) );
        }

        return list;
    }

    @Override
    public OperationDto toDto(Operation bo) {
        if ( bo == null ) {
            return null;
        }

        OperationDto operationDto = new OperationDto();

        operationDto.setId( bo.getId() );
        operationDto.setDate( bo.getDate() );
        operationDto.setDesciption( bo.getDesciption() );
        operationDto.setName( bo.getName() );
        operationDto.setStatus( bo.getStatus() );

        return operationDto;
    }

    @Override
    public Operation toBo(OperationDto dto) {
        if ( dto == null ) {
            return null;
        }

        Operation operation = new Operation();

        operation.setId( dto.getId() );
        operation.setDate( dto.getDate() );
        operation.setDesciption( dto.getDesciption() );
        operation.setName( dto.getName() );
        operation.setStatus( dto.getStatus() );

        return operation;
    }

    @Override
    public Operation fillBo(OperationDto dto, Operation bo) {
        if ( dto == null ) {
            return null;
        }

        bo.setId( dto.getId() );
        bo.setDate( dto.getDate() );
        bo.setDesciption( dto.getDesciption() );
        bo.setName( dto.getName() );
        bo.setStatus( dto.getStatus() );

        return bo;
    }
}
