package com.example.keur_maman_anthiou_backend.entities;

import javax.persistence.*;

@Entity
public class ClasseProfesseur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String annee_scolaire;
    @ManyToOne
    private Classe classe;
    @ManyToOne
    private Professeur professeur;

}
