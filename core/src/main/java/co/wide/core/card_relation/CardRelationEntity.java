package co.wide.core.card_relation;

import co.wide.core.card.CardEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "card_relation")
public class CardRelationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "first_card_id")
    private CardEntity first;

    @ManyToOne
    @JoinColumn(name = "second_card_id")
    private CardEntity second;

    private String relationship;
}
