package treatment_plan_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import treatment_plan_service.entity.TreatmentPlan;
import treatment_plan_service.enumeration.OperationStatus;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperationDto {
    private Long id;
    private LocalDate date;
    private String desciption;
    private String name;
    private OperationStatus status;
}
