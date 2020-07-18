package co.wide.core.plan;

import co.wide.core.person.PersonEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "plan")
public class PlanEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;

}
