package com.example.keur_maman_anthiou_backend.repositories;

import com.example.keur_maman_anthiou_backend.entities.ClasseProfesseur;
import com.example.keur_maman_anthiou_backend.entities.Professeur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@RepositoryRestResource
@CrossOrigin("*")
public interface ClasseProfesseurRepository extends CrudRepository<ClasseProfesseur, Long> {
}

