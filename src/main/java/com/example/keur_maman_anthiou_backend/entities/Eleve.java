package com.example.keur_maman_anthiou_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@DiscriminatorValue("eleve")
@Data @AllArgsConstructor @NoArgsConstructor
public class Eleve extends Utilisateur{
    private String matricule;
    @Temporal(TemporalType.DATE)
    private Date date_naissance;
    @ManyToOne
    private  Parent parent;
    @ManyToOne
    private Classe classe;
    @OneToMany
    private Collection<Evaluation> evaluations;

    public Eleve(Long id, String prenom, String nom, String login, String password, String adresse, Boolean is_active, Genre genre, String matricule, Date date_naissance, Parent parent, Classe classe) {
        super(id, prenom, nom, login, password, adresse, is_active, genre);
        this.matricule = matricule;
        this.date_naissance = date_naissance;
        this.parent = parent;
        this.classe = classe;
    }
}
