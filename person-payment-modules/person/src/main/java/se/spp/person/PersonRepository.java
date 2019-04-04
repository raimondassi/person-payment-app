package se.spp.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import se.spp.common.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {
}
