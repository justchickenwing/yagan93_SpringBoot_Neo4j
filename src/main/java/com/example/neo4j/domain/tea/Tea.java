package com.example.neo4j.domain.tea;

import com.example.neo4j.domain.tea.relationships.PurchasedWith;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Node
public class Tea {
    @Id
    private UUID id;
    @Property
    private String name;
    @Property
    private String country;
    @Property
    private String teaType;
    @Relationship(type = "PURCHASED_WITH")
    private Set<PurchasedWith> purchasedWiths;

    public Tea(UUID id, String name, String country, String teaType) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.teaType = teaType;
        this.purchasedWiths = new HashSet<PurchasedWith>();
    }

    public UUID getId() {
        return id;
    }

    public Tea setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Tea setName(String name) {
        this.name = name;
        return this;
    }

    public Set<PurchasedWith> getPurchasedWiths() {
        return purchasedWiths;
    }

    public Tea setPurchasedWiths(Set<PurchasedWith> purchasedWiths) {
        this.purchasedWiths = purchasedWiths;
        return this;
    }

    public String getCountry() {
        return country;
    }

    public Tea setCountry(String country) {
        this.country = country;
        return this;
    }

    public String getTeaType() {
        return teaType;
    }

    public Tea setTeaType(String teaType) {
        this.teaType = teaType;
        return this;
    }
}
