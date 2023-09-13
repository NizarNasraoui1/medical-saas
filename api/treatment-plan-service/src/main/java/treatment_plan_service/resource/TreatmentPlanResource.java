package treatment_plan_service.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import treatment_plan_service.dto.OperationDto;
import treatment_plan_service.dto.PageResponseDTO;
import treatment_plan_service.dto.TreatmentPlanDto;
import treatment_plan_service.service.TreatmentPlanService;

@RestController
@RequestMapping("api/treatment-plan")
public class TreatmentPlanResource {
    private final TreatmentPlanService treatmentPlanService;

    public TreatmentPlanResource(TreatmentPlanService treatmentPlanService) {
        this.treatmentPlanService = treatmentPlanService;
    }

    @PostMapping
    public ResponseEntity<TreatmentPlanDto>addTreatmentPlan(@RequestBody TreatmentPlanDto treatmentPlanDto){
        return new ResponseEntity<>(treatmentPlanService.saveTreatmentPlan(treatmentPlanDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<TreatmentPlanDto>getTreatmentPlanById(@PathVariable("id") Long id){
        return new ResponseEntity<>(treatmentPlanService.getTreatmentPlanById(id), HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<PageResponseDTO<TreatmentPlanDto>>searchTreatmentPlanPage(
            @RequestParam(value = "page",required = false, defaultValue = "ASC") int pageNumber,
            @RequestParam(value = "size",required = false) int pageSize,
            @RequestParam(value = "name",required = false , defaultValue = "") String name
    ){
        return new ResponseEntity<>(treatmentPlanService.searchTreatmentPlanPage(pageNumber,pageSize,name),HttpStatus.OK);
    }

    @PostMapping("/{id}/add-operation")
    public ResponseEntity<TreatmentPlanDto> addOperationToTreatmentPlan(@PathVariable("id")Long id, @RequestBody OperationDto operationDto){
        return new ResponseEntity<>(treatmentPlanService.addOperationToTreatmentPlan(id,operationDto),HttpStatus.OK);
    }
}
