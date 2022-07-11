package com.example.keur_maman_anthiou_backend.services;

import com.example.keur_maman_anthiou_backend.dto.ProfesseurDTO;

import java.util.List;

public interface IProfesseur {
    public List<ProfesseurDTO> getProfesseurs();
    public ProfesseurDTO addProfesseur(ProfesseurDTO professeurDTO);
}
