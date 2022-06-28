package com.example.keur_maman_anthiou_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class EleveClasse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String annee_scolaire;
    @ManyToOne
    private Eleve eleve;
    @ManyToOne
    private Classe classe;
}
