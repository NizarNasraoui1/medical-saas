//package treatment_plan_service.service;
//
//import jakarta.persistence.EntityNotFoundException;
//import org.springframework.data.domain.Page;
//import org.springframework.data.domain.PageRequest;
//import org.springframework.data.domain.Sort;
//import org.springframework.data.jpa.domain.Specification;
//import org.springframework.stereotype.Service;
//import treatment_plan_service.dto.AppointmentDTO;
//import treatment_plan_service.dto.PageResponseDTO;
//import treatment_plan_service.dto.TreatmentPlanDTO;
//import treatment_plan_service.entity.Appointment;
//import treatment_plan_service.entity.TreatmentPlan;
//import treatment_plan_service.mapper.OperationMapper;
//import treatment_plan_service.mapper.TreatmentPlanMapper;
//import treatment_plan_service.repository.TreatmentPlanRepository;
//
//import java.util.List;
//
//@Service
//public class TreatmentPlanServiceImpl implements TreatmentPlanService{
//
////    private final TreatmentPlanRepository treatmentPlanRepository;
////
////    private final TreatmentPlanMapper treatmentPlanMapper;
////
////    private final OperationMapper operationMapper;
////
////    public TreatmentPlanServiceImpl(TreatmentPlanRepository treatmentPlanRepository, TreatmentPlanMapper treatmentPlanMapper, OperationMapper operationMapper) {
////        this.treatmentPlanRepository = treatmentPlanRepository;
////        this.treatmentPlanMapper = treatmentPlanMapper;
////        this.operationMapper = operationMapper;
////    }
////
////
////    @Override
////    public TreatmentPlanDTO saveTreatmentPlan(TreatmentPlanDTO treatmentPlanDto) {
////        return treatmentPlanMapper.toDto(treatmentPlanRepository.save(treatmentPlanMapper.toBo(treatmentPlanDto)));
////
////    }
////
////    @Override
////    public TreatmentPlanDTO getTreatmentPlanById(Long id) {
////        return treatmentPlanMapper.toDto(treatmentPlanRepository.findById(id).orElseThrow(()->new EntityNotFoundException()));
////    }
////
////    @Override
////    public PageResponseDTO<TreatmentPlanDTO> searchTreatmentPlanPage(int pageNumber, int pageSize, String name) {
////        PageRequest pageRequest = PageRequest.of(pageNumber,pageSize,Sort.Direction.ASC,"date");
////        Page<TreatmentPlan> treatmentPlansPage;
////        if(!name.isEmpty()){
////            String likePattern = "%"+name+"%";
////            Specification<TreatmentPlan> specification = ((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"),likePattern));
////            treatmentPlansPage = treatmentPlanRepository.findAll(specification,pageRequest);
////        }
////        else{
////            treatmentPlansPage = treatmentPlanRepository.findAll(pageRequest);
////        }
////        List<TreatmentPlanDTO> treatmentPlanDtos = treatmentPlanMapper.toDtos(treatmentPlansPage.getContent());
////        PageResponseDTO<TreatmentPlanDTO> pageResponseDTO = new PageResponseDTO<>();
////        pageResponseDTO.setContent(treatmentPlanDtos);
////        pageResponseDTO.setPage(treatmentPlansPage.getNumber());
////        pageResponseDTO.setTotalPages(treatmentPlansPage.getTotalPages());
////        pageResponseDTO.setSize(treatmentPlansPage.getSize());
////        pageResponseDTO.setTotalElements(treatmentPlansPage.getTotalElements());
////        return pageResponseDTO;
////    }
////
////    @Override
////    public TreatmentPlanDTO addOperationToTreatmentPlan(Long id, AppointmentDTO operationDto) {
////        TreatmentPlan treatmentPlan = treatmentPlanRepository.findById(id).orElseThrow(()-> new EntityNotFoundException());
////        Appointment operation = operationMapper.toBo(operationDto);
////        treatmentPlan.getOperations().add(operation);
////        operation.setTreatmentPlan(treatmentPlan);
////        treatmentPlanRepository.save(treatmentPlan);
////        return treatmentPlanMapper.toDto(treatmentPlan);
////    }
//}
