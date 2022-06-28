package com.example.keur_maman_anthiou_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role",length = 20)
@Data @NoArgsConstructor @AllArgsConstructor
public class  Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String prenom;
    protected String nom;
    protected String login;
    protected String password;
    protected String adresse;
    protected Boolean is_active;
    @ManyToOne
    protected Genre genre;
    @Size(max = 12,message = "Le numero de te telephone de peut pas depasser 9 chiffres")
    @Column(name = "telephone",nullable = true)
    private String telephone;
}
