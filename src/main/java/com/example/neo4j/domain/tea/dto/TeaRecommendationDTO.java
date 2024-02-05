package com.example.neo4j.domain.tea.dto;

import java.util.UUID;

public class TeaRecommendationDTO {

    private UUID id;
    private String name;
    private int weight;

    public TeaRecommendationDTO(UUID id, String name, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    public TeaRecommendationDTO setWeight(int weight) {
        this.weight = weight;
        return this;
    }

    public UUID getId() {
        return id;
    }

    public TeaRecommendationDTO setId(UUID id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public TeaRecommendationDTO setName(String name) {
        this.name = name;
        return this;
    }
}
