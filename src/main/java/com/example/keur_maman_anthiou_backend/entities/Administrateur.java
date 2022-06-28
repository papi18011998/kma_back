package com.example.keur_maman_anthiou_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Size;

@Entity
@DiscriminatorValue("admin")
@Data   @AllArgsConstructor
public class Administrateur extends  Utilisateur{

    public Administrateur(Long id, String prenom, String nom, String login, String password, String adresse, Boolean is_active, Genre genre, @Size(max = 12, message = "Le numero de te telephone de peut pas depasser 9 chiffres") String telephone) {
        super(id, prenom, nom, login, password, adresse, is_active, genre, telephone);
    }
}
