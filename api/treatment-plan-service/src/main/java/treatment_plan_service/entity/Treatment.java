package treatment_plan_service.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Treatment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String name;

    @ManyToMany(mappedBy = "treatments")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "treatment",cascade = CascadeType.ALL)
    private List<Milestone> milestones;



}
