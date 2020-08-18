package co.wide.core.plan;

import co.wide.core.person.Person;
import lombok.Data;

@Data
public class Plan {

    private Long id;
    private String name;
    private Person person;
    
}
