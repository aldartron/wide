package co.wide.core.user;

import co.wide.core.card.CardEntity;
import co.wide.core.plan.PlanEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // TODO: change to SEQUENCE
    private Long id;

    private String username;

    private String firstName;

    private String lastName;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<PlanEntity> plans;

    @OneToMany
    @JoinColumn(name = "user_id")
    private List<CardEntity> cards;

}
