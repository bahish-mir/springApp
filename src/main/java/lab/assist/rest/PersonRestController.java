package lab.assist.rest;

import lab.assist.model.Person;
import lab.assist.service.PersonServiceImpl;
import lab.assist.specifications.PersonSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/persons")
public class PersonRestController {
    private final PersonServiceImpl personService;

    @Autowired
    public PersonRestController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping()
    public ResponseEntity<?> getAllPerson(PersonSpecification personSpecification) {
        return new ResponseEntity<>(personService.find(personSpecification), HttpStatus.OK);
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
