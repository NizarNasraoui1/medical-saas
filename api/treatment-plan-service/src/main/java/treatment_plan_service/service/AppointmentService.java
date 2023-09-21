package treatment_plan_service.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import treatment_plan_service.dto.AddMilestoneToAppointmentDTO;
import treatment_plan_service.dto.AddTreatmentToAppointmentDTO;
import treatment_plan_service.dto.AppointmentDTO;
import treatment_plan_service.entity.Appointment;
import treatment_plan_service.generic.GenericService;
import treatment_plan_service.mapper.AppointmentMapper;
import treatment_plan_service.repository.AppointmentRepository;

public interface AppointmentService extends GenericService<Appointment, AppointmentDTO, Long, AppointmentRepository, AppointmentMapper> {
    Mono<AppointmentDTO> addTreatmentToAppointment(AddTreatmentToAppointmentDTO addTreatmentToAppointmentDTO);
    Mono<AppointmentDTO> addMilestoneToAppointment(AddMilestoneToAppointmentDTO addMilestoneToAppointmentDTO);

}