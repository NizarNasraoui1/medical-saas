package treatment_plan_service.mapper;

import org.mapstruct.Mapper;
import treatment_plan_service.dto.MilestoneDTO;
import treatment_plan_service.entity.Milestone;
import treatment_plan_service.generic.GenericMapper;

@Mapper(componentModel = "spring")
public interface MilestoneMapper extends GenericMapper<Milestone, MilestoneDTO> {
}
