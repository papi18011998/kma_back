package com.example.keur_maman_anthiou_backend.controller;

import com.example.keur_maman_anthiou_backend.dto.MatiereDTO;
import com.example.keur_maman_anthiou_backend.services.IMatiere;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class MatiereController {
    private final IMatiere matiere;

    public MatiereController(IMatiere matiere) {
        this.matiere = matiere;
    }

    @GetMapping(path = "/matieres",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MatiereDTO> getMatieres(){
        return matiere.getMatieres();
    }
}
