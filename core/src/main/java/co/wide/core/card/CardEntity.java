package co.wide.core.card;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class CardEntity {

    @Id
    private Long id;

}
