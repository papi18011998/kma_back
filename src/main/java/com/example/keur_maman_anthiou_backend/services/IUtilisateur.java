package com.example.keur_maman_anthiou_backend.services;

import com.example.keur_maman_anthiou_backend.dto.UtilisateurDTO;

import java.util.List;

public interface IUtilisateur {
    public List<UtilisateurDTO> getUsers();
    public UtilisateurDTO getUser(Long id);
    public UtilisateurDTO change_status(Long id);
    public UtilisateurDTO update_profile(Long id,UtilisateurDTO utilisateurDTO);
    public UtilisateurDTO findByLogin(String login);
    public UtilisateurDTO findByTelephone(String telephone);
}
