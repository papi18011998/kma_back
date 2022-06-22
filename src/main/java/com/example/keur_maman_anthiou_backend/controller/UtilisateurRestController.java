package com.example.keur_maman_anthiou_backend.controller;

import com.example.keur_maman_anthiou_backend.dto.UtilisateurDTO;
import com.example.keur_maman_anthiou_backend.services.IUtilisateur;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UtilisateurRestController {
  private IUtilisateur iUtilisateur;

    public UtilisateurRestController(IUtilisateur iUtilisateur) {
        this.iUtilisateur = iUtilisateur;
    }
    @GetMapping("/utilisateurs")
    public List<UtilisateurDTO> getUsers(){
        return  iUtilisateur.getUsers();
    }

    @GetMapping("/utilisateurs/{id}")
    public UtilisateurDTO getUser(@PathVariable Long id){
        return  iUtilisateur.getUser(id);
    }

    @PutMapping("/utilisateurs/status/{id}")
    public UtilisateurDTO change_status(@PathVariable Long id){
        return iUtilisateur.change_status(id);
    }
    @PutMapping("/utilisateurs/{id}")
    public UtilisateurDTO update_profile(@PathVariable Long id, @RequestBody UtilisateurDTO utilisateurDTO){
        return iUtilisateur.update_profile(id, utilisateurDTO);
    }
}
