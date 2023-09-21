package treatment_plan_service.mapper;

import org.mapstruct.Mapper;
import treatment_plan_service.dto.AppointmentMilestoneDTO;
import treatment_plan_service.entity.AppointmentMilestone;
import treatment_plan_service.generic.GenericMapper;

@Mapper(componentModel = "spring")
public interface AppointmentMilestonMapper extends GenericMapper<AppointmentMilestone, AppointmentMilestoneDTO> {
}
