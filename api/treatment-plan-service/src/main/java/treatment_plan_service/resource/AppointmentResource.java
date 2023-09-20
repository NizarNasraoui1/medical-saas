package treatment_plan_service.resource;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;
import treatment_plan_service.dto.AppointmentDTO;
import treatment_plan_service.entity.Appointment;
import treatment_plan_service.generic.GenericResource;
import treatment_plan_service.mapper.AppointmentMapper;
import treatment_plan_service.repository.AppointmentRepository;
import treatment_plan_service.service.AppointmentServiceImpl;

@RestController
@RequestMapping("api/treatment-plan/appointment")
public class AppointmentResource extends GenericResource<Appointment,AppointmentDTO,Long, AppointmentRepository, AppointmentMapper,AppointmentServiceImpl> {
    private final AppointmentServiceImpl appointmentService;

    public AppointmentResource(AppointmentServiceImpl appointmentService) {
        super(appointmentService);
        this.appointmentService = appointmentService;
    }

//    @PostMapping
//    Mono<AppointmentDTO> savee(@RequestBody AppointmentDTO appointmentDTO){
//        return appointmentService.save(appointmentDTO);
//    }

}
