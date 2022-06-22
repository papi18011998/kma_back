package com.example.keur_maman_anthiou_backend.services;

import com.example.keur_maman_anthiou_backend.dto.UtilisateurDTO;
import com.example.keur_maman_anthiou_backend.entities.Utilisateur;
import com.example.keur_maman_anthiou_backend.mappers.KmaMapper;
import com.example.keur_maman_anthiou_backend.repositories.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class UtilisateurImpl implements IUtilisateur {
    private UtilisateurRepository utilisateurRepository;
    private KmaMapper mapper;

    public UtilisateurImpl(UtilisateurRepository utilisateurRepository, KmaMapper mapper) {
        this.utilisateurRepository = utilisateurRepository;
        this.mapper = mapper;
    }

    @Override
    public List<UtilisateurDTO> getUsers() {
        List<Utilisateur> utilisateurs = utilisateurRepository.findAll();
        return utilisateurs.stream().map(utilisateur -> mapper.utilisateur_to_utilisateurDTO(utilisateur)).collect(Collectors.toList());
    }

    @Override
    public UtilisateurDTO getUser(Long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
        return mapper.utilisateur_to_utilisateurDTO(utilisateur);
    }

    @Override
    public UtilisateurDTO change_status(Long id) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
        if(utilisateur!=null){
            utilisateur.setIs_active(!utilisateur.getIs_active());
            utilisateurRepository.save(utilisateur);
        }
        return mapper.utilisateur_to_utilisateurDTO(utilisateur);
    }

    @Override
    public UtilisateurDTO update_profile(Long id,UtilisateurDTO utilisateurDTO) {
        Utilisateur utilisateur = utilisateurRepository.findById(id).orElse(null);
        if(utilisateur!=null){
            utilisateur.setAdresse(utilisateurDTO.getAdresse());
            utilisateur.setLogin(utilisateurDTO.getLogin());
            utilisateur.setNom(utilisateurDTO.getNom());
            utilisateur.setPrenom(utilisateurDTO.getPrenom());
            utilisateur.setPassword(utilisateurDTO.getPassword());
            utilisateurRepository.save(utilisateur);
        }
        return mapper.utilisateur_to_utilisateurDTO(utilisateur);
    }
}
