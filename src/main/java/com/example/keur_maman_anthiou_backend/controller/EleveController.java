package com.example.keur_maman_anthiou_backend.controller;

import com.example.keur_maman_anthiou_backend.dto.EleveDTO;
import com.example.keur_maman_anthiou_backend.entities.*;
import com.example.keur_maman_anthiou_backend.repositories.*;
import com.example.keur_maman_anthiou_backend.services.IEleve;
import com.github.javafaker.Faker;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@RestController
@Transactional
@CrossOrigin("*")
public class EleveController {
    private final IEleve ieleve;
    private final ClasseRepository classeRepository;
    private final EleveRepository eleveRepository;
    private final EleveClasseRepository eleveClasseRepository;
    private final ParentRepository parentRepository;
    private final GenreRepository genreRepository;
    private final Faker faker;

    public EleveController(IEleve ieleve, ClasseRepository classeRepository, EleveRepository eleveRepository, EleveClasseRepository eleveClasseRepository, ParentRepository parentRepository, GenreRepository genreRepository, Faker faker) {
        this.ieleve = ieleve;
        this.classeRepository = classeRepository;
        this.eleveRepository = eleveRepository;
        this.eleveClasseRepository = eleveClasseRepository;
        this.parentRepository = parentRepository;
        this.genreRepository = genreRepository;
        this.faker = faker;
    }
    @GetMapping(path="eleves", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<EleveDTO> getEleves(){
        return  ieleve.getEleves();
    }
    @PostMapping("eleves")
    public Eleve addEleve(@RequestBody EleveForm eleveForm) {
        int year = Calendar.getInstance().get(Calendar.YEAR);
        Eleve eleve = new Eleve();
        Genre genre = genreRepository.findById(eleveForm.getGenreId()).orElse(null);
        eleve.setPrenom(eleveForm.getPrenom());
        eleve.setNom(eleveForm.getNom());
        eleve.setPassword(faker.internet().password());
        eleve.setAdresse(eleveForm.getAdresse());
        eleve.setGenre(genre);
        eleve.setIs_active(true);
        eleve.setDate_naissance(eleveForm.getDate_naissance());
        Classe classe = classeRepository.findById(eleveForm.getAnnee()).orElse(null);
        Parent searchParent = parentRepository.findByCni(eleveForm.getCni()).orElse(null);
        if(searchParent == null){
            // Parent and student don't exist
            Genre genreParent = genreRepository.findById(eleveForm.getGenreIdParent()).orElse(null);
            Parent parent = new Parent();
            parent.setPrenom(eleveForm.getPrenomParent());
            parent.setNom(eleveForm.getNomParent());
            parent.setAdresse(eleveForm.getAdresseParent());
            parent.setTelephone(eleveForm.getTelephone());
            parent.setCni(eleveForm.getCni());
            parent.setLogin(eleveForm.getLogin());
            parent.setPassword(faker.internet().password());
            parent.setGenre(genreParent);
            long idParent = parentRepository.save(parent).getId();

            assert classe != null;
            String matricule = classe.getLibelle().substring(0, 2).toUpperCase() +
                    faker.number().digits(2) +
                    parent.getPrenom().substring(0, 1).toUpperCase() +
                    parent.getNom().substring(0, 1).toUpperCase();
            eleve.setParent(parentRepository.findById(idParent).orElse(null));
            eleve.setLogin(matricule);
            eleve.setMatricule(matricule);
            long id = ieleve.addEleve(eleve).getId();

            EleveClasse eleveClasse = new EleveClasse(null,year-1+"-"+year,eleveRepository.findById(id).orElse(null),classe);
            eleveClasseRepository.save(eleveClasse);

            return eleveRepository.findById(eleve.getId()).orElse(null);
        }else {
            // Parent exist
            eleve.setParent(searchParent);

            String matricule = classe.getLibelle().substring(0, 2).toUpperCase() +
                    faker.number().digits(2) +
                    searchParent.getPrenom().substring(0, 1).toUpperCase() +
                    searchParent.getNom().substring(0, 1).toUpperCase();
            eleve.setLogin(matricule);
            eleve.setMatricule(matricule);
            long id = ieleve.addEleve(eleve).getId();

            EleveClasse eleveClasse = new EleveClasse(null,year-1+"-"+year,eleveRepository.findById(id).orElse(null),classe);
            eleveClasseRepository.save(eleveClasse);

            return eleveRepository.findById(eleve.getId()).orElse(null);
        }
    }
}
