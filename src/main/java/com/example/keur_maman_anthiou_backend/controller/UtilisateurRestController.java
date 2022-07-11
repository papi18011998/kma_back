package com.example.keur_maman_anthiou_backend.controller;

import com.example.keur_maman_anthiou_backend.dto.UtilisateurDTO;
import com.example.keur_maman_anthiou_backend.services.IUtilisateur;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
public class UtilisateurRestController {
  private IUtilisateur iUtilisateur;

    public UtilisateurRestController(IUtilisateur iUtilisateur) {
        this.iUtilisateur = iUtilisateur;
    }
    @GetMapping(path="/utilisateurs",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UtilisateurDTO> getUsers(){
        return  iUtilisateur.getUsers();
    }
    @GetMapping(path = "utilisateurs/login/{login}")
    public  UtilisateurDTO findByLogin(@PathVariable(name = "login") String login){
        UtilisateurDTO foundUser = iUtilisateur.findByLogin(login);
        return foundUser;
    }
    @GetMapping(path = "utilisateurs/telephone/{telephone}")
    public  UtilisateurDTO findByTelephone(@PathVariable(name = "telephone") String telephone){
        UtilisateurDTO foundUser = iUtilisateur.findByTelephone(telephone);
        return foundUser;
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
