package lab.assist.service;

import lab.assist.model.Person;
import lab.assist.repository.PersonRepo;
import lab.assist.specifications.PersonSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {
    private final PersonRepo personRepo;

    @Autowired
    public PersonServiceImpl(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    @Override
    public List<Person> find(PersonSpecification personSpecification) {
        return personRepo.findAll(personSpecification);
    }

    @Override
    public void updatePerson(Person person) {
        personRepo.save(person);
    }

    @Override
    public void createPerson(Person person) {
        personRepo.save(person);
    }

    @Override
    public void deletePersonById(Long id) {
        personRepo.deleteById(id);
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepo.getById(id);
    }
}
