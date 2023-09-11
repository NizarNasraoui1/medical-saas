package treatment_plan_service.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import treatment_plan_service.dto.PageResponseDTO;
import treatment_plan_service.dto.TreatmentPlanDto;
import treatment_plan_service.entity.TreatmentPlan;
import treatment_plan_service.mapper.TreatmentPlanMapper;
import treatment_plan_service.repository.TreatmentPlanRepository;

import java.util.List;

@Service
public class TreatmentPlanServiceImpl implements TreatmentPlanService{

    private final TreatmentPlanRepository treatmentPlanRepository;

    private final TreatmentPlanMapper treatmentPlanMapper;

    public TreatmentPlanServiceImpl(TreatmentPlanRepository treatmentPlanRepository, TreatmentPlanMapper treatmentPlanMapper) {
        this.treatmentPlanRepository = treatmentPlanRepository;
        this.treatmentPlanMapper = treatmentPlanMapper;
    }


    @Override
    public TreatmentPlanDto saveTreatmentPlan(TreatmentPlanDto treatmentPlanDto) {
        return treatmentPlanMapper.toDto(treatmentPlanRepository.save(treatmentPlanMapper.toBo(treatmentPlanDto)));

    }

    @Override
    public TreatmentPlanDto getTreatmentPlanById(Long id) {
        return treatmentPlanMapper.toDto(treatmentPlanRepository.findById(id).orElseThrow(()->new EntityNotFoundException()));
    }

    @Override
    public PageResponseDTO<TreatmentPlanDto> searchTreatmentPlanPage(int pageNumber, int pageSize, String name) {
        PageRequest pageRequest = PageRequest.of(pageNumber,pageSize,Sort.Direction.ASC,"date");
        Specification<TreatmentPlan> specification = ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"),name));
        Page<TreatmentPlan> treatmentPlansPage = treatmentPlanRepository.findAll(specification,pageRequest);
        List<TreatmentPlanDto> treatmentPlanDtos = treatmentPlanMapper.toDtos(treatmentPlansPage.getContent());
        PageResponseDTO<TreatmentPlanDto> pageResponseDTO = new PageResponseDTO<>();
        pageResponseDTO.setContent(treatmentPlanDtos);
        pageResponseDTO.setPage(treatmentPlansPage.getNumber());
        pageResponseDTO.setTotalPages(treatmentPlansPage.getTotalPages());
        pageResponseDTO.setSize(treatmentPlansPage.getSize());
        return pageResponseDTO;
    }
}
