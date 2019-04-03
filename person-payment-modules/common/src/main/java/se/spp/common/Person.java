package se.spp.common;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Person {

    @Id
  //  @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String officialId;
    private String name;

    public Person(Long id, String officialId, String name) {
        this.id = id;
        this.officialId = officialId;
        this.name = name;
    }

    public Person() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOfficialId() {
        return officialId;
    }

    public void setOfficialId(String officialId) {
        this.officialId = officialId;
    }

}



