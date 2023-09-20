package treatment_plan_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class TreatmentPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String patientName;
    private String description;
    private LocalDate date;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "treatmentPlan")
    private List<Appointment> appointments = new ArrayList<>();
}
