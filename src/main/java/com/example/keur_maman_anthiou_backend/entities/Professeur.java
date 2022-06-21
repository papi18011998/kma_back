package com.example.keur_maman_anthiou_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@DiscriminatorValue("professeur")
@Data @NoArgsConstructor
public class Professeur extends  Utilisateur{
    private  String telephone;
    @Temporal(TemporalType.DATE)
    private Date date_prise_fonction;
    @ManyToOne
    private Matiere matiere;
    @ManyToMany
    private Collection<Classe>classes;

    public Professeur(Long id, String prenom, String nom, String login, String password, String adresse, Boolean is_active, Genre genre, String telephone, Date date_prise_fonction, Matiere matiere) {
        super(id, prenom, nom, login, password, adresse, is_active, genre);
        this.telephone = telephone;
        this.date_prise_fonction = date_prise_fonction;
        this.matiere = matiere;
    }
}
