package co.wide.core.resource;

import co.wide.core.card.CardEntity;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "resource")
public class ResourceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String link;
    @Enumerated(EnumType.STRING)
    private ResourceType type;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private CardEntity card;

}
