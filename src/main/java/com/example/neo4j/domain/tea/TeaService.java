package com.example.neo4j.domain.tea;

import com.example.neo4j.domain.tea.dto.TeaRecommendationDTO;

import java.util.List;
import java.util.UUID;

public interface TeaService {
    List<Tea> findAll();
    Tea findById(UUID id);
    void embedTeas();
    List<TeaRecommendationDTO> findRecommendedTeas(UUID id);
}
