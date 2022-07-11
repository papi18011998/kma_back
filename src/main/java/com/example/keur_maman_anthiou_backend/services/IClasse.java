package com.example.keur_maman_anthiou_backend.services;

import com.example.keur_maman_anthiou_backend.dto.ClasseDTO;

import java.util.List;
public interface IClasse {
    public List<ClasseDTO> getClasses();
    public ClasseDTO addClasse(ClasseDTO classeDTO);
}
