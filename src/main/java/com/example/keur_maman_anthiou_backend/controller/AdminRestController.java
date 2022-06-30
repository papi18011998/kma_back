package com.example.keur_maman_anthiou_backend.controller;

import com.example.keur_maman_anthiou_backend.dto.AdministrateurDTO;
import com.example.keur_maman_anthiou_backend.services.IAdministrateur;
import com.github.javafaker.Faker;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AdminRestController {
    private final IAdministrateur iAdministrateur;
    private final Faker faker;
    public AdminRestController(IAdministrateur iAdministrateur, Faker faker) {
        this.iAdministrateur = iAdministrateur;
        this.faker = faker;
    }

    @GetMapping(path="/administrateurs", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AdministrateurDTO> getAdmins(){
        return iAdministrateur.getAdmins();
    }

    @GetMapping(value = "/administrateurs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public AdministrateurDTO getAdmin(@PathVariable Long id){
        return iAdministrateur.getAdmin(id);
    }

    @PostMapping(path = "/administrateurs")
    public AdministrateurDTO saveAdmin(@RequestBody AdministrateurDTO administrateurDTO){
        administrateurDTO.setPassword(faker.internet().password());
        return iAdministrateur.saveAdmin(administrateurDTO);
    }
}
