package treatment_plan_service.mapper;

import org.mapstruct.Mapper;
import treatment_plan_service.dto.OperationDto;
import treatment_plan_service.entity.Operation;

@Mapper(componentModel = "spring")
public interface OperationMapper extends GenericMapper<Operation, OperationDto> {
}
