package treatment_plan_service.service.impl;

import org.springframework.stereotype.Service;
import treatment_plan_service.dto.MilestoneDTO;
import treatment_plan_service.entity.Milestone;
import treatment_plan_service.generic.GenericServiceImpl;
import treatment_plan_service.mapper.MilestoneMapper;
import treatment_plan_service.repository.MilestoneRepository;
import treatment_plan_service.service.MilestoneService;

@Service
public class MilestoneServiceImpl extends GenericServiceImpl<Milestone, MilestoneDTO,Long, MilestoneRepository, MilestoneMapper> implements MilestoneService {

    public MilestoneServiceImpl(final MilestoneRepository repository,final MilestoneMapper mapper) {
        super(repository, mapper);
    }
}
