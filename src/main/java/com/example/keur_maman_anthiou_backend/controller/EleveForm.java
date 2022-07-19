package com.example.keur_maman_anthiou_backend.controller;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class EleveForm {
//    Eleve Informations
    private String prenom;
    private String nom;
    private String adresse;
    private long genreId;
    private Date date_naissance;
    private long annee;
//    ParentInformations
    private String prenomParent;
    private String nomParent;
    private String adresseParent;
    private String telephone;
    private String cni;
    private String login;
    private long genreIdParent;
}
