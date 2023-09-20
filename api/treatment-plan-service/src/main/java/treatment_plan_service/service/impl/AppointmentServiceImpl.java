package treatment_plan_service.service.impl;

import org.springframework.stereotype.Service;
import treatment_plan_service.dto.AppointmentDTO;
import treatment_plan_service.entity.Appointment;
import treatment_plan_service.generic.GenericService;
import treatment_plan_service.generic.GenericServiceImpl;
import treatment_plan_service.mapper.AppointmentMapper;
import treatment_plan_service.repository.AppointmentRepository;
import treatment_plan_service.service.AppointmentService;

@Service
public class AppointmentServiceImpl extends GenericServiceImpl<Appointment, AppointmentDTO,Long, AppointmentRepository, AppointmentMapper> implements AppointmentService {
    public AppointmentServiceImpl(final AppointmentRepository repository,final AppointmentMapper mapper) {
        super(repository, mapper);
    }
}
