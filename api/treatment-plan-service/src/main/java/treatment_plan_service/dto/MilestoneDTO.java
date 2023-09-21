package treatment_plan_service.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MilestoneDTO {
    private Long id;
    private String name;
    private TreatmentDTO treatment;
}
