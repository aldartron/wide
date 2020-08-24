package co.wide.core.card.relation;

import co.wide.core.card.CardEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "card_relation")
public class CardRelationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_relation_generator")
    @SequenceGenerator(name = "card_relation_generator", sequenceName = "card_relation_id_seq")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "left_card_id")
    private CardEntity left;

    @ManyToOne
    @JoinColumn(name = "right_card_id")
    private CardEntity right;

    private String description;

    @Enumerated(EnumType.STRING)
    private CardRelationType type;

}
