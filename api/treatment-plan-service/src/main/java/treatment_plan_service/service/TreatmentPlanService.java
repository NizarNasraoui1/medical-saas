package treatment_plan_service.service;

import treatment_plan_service.dto.PageResponseDTO;
import treatment_plan_service.dto.TreatmentPlanDto;

import java.util.List;

public interface TreatmentPlanService {
    public TreatmentPlanDto saveTreatmentPlan(TreatmentPlanDto treatmentPlanDto);
    public TreatmentPlanDto getTreatmentPlanById(Long id);

    public PageResponseDTO<TreatmentPlanDto> searchTreatmentPlanPage(int pageNumber, int pageSize, String name);
}
