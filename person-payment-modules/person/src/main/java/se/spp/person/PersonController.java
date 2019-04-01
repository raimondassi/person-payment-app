package se.spp.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import se.spp.common.Payment;
import se.spp.common.Person;
import se.spp.common.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    public final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/add-person")
    public void addPerson(@RequestBody Person person) {
        personService.addPerson(person);

    }

    @PostMapping("/delete-person/{id}")
    public void deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
    }

    @GetMapping("/find-person/{id}")
    public Optional<Person> findPerson(@PathVariable Long id) {
        return personService.findPerson(id);
    }

    @GetMapping("/get-all-persons")
    public List<Person> getAllPersons() {
        return personService.getAllPersons();
    }


    @PostMapping("/update-person")
    public void updatePerson(@RequestBody Person person) {
        personService.updatePerson(person);
    }


}


