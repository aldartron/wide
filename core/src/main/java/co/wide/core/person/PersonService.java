package co.wide.core.person;

import java.util.List;

public interface PersonService {

    Person createPerson(Person person);

    Person getById(Long id);

    List<Person> getAll();

    List<Person> getByPlan(Long planId);

}
