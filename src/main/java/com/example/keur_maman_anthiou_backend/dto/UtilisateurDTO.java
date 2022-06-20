package com.example.keur_maman_anthiou_backend.dto;

import com.example.keur_maman_anthiou_backend.entities.Genre;

import javax.persistence.ManyToOne;

public class UtilisateurDTO {
    private Long id;
    private String prenom;
    private String nom;
    private String login;
    private String password;
    private String adresse;
    private Boolean is_active;
    private Genre genre;
}
