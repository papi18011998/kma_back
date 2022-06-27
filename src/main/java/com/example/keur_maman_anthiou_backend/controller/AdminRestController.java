package com.example.keur_maman_anthiou_backend.controller;

import com.example.keur_maman_anthiou_backend.dto.AdministrateurDTO;
import com.example.keur_maman_anthiou_backend.services.IAdministrateur;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AdminRestController {
    private final IAdministrateur iAdministrateur;
    public AdminRestController(IAdministrateur iAdministrateur) {
        this.iAdministrateur = iAdministrateur;
    }

    @GetMapping(path="/administrateurs")
    public List<AdministrateurDTO> getAdmins(){
        return iAdministrateur.getAdmins();
    }

    @GetMapping("/administrateurs/{id}")
    public AdministrateurDTO getAdmin(@PathVariable Long id){
        return iAdministrateur.getAdmin(id);
    }
}
