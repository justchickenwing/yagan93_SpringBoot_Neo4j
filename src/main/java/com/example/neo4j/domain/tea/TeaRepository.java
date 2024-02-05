package com.example.neo4j.domain.tea;

import com.example.neo4j.domain.tea.dto.TeaRecommendationDTO;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface TeaRepository extends Neo4jRepository<Tea, UUID> {

    @Query("MATCH (n {id: $uuid})-[r:PURCHASED_WITH]-(m) \n" +
            "WITH m, r.weight AS weight ORDER BY weight DESC RETURN m, weight LIMIT 3")
    List<TeaRecommendationDTO> findRecommendedTeas(String uuid);
}
