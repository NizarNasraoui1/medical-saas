package treatment_plan_service.mapper;

import org.mapstruct.Mapper;
import treatment_plan_service.dto.TreatmentDTO;
import treatment_plan_service.entity.Treatment;
import treatment_plan_service.generic.GenericMapper;

@Mapper(componentModel = "spring")
public interface TreatmentMapper extends GenericMapper<Treatment, TreatmentDTO> {
}
