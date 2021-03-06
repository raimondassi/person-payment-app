package se.spp.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.spp.common.Person;

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
    public Person findPerson(@PathVariable Long id) {
        return personService.findPerson(id);
    }

    @GetMapping("/find-person-from-official-id/{officialId}")
    public Person findPersonIdFromOfficialId(@PathVariable String officialId) {
        return personService.findPersonIdFromOfficialId(officialId);
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


