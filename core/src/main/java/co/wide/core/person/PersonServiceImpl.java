package co.wide.core.person;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public Person createPerson(Person person) {
        var saved = personRepository.save(
                personMapper.toEntity(person)
        );
        return personMapper.fromEntity(saved);
    }

    @Override
    public Person getById(Long id) {
        return personMapper.fromEntity(
                personRepository.getOne(id)
        );
    }

    @Override
    public List<Person> getAll() {
        return personMapper.fromEntities(
                personRepository.findAll()
        );
    }

    @Override
    public List<Person> getByPlan(Long planId) {
        return null;
    }
}
