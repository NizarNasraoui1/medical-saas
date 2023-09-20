package treatment_plan_service.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import treatment_plan_service.dto.AppointmentDTO;
import treatment_plan_service.entity.Appointment;
import treatment_plan_service.generic.GenericResource;
import treatment_plan_service.mapper.AppointmentMapper;
import treatment_plan_service.repository.AppointmentRepository;
import treatment_plan_service.service.AppointmentService;
import treatment_plan_service.service.impl.AppointmentServiceImpl;

@RestController
@RequestMapping("api/treatment-plan/appointment")
public class AppointmentResource extends GenericResource<Appointment,AppointmentDTO,Long, AppointmentRepository, AppointmentMapper, AppointmentService> {
    private final AppointmentService appointmentService;

    public AppointmentResource(AppointmentService appointmentService) {
        super(appointmentService);
        this.appointmentService = appointmentService;
    }

}
