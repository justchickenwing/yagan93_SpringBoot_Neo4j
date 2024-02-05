package com.example.neo4j.domain.tea;

import com.example.neo4j.domain.tea.dto.TeaRecommendationDTO;
import com.example.neo4j.domain.tea.relationships.PurchasedWith;
import com.example.neo4j.domain.tea.util.TeaUtil;
import com.example.neo4j.service.CsvReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class TeaServiceImpl implements TeaService {
    private final TeaRepository repository;
    @Autowired
    public TeaServiceImpl(TeaRepository repository) {
        this.repository = repository;
    }


    @Override
    public Tea findById(UUID uuid) {
        return repository.findById(uuid).orElseThrow();
    }
    @Override
    public List<Tea> findAll() {
        return repository.findAll();
    }

    @Transactional
    @Override
    public void embedTeas() {
        String path = "src/main/resources/data.csv";
        CsvReader reader = new CsvReader(path);
        reader.readCSV((line) -> {

            String[] parts = line.split(",");
            UUID tea1Id = UUID.fromString(parts[0]);
            UUID tea2Id = UUID.fromString(parts[4]);

            // tea1 exists?
            Tea tea1 = repository.findById(tea1Id).orElse(new Tea(tea1Id, parts[1], parts[2], parts[3]));

            // tea2 exists?
            Tea tea2 = repository.findById(tea2Id).orElse(new Tea(tea2Id, parts[5], parts[6], parts[7]));

            PurchasedWith edge = TeaUtil.findEdge(tea1, tea2);
            // edge exists?
            if (edge != null) {
                // yes -> increment weight
                Tea sourceNode = (edge.getTea() == tea1) ? tea2 : tea1;
                Tea targetNode = (edge.getTea() == tea1) ? tea1 : tea2;

                for (PurchasedWith pw : sourceNode.getPurchasedWiths()) {
                    if (pw.getTea().getId().equals(targetNode.getId())) {
                        pw.incrementWeight();
                        repository.save(sourceNode);
                        repository.save(targetNode);
                        return;
                    }
                }
            }
            // no -> new edge
            tea1.getPurchasedWiths().add(new PurchasedWith().setTea(tea2).incrementWeight());
            repository.save(tea1);
            repository.save(tea2);
        });
    }

    @Override
    public List<TeaRecommendationDTO> findRecommendedTeas(UUID id) {
        return repository.findRecommendedTeas(id.toString());
    }
}
