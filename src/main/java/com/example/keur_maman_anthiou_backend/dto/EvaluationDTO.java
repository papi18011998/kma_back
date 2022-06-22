package com.example.keur_maman_anthiou_backend.dto;

import com.example.keur_maman_anthiou_backend.entities.Eleve;
import com.example.keur_maman_anthiou_backend.entities.Matiere;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationDTO {
    private Long id;
    private double note;
    private Date date_evaluation;
    private Matiere matiere;
    private Eleve eleve;
}
