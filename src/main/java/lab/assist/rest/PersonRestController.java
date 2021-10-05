package lab.assist.rest;

import lab.assist.model.Person;
import lab.assist.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonRestController {
    private final PersonService personService;

    @Autowired
    public PersonRestController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPerson(@PathVariable Long id) {
        if (id == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Person person = personService.getPersonById(id);

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<?> getAllPerson() {
        List<Person> persons = personService.getAll();

        if (persons.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePerson(@PathVariable Long id) {
        Person person = personService.getPersonById(id);

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        personService.deletePersonById(id);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("")
    public ResponseEntity<?> createPerson(@RequestBody Person person) {
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        personService.createPerson(person);

        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePerson(@RequestBody Person person) {
        if (person == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        personService.updatePerson(person);

        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
