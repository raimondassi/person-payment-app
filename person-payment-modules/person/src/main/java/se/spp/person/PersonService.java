package se.spp.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.spp.common.Person;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {
    @Autowired
    public PersonRepository personRepository;

    public void addPerson(Person person) {
        if (personRepository.findById(person.getId()).isPresent()) {
            System.out.println("This person already exist");
         return;}
        else
            personRepository.save(person);
    }

    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }

    public Person findPerson(Long id) {
        try {
            return personRepository.findById(id).get();
        } catch (Exception e) {
            return null;
        }
    }

    public Person findPersonIdFromOfficialId(String officialId) {
        try {
            return personRepository.findAll().stream().filter(person -> person.getOfficialId().equals(officialId))
                    .collect(Collectors.toList())
                    .get(0);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Person> getAllPersons() {
        return personRepository.findAll().stream().collect(Collectors.toList());
    }

    public void updatePerson(Person person) {
        if (personRepository.findById(person.getId()).isPresent())
        personRepository.save(person);
        else {
            System.out.println("This person does not exist");
            return;
        }

    }
}
