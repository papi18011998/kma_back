package com.example.keur_maman_anthiou_backend.controller;

import com.example.keur_maman_anthiou_backend.dto.ClasseDTO;
import com.example.keur_maman_anthiou_backend.services.IClasse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class ClasseController {
    private final IClasse classe;

    public ClasseController(IClasse classe) {
        this.classe = classe;
    }

    @GetMapping(path = "/classes",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ClasseDTO> getClasses(){
        return classe.getClasses();
    }
    @PostMapping(path ="/classes")
    public ClasseDTO addClasse(@RequestBody ClasseDTO classeDTO){
        return classe.addClasse(classeDTO);
    }
}
