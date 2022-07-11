package com.example.keur_maman_anthiou_backend.controller;

import com.example.keur_maman_anthiou_backend.dto.ProfesseurDTO;
import com.example.keur_maman_anthiou_backend.entities.Classe;
import com.example.keur_maman_anthiou_backend.entities.ClasseProfesseur;
import com.example.keur_maman_anthiou_backend.entities.Professeur;
import com.example.keur_maman_anthiou_backend.mappers.KmaMapper;
import com.example.keur_maman_anthiou_backend.repositories.ClasseProfesseurRepository;
import com.example.keur_maman_anthiou_backend.repositories.ClasseRepository;
import com.example.keur_maman_anthiou_backend.repositories.ProfesseurRepository;
import com.example.keur_maman_anthiou_backend.services.IProfesseur;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.List;

@RestController
@Transactional
@CrossOrigin("*")
public class ProfesseurController {
    private final IProfesseur professeur;
    private final ClasseRepository classeRepository;
    private final ProfesseurRepository professeurRepository;
    private final KmaMapper mapper;
    private final Faker faker;
    private final ClasseProfesseurRepository classeProfesseurRepository;

    public ProfesseurController(IProfesseur professeur, ClasseRepository classeRepository, ProfesseurRepository professeurRepository, KmaMapper mapper, Faker faker, ClasseProfesseurRepository classeProfesseurRepository) {
        this.professeur = professeur;
        this.classeRepository = classeRepository;
        this.professeurRepository = professeurRepository;
        this.mapper = mapper;
        this.faker = faker;
        this.classeProfesseurRepository = classeProfesseurRepository;
    }
    @GetMapping(path = "/professeurs",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProfesseurDTO> getProfesseur(){
        return professeur.getProfesseurs();
    }
    @PostMapping(path="professeurs")
    public  ProfesseurDTO addProfesseur(@RequestBody ProfesseurForm professeurForm){
        professeurForm.getProfesseurDTO().setPassword(faker.internet().password());
        long idNewProfesseur = professeur.addProfesseur(professeurForm.getProfesseurDTO()).getId();
        int year = Calendar.getInstance().get(Calendar.YEAR);
        professeurForm.getClasses().forEach(classeId->{
            Classe classe = classeRepository.findById(classeId).orElse(null);
            ClasseProfesseur annee = new ClasseProfesseur(null,year-1+"-"+year,classe,professeurRepository.findById(idNewProfesseur).orElse(null));
            classeProfesseurRepository.save(annee);
        });
        return professeurForm.getProfesseurDTO();
    }
}

@Data @AllArgsConstructor @NoArgsConstructor
class ProfesseurForm{
    private ProfesseurDTO professeurDTO;
    private List<Long> classes;
}