package com.example.neo4j.domain.person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {

    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<Person>> findAll() {
        return new ResponseEntity<>(personService.findAll(), HttpStatus.OK);
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Person> create(@RequestBody Person person) {
        return new ResponseEntity<>(personService.save(person), HttpStatus.CREATED);
    }

    @PostMapping( "/{idHead}/worksWith/{idTail}")
    public ResponseEntity<Person> worksWith(@PathVariable Long idHead, @PathVariable Long idTail) {
        return new ResponseEntity<>(personService.worksWith(idHead,idTail), HttpStatus.CREATED);
    }

    @PostMapping( "/{idHead}/isResponsibleFor/{idTail}/since/{year}")
    public ResponseEntity<Person> worksWith(@PathVariable Long idHead, @PathVariable Long idTail,@PathVariable Integer year) {
        return new ResponseEntity<>(personService.isResponsibleFor(idHead,idTail,year), HttpStatus.CREATED);
    }
}
