package co.wide.core.person;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE
)
public interface PersonMapper {

    Person fromEntity(PersonEntity entity);

    PersonEntity toEntity(Person person);

    List<Person> fromEntities(List<PersonEntity> entities);

    List<PersonEntity> toEntities(List<Person> people);

}
