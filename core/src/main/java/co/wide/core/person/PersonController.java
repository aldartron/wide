package co.wide.core.person;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PersonController implements PersonApi {
    private final PersonService personService;

    @Override
    public Person createPerson(Person person) {
        return personService.createPerson(person);
    }

    @Override
    public List<Person> getPersons() {
        return personService.getAll();
    }

    @Override
    public Person getPerson(Long id) {
        return personService.getById(id);
    }
}
