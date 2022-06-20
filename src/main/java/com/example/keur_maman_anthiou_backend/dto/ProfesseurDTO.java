package com.example.keur_maman_anthiou_backend.dto;

import com.example.keur_maman_anthiou_backend.entities.Classe;
import com.example.keur_maman_anthiou_backend.entities.Matiere;
import java.util.Collection;
import java.util.Date;

public class ProfesseurDTO extends  UtilisateurDTO{
    private  String telephone;
    private Date date_prise_fonction;
    private Matiere matiere;
    private Collection<Classe> classes;
}
