package co.wide.core.person;

import co.wide.core.card.CardEntity;
import co.wide.core.plan.PlanEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "person")
public class PersonEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // TODO: change to SEQUENCE
    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    @OneToMany(mappedBy = "person")
    private List<PlanEntity> plans;

    @OneToMany(mappedBy = "person")
    private List<CardEntity> cards;

}
