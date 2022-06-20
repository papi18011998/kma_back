package com.example.keur_maman_anthiou_backend.repositories;

import com.example.keur_maman_anthiou_backend.entities.Parent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ParentRepository extends JpaRepository<Parent,Long> {
}
