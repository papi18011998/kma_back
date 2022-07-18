package com.example.keur_maman_anthiou_backend.controller;

import com.example.keur_maman_anthiou_backend.dto.ParentDTO;
import com.example.keur_maman_anthiou_backend.entities.Classe;
import com.example.keur_maman_anthiou_backend.entities.Eleve;
import com.example.keur_maman_anthiou_backend.entities.EleveClasse;
import com.example.keur_maman_anthiou_backend.entities.Parent;
import com.example.keur_maman_anthiou_backend.repositories.*;
import com.example.keur_maman_anthiou_backend.services.IParent;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ParentController {
    private final IParent iParent;
    private final GenreRepository genreRepository;
    private final ParentRepository parentRepository;
    private final ClasseRepository classeRepository;
    private  final EleveClasseRepository eleveClasseRepository;
    private final EleveRepository eleveRepository;
    private final Faker faker;
    public ParentController(IParent iParent, GenreRepository genreRepository, ParentRepository parentRepository, ClasseRepository classeRepository, EleveClasseRepository eleveClasseRepository, EleveRepository eleveRepository, Faker faker) {
        this.iParent = iParent;
        this.genreRepository = genreRepository;
        this.parentRepository = parentRepository;
        this.classeRepository = classeRepository;
        this.eleveClasseRepository = eleveClasseRepository;
        this.eleveRepository = eleveRepository;
        this.faker = faker;
    }

    @GetMapping(path = "parents", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ParentDTO> getParents(){
        return iParent.getParents();
    }

    @PostMapping(path = "parents")
    public Parent addParent(@RequestBody ParentForm parentForm){
        // set parent values
        Parent parent = new Parent();
        parent.setPrenom(parentForm.getPrenom());
        parent.setNom(parentForm.getNom());
        parent.setAdresse(parentForm.getAdresse());
        parent.setTelephone(parentForm.getTelephone());
        parent.setCni(parentForm.getCni());
        parent.setIs_active(true);
        parent.setLogin(parentForm.getLogin());
        parent.setPassword(faker.internet().password());
        parent.setGenre(genreRepository.findById(parentForm.getGenre_id()).orElse(null));
        long id = iParent.addParent(parent).getId();
        //set eleve values
        Eleve eleve = new Eleve();
        eleve.setPrenom(parentForm.getPrenomEleve());
        eleve.setNom(parentForm.getNomEleve());
        eleve.setAdresse(parentForm.getAdresseEleve());
        eleve.setGenre(genreRepository.findById(parentForm.getGenre_idEleve()).orElse(null));
        eleve.setPassword(faker.internet().password());
        Classe classe = classeRepository.findById(parentForm.getAnnee()).orElse(null);
        String matricule = classe.getLibelle().substring(0, 2).toUpperCase() +
                faker.number().digits(2) +
                parent.getPrenom().substring(0, 1).toUpperCase() +
                parent.getNom().substring(0, 1).toUpperCase();
        eleve.setLogin(matricule);
        eleve.setMatricule(matricule);
        eleve.setParent(parentRepository.findById(id).orElse(null));
        int year = Calendar.getInstance().get(Calendar.YEAR);
        EleveClasse eleveClasse = new EleveClasse(null,year-1+"-"+year,eleve,classe);
        // flush data
        eleveRepository.save(eleve);
        eleveClasseRepository.save(eleveClasse);
        return parentRepository.findById(id).orElse(null);
    }
}
@Data
@AllArgsConstructor
class ParentForm{
    //Parent Attributes
    private String prenom;
    private String nom;
    private String adresse;
    private String telephone;
    private String cni;
    private String login;
    private long genre_id;
    //Eleve Attributes
    private String prenomEleve;
    private String nomEleve;
    private String adresseEleve;
    private long genre_idEleve;
    private Date date_naissance;
    private long annee;
}