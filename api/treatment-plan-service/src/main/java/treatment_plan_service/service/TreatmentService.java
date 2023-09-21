package treatment_plan_service.service;

import treatment_plan_service.dto.TreatmentDTO;
import treatment_plan_service.entity.Treatment;
import treatment_plan_service.generic.GenericService;
import treatment_plan_service.mapper.TreatmentMapper;
import treatment_plan_service.repository.TreatmentRepository;

public interface TreatmentService extends GenericService<Treatment, TreatmentDTO,Long, TreatmentRepository, TreatmentMapper> {
}
