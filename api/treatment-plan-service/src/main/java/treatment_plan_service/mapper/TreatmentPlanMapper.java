package treatment_plan_service.mapper;
import org.mapstruct.Mapper;
import treatment_plan_service.dto.TreatmentPlanDto;
import treatment_plan_service.entity.TreatmentPlan;

@Mapper(componentModel = "spring")
public interface TreatmentPlanMapper extends GenericMapper<TreatmentPlan, TreatmentPlanDto> {
}
