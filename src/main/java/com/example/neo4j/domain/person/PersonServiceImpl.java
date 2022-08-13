package com.example.neo4j.domain.person;

import com.example.neo4j.domain.person.relationships.IsResponsible;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person worksWith(Long idHead, Long idTail) {
        Person personHead = findOrThrow(personRepository.findById(idHead));
        Person personTail = findOrThrow(personRepository.findById(idTail));
        personHead.worksWith(personTail);
        return personRepository.save(personHead);
    }

    @Override
    public Person isResponsibleFor(Long idHead, Long idTail, Integer since) {
        Person personHead = findOrThrow(personRepository.findById(idHead));
        Person personTail = findOrThrow(personRepository.findById(idTail));
        personHead.isResponsibleFor(new IsResponsible(personTail,since));
        return personRepository.save(personHead);
    }

    private Person findOrThrow(Optional<Person> optional) throws NoSuchElementException {
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException("No value present");
        }
    }
}
