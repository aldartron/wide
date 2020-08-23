package co.wide.core.card;

import co.wide.core.person.PersonEntity;
import co.wide.core.resource.ResourceEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "card")
public class CardEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private String comment;
    @ManyToOne
    @JoinColumn(name = "person_id")
    private PersonEntity person;

    @OneToMany(
            mappedBy = "card",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    private List<ResourceEntity> resources;
}
