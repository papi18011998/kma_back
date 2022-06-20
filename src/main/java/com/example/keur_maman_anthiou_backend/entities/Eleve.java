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
    @Column(nullable = false, unique = true, length = 50)
    private String matricule;
    @Temporal(TemporalType.DATE)
    private Date date_naissance;
    @ManyToOne
    private  Parent parent;
    @ManyToOne
    private Classe classe;
    @OneToMany
    private Collection<Evaluation> evaluations;
}
