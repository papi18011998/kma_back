package com.example.keur_maman_anthiou_backend.services;

import com.example.keur_maman_anthiou_backend.dto.ProfesseurDTO;
import com.example.keur_maman_anthiou_backend.entities.Professeur;
import com.example.keur_maman_anthiou_backend.mappers.KmaMapper;
import com.example.keur_maman_anthiou_backend.repositories.ProfesseurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfesseurImpl implements IProfesseur{
    private final ProfesseurRepository professeurRepository;
    private final KmaMapper mapper;

    public ProfesseurImpl(ProfesseurRepository professeurRepository, KmaMapper mapper) {
        this.professeurRepository = professeurRepository;
        this.mapper = mapper;
    }

    @Override
    public List<ProfesseurDTO> getProfesseurs() {
        List<Professeur> professeurs = professeurRepository.findAll();
        return professeurs.stream().map(mapper::professeur_to_professeurDTO).collect(Collectors.toList());
    }

    @Override
    public ProfesseurDTO addProfesseur(ProfesseurDTO professeurDTO) {
        Professeur professeur = mapper.professeurDTO_to_professeur(professeurDTO);
        professeurRepository.save(professeur);
        return  mapper.professeur_to_professeurDTO(professeur);
    }
}
