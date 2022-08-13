package com.example.neo4j.domain.person;

import java.util.List;

public interface PersonService {
    List<Person> findAll();
    Person save(Person person);
    Person worksWith (Long idHead, Long idTail);
    Person isResponsibleFor (Long idHead, Long idTail, Integer since);
}
