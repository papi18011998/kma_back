package com.example.keur_maman_anthiou_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Collection;

@Entity
@DiscriminatorValue("parent")
@Data  @NoArgsConstructor
public class Parent extends Utilisateur{
    private String cni;
    private String telephone;
    @OneToMany(mappedBy = "parent")
    private Collection<Eleve> eleves;

    public Parent(Long id, String prenom, String nom, String login, String password, String adresse, Boolean is_active, Genre genre, String cni, String telephone) {
        super(id, prenom, nom, login, password, adresse, is_active, genre);
        this.cni = cni;
        this.telephone = telephone;
    }
}
