package se.spp.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.spp.common.Payment;
import se.spp.common.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    public Optional<Person> findPerson(Long id) {
        return personRepository.findById(id);
    }

    public List<Person> getAllPersons() {
        List<Person> persons = new ArrayList<>();
        personRepository.findAll()
                .forEach(persons::add);
        return persons;
    }

    public void updatePerson(Person person) {
        personRepository.save(person);
    }

    public Person findPersonIdFromOfficialId(String officialId){
             return getAllPersons()
                .stream()
                .filter(person -> person.getOfficialId().equals(officialId))
                .collect(Collectors.toList())
                .get(0);

    }


}
