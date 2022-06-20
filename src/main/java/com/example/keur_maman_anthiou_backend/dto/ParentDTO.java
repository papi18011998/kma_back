package com.example.keur_maman_anthiou_backend.dto;

import com.example.keur_maman_anthiou_backend.entities.Eleve;

import javax.persistence.OneToMany;
import java.util.Collection;

public class ParentDTO extends  UtilisateurDTO{
    private String cni;
    private String telephone;
    private Collection<Eleve> eleves;
}
