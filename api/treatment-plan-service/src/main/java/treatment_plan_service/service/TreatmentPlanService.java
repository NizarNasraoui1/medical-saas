package treatment_plan_service.service;

import treatment_plan_service.dto.AppointmentDTO;
import treatment_plan_service.dto.PageResponseDTO;
import treatment_plan_service.dto.TreatmentPlanDTO;
import treatment_plan_service.entity.TreatmentPlan;
import treatment_plan_service.generic.GenericService;
import treatment_plan_service.mapper.TreatmentPlanMapper;
import treatment_plan_service.repository.TreatmentPlanRepository;

public interface TreatmentPlanService extends GenericService<TreatmentPlan,TreatmentPlanDTO,Long, TreatmentPlanRepository, TreatmentPlanMapper> {

}
