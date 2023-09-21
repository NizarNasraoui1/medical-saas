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
        return Mono.zip(
                Mono.justOrEmpty(treatmentRepository.findById(addTreatmentToAppointmentDTO.getTreatmentId())
                        .orElseThrow(() -> new EntityNotFoundException())),

                Mono.justOrEmpty(repository.findById(addTreatmentToAppointmentDTO.getAppointmentId())
                        .orElseThrow(() -> new EntityNotFoundException()))
        ).flatMap(tuple -> {
            Treatment treatment = tuple.getT1();
            Appointment appointment = tuple.getT2();

            AppointmentTreatment appointmentTreatment = new AppointmentTreatment();
            appointmentTreatment.setAppointment(appointment);
            appointmentTreatment.setTreatment(treatment);
            appointmentTreatment.setId(new AppointmentTreatmentKey(addTreatmentToAppointmentDTO.getAppointmentId(), addTreatmentToAppointmentDTO.getAppointmentId()));

            return Mono.fromRunnable(() -> appointmentTreatmentRepository.save(appointmentTreatment))
                    .then(Mono.fromCallable(() -> mapper.toDto(appointment)));
        });
    }
}
