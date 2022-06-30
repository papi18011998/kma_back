package com.example.keur_maman_anthiou_backend.services;

import com.example.keur_maman_anthiou_backend.dto.AdministrateurDTO;
import com.example.keur_maman_anthiou_backend.entities.Administrateur;
import com.example.keur_maman_anthiou_backend.mappers.KmaMapper;
import com.example.keur_maman_anthiou_backend.repositories.AdministrateurRepository;
import lombok.Data;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
public class AdministrateurImpl implements IAdministrateur{
    private KmaMapper mapper;
    private AdministrateurRepository administrateurRepository;

    public AdministrateurImpl(KmaMapper mapper, AdministrateurRepository administrateurRepository) {
        this.mapper = mapper;
        this.administrateurRepository = administrateurRepository;
    }

    @Override
    public List<AdministrateurDTO> getAdmins() {
        List<Administrateur> administrateurs =administrateurRepository.findAll();
        List<AdministrateurDTO> list = administrateurs.stream().map(administrateur -> mapper.admin_to_adminDTO(administrateur)).collect(Collectors.toList());
        return list;
    }

    @Override
    public AdministrateurDTO getAdmin(Long id) {
        Administrateur administrateur = administrateurRepository.findById(id).orElse(null);
        return mapper.admin_to_adminDTO(administrateur);
    }

    @Override
    public AdministrateurDTO saveAdmin(AdministrateurDTO administrateurDTO) {
        Administrateur administrateur = mapper.adminDTO_to_admin(administrateurDTO);
        administrateurRepository.save(administrateur);
        return mapper.admin_to_adminDTO(administrateur);
    }
}
