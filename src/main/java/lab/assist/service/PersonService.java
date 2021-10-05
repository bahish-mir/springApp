package lab.assist.service;

import lab.assist.model.Person;
import lab.assist.repository.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {
    private final PersonRepo personRepo;

    @Autowired
    public PersonService(PersonRepo personRepo) {
        this.personRepo = personRepo;
    }

    public List<Person> getAll() {
        return personRepo.findAll();
    }

    public Person getPersonById(Long id) {
        return personRepo.getById(id);
    }

    public void updatePerson(Person person) {
        personRepo.save(person);
    }

    public void createPerson(Person person) {
        personRepo.save(person);
    }

    public void deletePersonById(Long id) {
        personRepo.deleteById(id);
    }
}
