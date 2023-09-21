package treatment_plan_service.service.impl;



import org.springframework.stereotype.Service;
import treatment_plan_service.dto.TreatmentPlanDTO;
import treatment_plan_service.entity.TreatmentPlan;
import treatment_plan_service.generic.GenericServiceImpl;
import treatment_plan_service.mapper.TreatmentPlanMapper;
import treatment_plan_service.repository.TreatmentPlanRepository;
import treatment_plan_service.service.TreatmentPlanService;

import java.util.List;

@Service
public class TreatmentPlanServiceImpl extends GenericServiceImpl<TreatmentPlan, TreatmentPlanDTO,Long, TreatmentPlanRepository, TreatmentPlanMapper> implements TreatmentPlanService {

    public TreatmentPlanServiceImpl(TreatmentPlanRepository repository, TreatmentPlanMapper mapper) {
        super(repository, mapper);
    }
}
