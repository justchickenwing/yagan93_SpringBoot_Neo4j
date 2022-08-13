package com.example.neo4j.domain.person.relationships;

import com.example.neo4j.domain.person.Person;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

@RelationshipProperties
public class IsResponsible {

    @RelationshipId
    private Long id;

    @TargetNode
    private Person person;

    @Property("since")
    private Integer since;

    public IsResponsible() {
    }

    public IsResponsible(Person person, Integer since) {
        this.person = person;
        this.since = since;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Integer getSince() {
        return since;
    }

    public void setSince(Integer since) {
        this.since = since;
    }
}
