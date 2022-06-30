package com.example.keur_maman_anthiou_backend.repositories;

import com.example.keur_maman_anthiou_backend.entities.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<AppRole,Long> {
    public AppRole findByRoleName(String roleName);
}
