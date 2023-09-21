package treatment_plan_service.service.impl;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import treatment_plan_service.dto.AddMilestoneToAppointmentDTO;
import treatment_plan_service.dto.AddTreatmentToAppointmentDTO;
import treatment_plan_service.dto.AppointmentDTO;
import treatment_plan_service.entity.*;
import treatment_plan_service.generic.GenericServiceImpl;
import treatment_plan_service.mapper.AppointmentMapper;
import treatment_plan_service.repository.*;
import treatment_plan_service.service.AppointmentService;

@Service
public class AppointmentServiceImpl extends GenericServiceImpl<Appointment, AppointmentDTO,Long, AppointmentRepository, AppointmentMapper> implements AppointmentService {
    private final TreatmentRepository treatmentRepository;

    private final MilestoneRepository milestoneRepository;

    private final AppointmentTreatmentRepository appointmentTreatmentRepository;

    private final AppointmentMilestoneRepository appointmentMilestoneRepository;

    public AppointmentServiceImpl(final AppointmentRepository repository, final AppointmentMapper mapper, TreatmentRepository treatmentRepository, MilestoneRepository milestoneRepository, AppointmentTreatmentRepository appointmentTreatmentRepository, AppointmentMilestoneRepository appointmentMilestoneRepository) {
        super(repository, mapper);
        this.treatmentRepository = treatmentRepository;
        this.milestoneRepository = milestoneRepository;
        this.appointmentTreatmentRepository = appointmentTreatmentRepository;
        this.appointmentMilestoneRepository = appointmentMilestoneRepository;
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

            appointment.getTreatments().add(treatment);

            AppointmentTreatment appointmentTreatment = new AppointmentTreatment();
            appointmentTreatment.setAppointment(appointment);
            appointmentTreatment.setTreatment(treatment);
            appointmentTreatment.setId(new AppointmentTreatmentKey(addTreatmentToAppointmentDTO.getAppointmentId(), addTreatmentToAppointmentDTO.getAppointmentId()));

            return Mono.fromRunnable(() -> appointmentTreatmentRepository.save(appointmentTreatment))
                    .then(Mono.fromCallable(() -> mapper.toDto(appointment)));
        });
    }

    @Override
    public Mono<AppointmentDTO> addMilestoneToAppointment(AddMilestoneToAppointmentDTO addTreatmentToAppointmentDTO) {
        return Mono.zip(
                Mono.justOrEmpty(milestoneRepository.findById(addTreatmentToAppointmentDTO.getMilestoneId())
                        .orElseThrow(() -> new EntityNotFoundException())),

                Mono.justOrEmpty(repository.findById(addTreatmentToAppointmentDTO.getAppointmentId())
                        .orElseThrow(() -> new EntityNotFoundException()))
        ).flatMap(tuple -> {
            Milestone milestone = tuple.getT1();
            Appointment appointment = tuple.getT2();


            AppointmentMilestone appointmentMilestone = new AppointmentMilestone();
            appointmentMilestone.setAppointment(appointment);
            appointmentMilestone.setMilestone(milestone);
            appointment.getMilestones().add(appointmentMilestone);
            milestone.getAppointmentMilestones().add(appointmentMilestone);
            appointmentMilestone.setId(new AppointmentMilestoneKey(addTreatmentToAppointmentDTO.getAppointmentId(), addTreatmentToAppointmentDTO.getMilestoneId()));

            return Mono.fromRunnable(() -> appointmentMilestoneRepository.save(appointmentMilestone))
                    .then(Mono.fromCallable(() -> mapper.toDto(appointment)));
        });
    }
}
