package com.example.keur_maman_anthiou_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor
public class EleveDTO extends  UtilisateurDTO{
    private String matricule;
    private Date date_naissance;
}
