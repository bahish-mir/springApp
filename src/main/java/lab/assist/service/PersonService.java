package lab.assist.service;

import lab.assist.model.Person;
import lab.assist.specifications.PersonSpecification;

import java.util.List;

public interface PersonService {

    List<Person> find(PersonSpecification personSpecification);

    void updatePerson(Person person);

    void createPerson(Person person);

    void deletePersonById(Long id);

    Person getPersonById(Long id);
}
