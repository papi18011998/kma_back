package com.example.keur_maman_anthiou_backend.controller;

import com.example.keur_maman_anthiou_backend.dto.AdministrateurDTO;
import com.example.keur_maman_anthiou_backend.dto.ClasseDTO;
import com.example.keur_maman_anthiou_backend.services.IAdministrateur;
import com.example.keur_maman_anthiou_backend.services.IClasse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AdminRestController {
    private IAdministrateur iAdministrateur;
    private IClasse iClasse;
    public AdminRestController(IAdministrateur iAdministrateur, IClasse iClasse) {
        this.iAdministrateur = iAdministrateur;
        this.iClasse = iClasse;
    }

    @GetMapping("/administrateurs")
    public List<AdministrateurDTO> getAdmins(){
        return iAdministrateur.getAdmins();
    }

    @GetMapping("/administrateurs/{id}")
    public AdministrateurDTO getAdmin(@PathVariable Long id){
        return iAdministrateur.getAdmin(id);
    }
}
