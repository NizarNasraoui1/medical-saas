package treatment_plan_service.mapper;

import org.mapstruct.Mapper;
import treatment_plan_service.dto.AppointmentDTO;
import treatment_plan_service.entity.Appointment;
import treatment_plan_service.generic.GenericMapper;

@Mapper(componentModel = "spring")
public interface AppointmentMapper extends GenericMapper<Appointment, AppointmentDTO> {
}
