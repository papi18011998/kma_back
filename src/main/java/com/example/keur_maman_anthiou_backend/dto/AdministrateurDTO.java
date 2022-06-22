package com.example.keur_maman_anthiou_backend.dto;

import com.example.keur_maman_anthiou_backend.entities.Genre;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor @NoArgsConstructor
public class AdministrateurDTO extends UtilisateurDTO{
    private String telephone;
}
