package treatment_plan_service.resource;


import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;
import treatment_plan_service.dto.AppointmentDTO;
import treatment_plan_service.dto.TreatmentPlanDTO;
import treatment_plan_service.entity.TreatmentPlan;
import treatment_plan_service.generic.GenericResource;
import treatment_plan_service.mapper.TreatmentPlanMapper;
import treatment_plan_service.repository.TreatmentPlanRepository;
import treatment_plan_service.service.TreatmentPlanService;

@RestController
@RequestMapping("api/treatment-plan")
public class TreatmentPlanResource extends GenericResource<TreatmentPlan, TreatmentPlanDTO,Long, TreatmentPlanRepository, TreatmentPlanMapper, TreatmentPlanService> {

    public TreatmentPlanResource(TreatmentPlanService service) {
        super(service);
    }

    @PostMapping("/{id}/appointments")
    public Mono<TreatmentPlanDTO> addAppointment(@PathVariable("id")Long id,@RequestBody AppointmentDTO appointmentDTO){
        return service.addAppointment(id,appointmentDTO);
    }
}
