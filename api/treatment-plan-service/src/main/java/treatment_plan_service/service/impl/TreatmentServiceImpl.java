package treatment_plan_service.service.impl;

import org.springframework.stereotype.Service;
import treatment_plan_service.dto.TreatmentDTO;
import treatment_plan_service.entity.Treatment;
import treatment_plan_service.generic.GenericServiceImpl;
import treatment_plan_service.mapper.TreatmentMapper;
import treatment_plan_service.repository.TreatmentRepository;
import treatment_plan_service.service.TreatmentService;

@Service
public class TreatmentServiceImpl extends GenericServiceImpl<Treatment, TreatmentDTO,Long, TreatmentRepository, TreatmentMapper> implements TreatmentService {
    public TreatmentServiceImpl(TreatmentRepository repository, TreatmentMapper mapper) {
        super(repository, mapper);
    }
}
