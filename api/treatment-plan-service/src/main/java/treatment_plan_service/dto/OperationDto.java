package treatment_plan_service.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import treatment_plan_service.enumeration.OperationStatusEnum;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OperationDto {
    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate date;
    private String desciption;
    private String name;
    private OperationStatusEnum status;
}
