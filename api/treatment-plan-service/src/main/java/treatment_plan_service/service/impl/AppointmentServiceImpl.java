package treatment_plan_service.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import treatment_plan_service.dto.AddTreatmentToAppointmentDTO;
import treatment_plan_service.dto.AppointmentDTO;
import treatment_plan_service.entity.Appointment;
import treatment_plan_service.entity.AppointmentTreatment;
import treatment_plan_service.entity.AppointmentTreatmentKey;
import treatment_plan_service.entity.Treatment;
import treatment_plan_service.generic.GenericServiceImpl;
import treatment_plan_service.mapper.AppointmentMapper;
import treatment_plan_service.repository.AppointmentRepository;
import treatment_plan_service.repository.AppointmentTreatmentRepository;
import treatment_plan_service.repository.TreatmentRepository;
import treatment_plan_service.service.AppointmentService;

@Service
public class AppointmentServiceImpl extends GenericServiceImpl<Appointment, AppointmentDTO,Long, AppointmentRepository, AppointmentMapper> implements AppointmentService {
    private final TreatmentRepository treatmentRepository;

    private final AppointmentTreatmentRepository appointmentTreatmentRepository;

    public AppointmentServiceImpl(final AppointmentRepository repository, final AppointmentMapper mapper, TreatmentRepository treatmentRepository, AppointmentTreatmentRepository appointmentTreatmentRepository) {
        super(repository, mapper);
        this.treatmentRepository = treatmentRepository;
        this.appointmentTreatmentRepository = appointmentTreatmentRepository;
    }

    @Override
    public Mono<AppointmentDTO> addTreatmentToAppointment(AddTreatmentToAppointmentDTO addTreatmentToAppointmentDTO) {
        Treatment treatment = treatmentRepository.findById(addTreatmentToAppointmentDTO.getTreatmentId()).orElseThrow(()->new EntityNotFoundException());
        Appointment appointment = repository.findById(addTreatmentToAppointmentDTO.getAppointmentId()).orElseThrow(()->new EntityNotFoundException());
        AppointmentTreatment appointmentTreatment = new AppointmentTreatment();
        appointmentTreatment.setAppointment(appointment);
        appointmentTreatment.setTreatment(treatment);
        appointmentTreatment.setId(new AppointmentTreatmentKey(addTreatmentToAppointmentDTO.getAppointmentId(),addTreatmentToAppointmentDTO.getAppointmentId()));

        appointmentTreatmentRepository.save(appointmentTreatment);
//        repository.save(appointment);
//        treatmentRepository.save(treatment);

        return Mono.justOrEmpty(mapper.toDto(appointment));
    }
}
