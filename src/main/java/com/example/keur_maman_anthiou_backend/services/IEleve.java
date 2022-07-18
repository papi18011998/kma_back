package com.example.keur_maman_anthiou_backend.services;

import com.example.keur_maman_anthiou_backend.dto.EleveDTO;
import com.example.keur_maman_anthiou_backend.entities.Eleve;

import java.util.List;


public interface IEleve {
    public Eleve addEleve(Eleve eleve);
    public List<EleveDTO> getEleves();
}
