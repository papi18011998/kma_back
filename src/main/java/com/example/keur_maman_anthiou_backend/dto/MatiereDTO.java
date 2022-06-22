package com.example.keur_maman_anthiou_backend.dto;

import com.example.keur_maman_anthiou_backend.entities.Evaluation;
import com.example.keur_maman_anthiou_backend.entities.Professeur;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatiereDTO {
    private Long id;
    private String libelle;
    private int coefficient;
    private Collection<Professeur> professeurs;
    private Collection<Evaluation> evaluations;
}
