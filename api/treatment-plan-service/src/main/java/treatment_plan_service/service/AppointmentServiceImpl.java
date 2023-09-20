package treatment_plan_service.service;

import org.springframework.stereotype.Service;
import treatment_plan_service.dto.AppointmentDTO;
import treatment_plan_service.entity.Appointment;
import treatment_plan_service.generic.GenericMapper;
import treatment_plan_service.generic.GenericRepository;
import treatment_plan_service.generic.GenericService;
import treatment_plan_service.mapper.AppointmentMapper;
import treatment_plan_service.repository.AppointmentRepository;

@Service
public class AppointmentServiceImpl extends GenericService<Appointment, AppointmentDTO,Long, AppointmentRepository, AppointmentMapper> {
    public AppointmentServiceImpl(final AppointmentRepository repository,final AppointmentMapper mapper) {
        super(repository, mapper);
    }
}
