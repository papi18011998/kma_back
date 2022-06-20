package com.example.keur_maman_anthiou_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("admin")
@Data @AllArgsConstructor @NoArgsConstructor
public class Administrateur extends  Utilisateur{
    private String telephone;
}
