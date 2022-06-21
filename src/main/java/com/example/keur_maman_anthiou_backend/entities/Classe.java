package com.example.keur_maman_anthiou_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Data  @NoArgsConstructor
public class Classe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String libelle;
    @OneToMany
    private Collection<Eleve> eleves;
    @ManyToMany
    private Collection<Professeur> professeurs;

    public Classe(Long id, String libelle, Collection<Eleve> eleves) {
        this.id = id;
        this.libelle = libelle;
        this.eleves = eleves;
    }
}
