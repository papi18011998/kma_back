package com.example.keur_maman_anthiou_backend.dto;

import com.example.keur_maman_anthiou_backend.entities.Eleve;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToMany;
import java.util.Collection;
@Data @AllArgsConstructor @NoArgsConstructor
public class ParentDTO extends  UtilisateurDTO{
    private String cni;
    private String telephone;
    private Collection<Eleve> eleves;
}
