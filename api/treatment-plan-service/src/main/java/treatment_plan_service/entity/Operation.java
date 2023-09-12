package treatment_plan_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import treatment_plan_service.enumeration.OperationStatus;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalDate date;
    private String desciption;
    private String name;
    private OperationStatus status;
    @ManyToOne
    @JoinColumn(name="treatment_plan_id",referencedColumnName = "id")
    private TreatmentPlan treatmentPlan;
}
