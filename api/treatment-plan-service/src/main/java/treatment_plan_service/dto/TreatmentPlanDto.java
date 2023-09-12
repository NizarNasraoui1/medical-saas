package treatment_plan_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import treatment_plan_service.entity.Operation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentPlanDto {
    private Long id;
    private String name;
    private String patientName;
    private String description;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private List<OperationDto> operations = new ArrayList<>();

}
