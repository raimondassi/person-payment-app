package se.spp.person;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.spp.common.Person;

@RestController
@RequestMapping("/person")
public class PersonController {

    @GetMapping("/get/{id}")
    public Person getperson(@PathVariable Long id) {
        System.out.println(id);
        return new Person();
    }

}
