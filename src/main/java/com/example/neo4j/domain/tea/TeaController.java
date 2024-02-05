package com.example.neo4j.domain.tea;

import com.example.neo4j.domain.tea.dto.TeaRecommendationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/teas")
public class TeaController {

    private final TeaService teaService;

    @Autowired
    public TeaController(TeaService teaService) {
        this.teaService = teaService;
    }

    @GetMapping({"", "/"})
    public ResponseEntity<Void> embedTeas() {
        teaService.embedTeas();

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping({"/recommended/{id}"})
    public ResponseEntity<List<TeaRecommendationDTO>> findRecommendedTeas(@PathVariable UUID id) {
        List<TeaRecommendationDTO> list = teaService.findRecommendedTeas(id);

        for (TeaRecommendationDTO tea : list) {
            // Handle each TeaDTO object as needed
            // For example, you might want to print or process the data
            System.out.println(tea);
        }

        return new ResponseEntity<>(list, HttpStatus.OK);
    }
}
