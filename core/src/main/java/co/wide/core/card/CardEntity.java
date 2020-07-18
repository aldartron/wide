package co.wide.core.card;

import co.wide.core.person.PersonEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "card")
public class CardEntity {

    @Id
    private Long id;
    private String title;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn("card_id")
//    private List<ResourceEntity> resources; TODO: add after Resource feature
}
