package com.example.keur_maman_anthiou_backend.services;

import com.example.keur_maman_anthiou_backend.dto.AdministrateurDTO;

import java.util.List;

public interface IAdministrateur {
    public List<AdministrateurDTO> getAdmins();
    public AdministrateurDTO getAdmin(Long id);
    public AdministrateurDTO saveAdmin(AdministrateurDTO administrateurDTO);
}
