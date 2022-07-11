package com.example.keur_maman_anthiou_backend.services;

import com.example.keur_maman_anthiou_backend.dto.ClasseDTO;
import com.example.keur_maman_anthiou_backend.entities.Classe;
import com.example.keur_maman_anthiou_backend.mappers.KmaMapper;
import com.example.keur_maman_anthiou_backend.repositories.ClasseRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class ClasseImpl implements IClasse{
    private KmaMapper mapper;
    private ClasseRepository classeRepository;

    public ClasseImpl(KmaMapper mapper, ClasseRepository classeRepository) {
        this.mapper = mapper;
        this.classeRepository = classeRepository;
    }

    @Override
    public List<ClasseDTO> getClasses() {
        List<Classe> classeList = classeRepository.findAll();
        List<ClasseDTO> classes =classeList.stream().map(classe -> mapper.classe_to_classeDTO(classe)).collect(Collectors.toList());
        return classes;
    }

    @Override
    public ClasseDTO addClasse(ClasseDTO classeDTO) {
        Classe classe = classeRepository.save(mapper.classeDTO_to_classe(classeDTO));
        return mapper.classe_to_classeDTO(classe);
    }
}
