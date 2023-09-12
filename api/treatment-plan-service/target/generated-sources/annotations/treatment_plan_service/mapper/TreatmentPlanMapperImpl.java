package treatment_plan_service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;
import treatment_plan_service.dto.OperationDto;
import treatment_plan_service.dto.TreatmentPlanDto;
import treatment_plan_service.entity.Operation;
import treatment_plan_service.entity.TreatmentPlan;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-13T01:04:33+0200",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.7 (Oracle Corporation)"
)
@Component
public class TreatmentPlanMapperImpl implements TreatmentPlanMapper {

    @Override
    public List<TreatmentPlanDto> toDtos(List<TreatmentPlan> dtos) {
        if ( dtos == null ) {
            return null;
        }

        List<TreatmentPlanDto> list = new ArrayList<TreatmentPlanDto>( dtos.size() );
        for ( TreatmentPlan treatmentPlan : dtos ) {
            list.add( toDto( treatmentPlan ) );
        }

        return list;
    }

    @Override
    public List<TreatmentPlan> toBos(List<TreatmentPlanDto> bos) {
        if ( bos == null ) {
            return null;
        }

        List<TreatmentPlan> list = new ArrayList<TreatmentPlan>( bos.size() );
        for ( TreatmentPlanDto treatmentPlanDto : bos ) {
            list.add( toBo( treatmentPlanDto ) );
        }

        return list;
    }

    @Override
    public TreatmentPlanDto toDto(TreatmentPlan bo) {
        if ( bo == null ) {
            return null;
        }

        TreatmentPlanDto treatmentPlanDto = new TreatmentPlanDto();

        treatmentPlanDto.setId( bo.getId() );
        treatmentPlanDto.setName( bo.getName() );
        treatmentPlanDto.setPatientName( bo.getPatientName() );
        treatmentPlanDto.setDescription( bo.getDescription() );
        treatmentPlanDto.setDate( bo.getDate() );
        treatmentPlanDto.setOperations( operationListToOperationDtoList( bo.getOperations() ) );

        return treatmentPlanDto;
    }

    @Override
    public TreatmentPlan toBo(TreatmentPlanDto dto) {
        if ( dto == null ) {
            return null;
        }

        TreatmentPlan treatmentPlan = new TreatmentPlan();

        treatmentPlan.setId( dto.getId() );
        treatmentPlan.setName( dto.getName() );
        treatmentPlan.setPatientName( dto.getPatientName() );
        treatmentPlan.setDescription( dto.getDescription() );
        treatmentPlan.setDate( dto.getDate() );
        treatmentPlan.setOperations( operationDtoListToOperationList( dto.getOperations() ) );

        return treatmentPlan;
    }

    @Override
    public TreatmentPlan fillBo(TreatmentPlanDto dto, TreatmentPlan bo) {
        if ( dto == null ) {
            return null;
        }

        bo.setId( dto.getId() );
        bo.setName( dto.getName() );
        bo.setPatientName( dto.getPatientName() );
        bo.setDescription( dto.getDescription() );
        bo.setDate( dto.getDate() );
        if ( bo.getOperations() != null ) {
            List<Operation> list = operationDtoListToOperationList( dto.getOperations() );
            if ( list != null ) {
                bo.getOperations().clear();
                bo.getOperations().addAll( list );
            }
            else {
                bo.setOperations( null );
            }
        }
        else {
            List<Operation> list = operationDtoListToOperationList( dto.getOperations() );
            if ( list != null ) {
                bo.setOperations( list );
            }
        }

        return bo;
    }

    protected OperationDto operationToOperationDto(Operation operation) {
        if ( operation == null ) {
            return null;
        }

        OperationDto operationDto = new OperationDto();

        operationDto.setId( operation.getId() );
        operationDto.setDate( operation.getDate() );
        operationDto.setDesciption( operation.getDesciption() );
        operationDto.setName( operation.getName() );
        operationDto.setStatus( operation.getStatus() );

        return operationDto;
    }

    protected List<OperationDto> operationListToOperationDtoList(List<Operation> list) {
        if ( list == null ) {
            return null;
        }

        List<OperationDto> list1 = new ArrayList<OperationDto>( list.size() );
        for ( Operation operation : list ) {
            list1.add( operationToOperationDto( operation ) );
        }

        return list1;
    }

    protected Operation operationDtoToOperation(OperationDto operationDto) {
        if ( operationDto == null ) {
            return null;
        }

        Operation operation = new Operation();

        operation.setId( operationDto.getId() );
        operation.setDate( operationDto.getDate() );
        operation.setDesciption( operationDto.getDesciption() );
        operation.setName( operationDto.getName() );
        operation.setStatus( operationDto.getStatus() );

        return operation;
    }

    protected List<Operation> operationDtoListToOperationList(List<OperationDto> list) {
        if ( list == null ) {
            return null;
        }

        List<Operation> list1 = new ArrayList<Operation>( list.size() );
        for ( OperationDto operationDto : list ) {
            list1.add( operationDtoToOperation( operationDto ) );
        }

        return list1;
    }
}
