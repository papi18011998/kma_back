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
    @OneToMany(mappedBy = "classe")
    private Collection<EleveClasse> annees;
    @OneToMany(mappedBy = "classe")
    private Collection<ClasseProfesseur> professeurs_classes;
    public Classe(Long id, String libelle) {
        this.id = id;
        this.libelle = libelle;
    }
}
