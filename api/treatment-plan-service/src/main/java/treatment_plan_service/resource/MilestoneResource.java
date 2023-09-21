package treatment_plan_service.resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import treatment_plan_service.dto.MilestoneDTO;
import treatment_plan_service.entity.Milestone;
import treatment_plan_service.generic.GenericResource;
import treatment_plan_service.mapper.MilestoneMapper;
import treatment_plan_service.repository.MilestoneRepository;
import treatment_plan_service.service.MilestoneService;

@RestController
@RequestMapping("api/treatment-plan/milestone")
public class MilestoneResource extends GenericResource<Milestone, MilestoneDTO,Long, MilestoneRepository, MilestoneMapper, MilestoneService> {
    public MilestoneResource(final MilestoneService service) {
        super(service);
    }
}
