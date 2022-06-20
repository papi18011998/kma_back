package com.example.keur_maman_anthiou_backend.dto;

import com.example.keur_maman_anthiou_backend.entities.Evaluation;
import com.example.keur_maman_anthiou_backend.entities.Professeur;
import java.util.Collection;

public class MatiereDTO {
    private Long id;
    private String libelle;
    private int coefficient;
    private Collection<Professeur> professeurs;
    private Collection<Evaluation> evaluations;
}
