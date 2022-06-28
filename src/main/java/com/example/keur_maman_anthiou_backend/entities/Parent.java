package com.example.keur_maman_anthiou_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@DiscriminatorValue("parent")
@Data  @NoArgsConstructor
public class Parent extends Utilisateur{
    private String cni;
    @OneToMany(mappedBy = "parent")
    private Collection<Eleve> eleves;

    public Parent(Long id, String prenom, String nom, String login, String password, String adresse, Boolean is_active, Genre genre, @Size(max = 12, message = "Le numero de te telephone de peut pas depasser 9 chiffres") String telephone, String cni) {
        super(id, prenom, nom, login, password, adresse, is_active, genre, telephone);
        this.cni = cni;
    }
}
