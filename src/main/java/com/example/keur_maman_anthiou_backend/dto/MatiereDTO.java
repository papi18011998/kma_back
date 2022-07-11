package com.example.keur_maman_anthiou_backend.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatiereDTO {
    private Long id;
    private String libelle;
    private int coefficient;
}
