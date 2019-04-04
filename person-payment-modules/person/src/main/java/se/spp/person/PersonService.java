package se.spp.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.spp.common.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    public PersonRepository personRepository;

    public void addPerson(Person person) {
        personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public Person findPerson(Long id) {
        return personRepository.findById(id).get();
    }

    public Person findPersonIdFromOfficialId(String officialId) {
        return personRepository.findAll().stream().filter(person -> person.getOfficialId().equals(officialId))
                .collect(Collectors.toList())
                .get(0);
    }

    public List<Person> getAllPersons() {
       return personRepository.findAll().stream().collect(Collectors.toList());
    }

    public void updatePerson(Person person) {
        personRepository.save(person);
    }
}
