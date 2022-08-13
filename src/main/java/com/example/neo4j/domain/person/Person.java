package com.example.neo4j.domain.person;

import com.example.neo4j.domain.person.relationships.IsResponsible;
import org.springframework.data.neo4j.core.schema.*;

import java.util.HashSet;
import java.util.Set;

@Node
public class Person {

    @Id
    @GeneratedValue
    private Long id;

    @Property("firstName")
    private String firstName;

    @Property("lastName")
    private String lastName;

    private Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Relationship(type = "WORKS_WITH", direction = Relationship.Direction.OUTGOING)
    public Set<Person> teammates;

    public void worksWith(Person person) {
        if (teammates == null) {
            teammates = new HashSet<>();
        }
        teammates.add(person);
    }

    @Relationship(type = "IS_RESPONSIBLE", direction = Relationship.Direction.OUTGOING)
    public Set<IsResponsible> subordinates;

    public void isResponsibleFor(IsResponsible isResponsible) {
        if (subordinates == null) {
            subordinates = new HashSet<>();
        }
        subordinates.add(isResponsible);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Set<Person> getTeammates() {
        return teammates;
    }

    public void setTeammates(Set<Person> teammates) {
        this.teammates = teammates;
    }

    public Set<IsResponsible> getSubordinates() {
        return subordinates;
    }

    public void setSubordinates(Set<IsResponsible> subordinates) {
        this.subordinates = subordinates;
    }
}
