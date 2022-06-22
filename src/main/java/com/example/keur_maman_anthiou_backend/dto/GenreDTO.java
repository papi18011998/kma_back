package com.example.keur_maman_anthiou_backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GenreDTO {
    private Long id;
    private String libelle;
}
