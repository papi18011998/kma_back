package com.example.keur_maman_anthiou_backend.dto;
import com.example.keur_maman_anthiou_backend.entities.Matiere;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data @NoArgsConstructor @AllArgsConstructor
public class ProfesseurDTO extends UtilisateurDTO{
    private Date date_prise_fonction;
    private MatiereDTO matiere;
}
