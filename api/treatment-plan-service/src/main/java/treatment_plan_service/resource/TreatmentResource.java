package treatment_plan_service.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import treatment_plan_service.dto.TreatmentDTO;
import treatment_plan_service.entity.Treatment;
import treatment_plan_service.generic.GenericResource;
import treatment_plan_service.mapper.TreatmentMapper;
import treatment_plan_service.repository.TreatmentRepository;
import treatment_plan_service.service.TreatmentService;

@RestController
@RequestMapping("api/treatment-plan/treatment")
public class TreatmentResource extends GenericResource<Treatment, TreatmentDTO,Long, TreatmentRepository, TreatmentMapper, TreatmentService> {

    public TreatmentResource(TreatmentService service, TreatmentService treatmentService) {
        super(service);
    }
}
