package com.example.keur_maman_anthiou_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
@Entity
@Data @AllArgsConstructor @NoArgsConstructor
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double note;
    @Temporal(TemporalType.DATE)
    private Date date_evaluation;
    @ManyToOne
    private Matiere matiere;
    @ManyToOne
    private Eleve eleve;
}
