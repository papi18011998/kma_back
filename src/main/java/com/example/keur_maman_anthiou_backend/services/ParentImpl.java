package com.example.keur_maman_anthiou_backend.services;

import com.example.keur_maman_anthiou_backend.dto.ParentDTO;
import com.example.keur_maman_anthiou_backend.entities.Parent;
import com.example.keur_maman_anthiou_backend.mappers.KmaMapper;
import com.example.keur_maman_anthiou_backend.repositories.ParentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParentImpl implements  IParent{
    private final ParentRepository parentRepository;
    private final KmaMapper mapper;

    public ParentImpl(ParentRepository parentRepository, KmaMapper mapper) {
        this.parentRepository = parentRepository;
        this.mapper = mapper;
    }

    @Override
    public Parent addParent(Parent parent) {
        return parentRepository.save(parent);
    }

    @Override
    public List<ParentDTO> getParents() {
        List<Parent> parents = parentRepository.findAll();
        return  parents.stream().map(mapper::parent_to_parentDTO).collect(Collectors.toList());
    }

    @Override
    public ParentDTO findByCni(String cni) {
        Parent parent = parentRepository.findByCni(cni).orElse(null);
        return (parent == null)?null:mapper.parent_to_parentDTO(parent);
    }
}
