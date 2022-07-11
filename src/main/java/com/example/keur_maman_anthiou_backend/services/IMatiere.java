package com.example.keur_maman_anthiou_backend.services;

import com.example.keur_maman_anthiou_backend.dto.MatiereDTO;

import java.util.List;

public interface IMatiere {
    public List<MatiereDTO> getMatieres();
    public MatiereDTO getMatiere();
    public MatiereDTO save(MatiereDTO matiereDTO);
    public MatiereDTO updateMatiere(long id, MatiereDTO matiereDTO);
}
