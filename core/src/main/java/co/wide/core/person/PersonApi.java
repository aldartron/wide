package co.wide.core.person;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/person")
public interface PersonApi {

    @PostMapping
    Person createPerson(@RequestBody Person person);

    @GetMapping
    List<Person> getPersons();

    @GetMapping("/{id}")
    Person getPerson(@PathVariable Long id);

}
