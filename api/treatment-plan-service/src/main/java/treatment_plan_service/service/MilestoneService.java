package treatment_plan_service.service;

import treatment_plan_service.dto.MilestoneDTO;
import treatment_plan_service.entity.Milestone;
import treatment_plan_service.generic.GenericService;
import treatment_plan_service.mapper.MilestoneMapper;
import treatment_plan_service.repository.MilestoneRepository;

public interface MilestoneService extends GenericService<Milestone, MilestoneDTO,Long, MilestoneRepository,MilestoneMapper> {
}
