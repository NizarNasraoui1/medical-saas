package treatment_plan_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import java.time.LocalDate;
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentPlanDto {
    Long id;
    String name;
    String patientName;
    String description;
    @JsonFormat(pattern = "dd/MM/yyyy")
    LocalDate date;

}
