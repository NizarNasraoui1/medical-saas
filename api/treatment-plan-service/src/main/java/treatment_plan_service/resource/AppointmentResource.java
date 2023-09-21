package treatment_plan_service.resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import treatment_plan_service.dto.AddTreatmentToAppointmentDTO;
import treatment_plan_service.dto.AppointmentDTO;
import treatment_plan_service.entity.Appointment;
import treatment_plan_service.generic.GenericResource;
import treatment_plan_service.mapper.AppointmentMapper;
import treatment_plan_service.repository.AppointmentRepository;
import treatment_plan_service.service.AppointmentService;

@RestController
@RequestMapping("api/treatment-plan/appointment")
public class AppointmentResource extends GenericResource<Appointment,AppointmentDTO,Long, AppointmentRepository, AppointmentMapper, AppointmentService> {

    public AppointmentResource(AppointmentService appointmentService) {
        super(appointmentService);
    }

    @PostMapping("/treatment")
    public Mono<AppointmentDTO> addTreatment(@RequestBody AddTreatmentToAppointmentDTO addTreatmentToAppointmentDTO){
        return service.addTreatmentToAppointment(addTreatmentToAppointmentDTO);
    }
}
