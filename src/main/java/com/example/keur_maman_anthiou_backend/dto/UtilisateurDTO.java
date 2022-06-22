package com.example.keur_maman_anthiou_backend.dto;

import com.example.keur_maman_anthiou_backend.entities.Genre;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class UtilisateurDTO {
    private Long id;
    private String prenom;
    private String nom;
    private String login;
    private String adresse;
    private Boolean is_active;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    private Genre genre;
}
