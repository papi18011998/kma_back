package com.example.keur_maman_anthiou_backend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
@Data  @NoArgsConstructor
public class Administrateur extends  Utilisateur{
    private String telephone;

    public Administrateur(Long id, String prenom, String nom, String login, String password, String adresse, Boolean is_active, Genre genre, String telephone) {
        super(id, prenom, nom, login, password, adresse, is_active, genre);
        this.telephone = telephone;
    }
}
