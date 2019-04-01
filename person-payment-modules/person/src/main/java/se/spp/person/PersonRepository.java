package se.spp.person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.spp.common.Payment;
import se.spp.common.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {



}
