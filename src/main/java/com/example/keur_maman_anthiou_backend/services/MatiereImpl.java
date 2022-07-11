package com.example.keur_maman_anthiou_backend.services;

import com.example.keur_maman_anthiou_backend.dto.MatiereDTO;
import com.example.keur_maman_anthiou_backend.entities.Matiere;
import com.example.keur_maman_anthiou_backend.mappers.KmaMapper;
import com.example.keur_maman_anthiou_backend.repositories.MatiereRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MatiereImpl implements IMatiere{
    private final MatiereRepository matiereRepository;
    private final KmaMapper mapper;

    public MatiereImpl(MatiereRepository matiereRepository, KmaMapper mapper) {
        this.matiereRepository = matiereRepository;
        this.mapper = mapper;
    }

    @Override
    public List<MatiereDTO> getMatieres() {
        List<Matiere> matieres = matiereRepository.findAll();
        return  matieres.stream().map(mapper::matiere_to_matiereDTO).collect(Collectors.toList());
    }

    @Override
    public MatiereDTO getMatiere() {
        return null;
    }

    @Override
    public MatiereDTO save(MatiereDTO matiereDTO) {
        return null;
    }

    @Override
    public MatiereDTO updateMatiere(long id, MatiereDTO matiereDTO) {
        return null;
    }
}
