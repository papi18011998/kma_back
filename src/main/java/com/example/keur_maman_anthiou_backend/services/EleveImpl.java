package com.example.keur_maman_anthiou_backend.services;

import com.example.keur_maman_anthiou_backend.dto.EleveDTO;
import com.example.keur_maman_anthiou_backend.entities.Eleve;
import com.example.keur_maman_anthiou_backend.mappers.KmaMapper;
import com.example.keur_maman_anthiou_backend.repositories.EleveRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EleveImpl implements IEleve{
    private final EleveRepository eleveRepository;
    private final KmaMapper mapper;

    public EleveImpl(EleveRepository eleveRepository, KmaMapper mapper) {
        this.eleveRepository = eleveRepository;
        this.mapper = mapper;
    }

    @Override
    public Eleve addEleve(Eleve eleve) {
        return eleveRepository.save(eleve);
    }

    @Override
    public List<EleveDTO> getEleves() {
        List<Eleve> eleves = eleveRepository.findAll();
        return eleves.stream().map(mapper::eleve_to_eleveDTO).collect(Collectors.toList());
    }
}
