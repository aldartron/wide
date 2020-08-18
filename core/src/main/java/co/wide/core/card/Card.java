package co.wide.core.card;

import co.wide.core.plan.Plan;
import co.wide.core.resource.Resource;
import lombok.Data;

import java.util.List;
/**
 * Карта - это сущность открытой карточки, т.е. подробная
 * информация со всеми ресурсами и прочим
 */
@Data
public class Card {

    private Long id;
    private String title;
    private List<Resource> resources;
    private String comment;
    private Plan plan;
}
