package com.example.keur_maman_anthiou_backend.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class EleveForm {
    private String prenom;
    private String nom;
    private String adresse;
    private long genreId;
    private long parentId;
    private Date date_naissance;
    private long annee;
}
