package treatment_plan_service.service.impl;



import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import treatment_plan_service.dto.AppointmentDTO;
import treatment_plan_service.dto.TreatmentPlanDTO;
import treatment_plan_service.entity.Appointment;
import treatment_plan_service.entity.TreatmentPlan;
import treatment_plan_service.exception.EntityException;
import treatment_plan_service.generic.GenericServiceImpl;
import treatment_plan_service.mapper.AppointmentMapper;
import treatment_plan_service.mapper.TreatmentPlanMapper;
import treatment_plan_service.repository.TreatmentPlanRepository;
import treatment_plan_service.service.TreatmentPlanService;

@Service
public class TreatmentPlanServiceImpl extends GenericServiceImpl<TreatmentPlan, TreatmentPlanDTO,Long, TreatmentPlanRepository, TreatmentPlanMapper> implements TreatmentPlanService {

    private final AppointmentMapper appointmentMapper;

    public TreatmentPlanServiceImpl(TreatmentPlanRepository repository, TreatmentPlanMapper mapper, AppointmentMapper appointmentMapper) {
        super(repository, mapper);
        this.appointmentMapper = appointmentMapper;
    }

    @Override
    public Mono<TreatmentPlanDTO> addAppointment(Long id, AppointmentDTO appointmentDTO) {
        return Mono.justOrEmpty(repository.findById(id))
                .switchIfEmpty(Mono.error(EntityException.toSupplier("id: " + id + " not found")))
                .flatMap(treatmentPlan -> {
                    Appointment appointment = appointmentMapper.toBo(appointmentDTO);
                    appointment.setTreatmentPlan(treatmentPlan);
                    treatmentPlan.getAppointments().add(appointment);
                    return Mono.justOrEmpty(repository.save(treatmentPlan));
                }).map(mapper::toDto);

    }
}
