package treatment_plan_service.mapper;
import org.mapstruct.Mapper;
import treatment_plan_service.dto.TreatmentPlanDTO;
import treatment_plan_service.entity.TreatmentPlan;
import treatment_plan_service.generic.GenericMapper;

@Mapper(componentModel = "spring")
public interface TreatmentPlanMapper extends GenericMapper<TreatmentPlan, TreatmentPlanDTO> {
}
