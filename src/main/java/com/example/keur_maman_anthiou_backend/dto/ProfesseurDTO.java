package com.example.keur_maman_anthiou_backend.dto;

import com.example.keur_maman_anthiou_backend.entities.Classe;
import com.example.keur_maman_anthiou_backend.entities.Matiere;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Collection;
import java.util.Date;
@Data @AllArgsConstructor @NoArgsConstructor
public class ProfesseurDTO extends  UtilisateurDTO{
    private  String telephone;
    private Date date_prise_fonction;
    private Matiere matiere;
    private Collection<Classe> classes;
}
