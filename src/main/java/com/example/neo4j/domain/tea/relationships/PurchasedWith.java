package com.example.neo4j.domain.tea.relationships;

import com.example.neo4j.domain.tea.Tea;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;


@RelationshipProperties
public class PurchasedWith {
    @RelationshipId
    private Long id;
    @TargetNode
    private Tea tea;
    @Property
    private int weight;

    public PurchasedWith() { }

    public Long getId() {
        return id;
    }

    public PurchasedWith setId(Long id) {
        this.id = id;
        return this;
    }

    public Tea getTea() {
        return tea;
    }

    public PurchasedWith setTea(Tea tea) {
        this.tea = tea;
        return this;
    }

    public int getWeight() {
        return weight;
    }

    public PurchasedWith setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public PurchasedWith incrementWeight() {
        this.weight += 1;
        return this;
    }
}
