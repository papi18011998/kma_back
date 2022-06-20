package com.example.keur_maman_anthiou_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;

@Entity
@DiscriminatorValue("professeur")
@Data @AllArgsConstructor @NoArgsConstructor
public class Professeur extends  Utilisateur{
    private  String telephone;
    @Temporal(TemporalType.DATE)
    private Date date_prise_fonction;
    @ManyToOne
    private Matiere matiere;
    @ManyToMany
    private Collection<Classe>classes;
}
