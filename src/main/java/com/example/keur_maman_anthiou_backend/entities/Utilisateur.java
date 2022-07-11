package com.example.keur_maman_anthiou_backend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Collection;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "role",length = 20)
@Data @NoArgsConstructor
public class  Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    protected String prenom;
    protected String nom;
    @Column(name = "login",unique = true)
    protected String login;
    protected String password;
    protected String adresse;
    protected Boolean is_active;
    @ManyToOne
    protected Genre genre;
    @Size(max = 12,message = "Le numero de te telephone de peut pas depasser 9 chiffres")
    @Column(name = "telephone",nullable = true,unique = true)
    private String telephone;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles;

    public Utilisateur(Long id, String prenom, String nom, String login, String password, String adresse, Boolean is_active, Genre genre, String telephone) {
        this.id = id;
        this.prenom = prenom;
        this.nom = nom;
        this.login = login;
        this.password = password;
        this.adresse = adresse;
        this.is_active = is_active;
        this.genre = genre;
        this.telephone = telephone;
    }
}
