package co.wide.core.resource;

import lombok.Data;

@Data
public class Resource {

    private Long id;
    private Integer order;
    private String title;
    private String link;
    private ResourceType type;
    private String description;
    private Long cardId;

}
