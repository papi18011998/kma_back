package com.example.keur_maman_anthiou_backend.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@DiscriminatorValue("professeur")
@Data @NoArgsConstructor
public class Professeur extends  Utilisateur{
    @Temporal(TemporalType.DATE)
    private Date date_prise_fonction;
    @ManyToOne
    private Matiere matiere;

    @OneToMany(mappedBy = "professeur")
    private List<ClasseProfesseur> annees;

    public Professeur(Long id, String prenom, String nom, String login, String password, String adresse, Boolean is_active, Genre genre, @Size(max = 12, message = "Le numero de te telephone de peut pas depasser 9 chiffres") String telephone, Date date_prise_fonction, Matiere matiere) {
        super(id, prenom, nom, login, password, adresse, is_active, genre, telephone);
        this.date_prise_fonction = date_prise_fonction;
        this.matiere = matiere;
    }
}
