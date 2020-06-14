package co.wide.core.card;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class CardEntity {

    @Id
    private Long id;
    private String title;
    private String comment;

//    @OneToMany(fetch = FetchType.LAZY)
//    @JoinColumn("card_id")
//    private List<ResourceEntity> resources; TODO: add after Resource feature
}
