package com.example.keur_maman_anthiou_backend.services;


import com.example.keur_maman_anthiou_backend.entities.AppRole;
import com.example.keur_maman_anthiou_backend.repositories.RoleRepository;

import java.util.List;


public class RoleImpl implements IRole{
private RoleRepository roleRepository;

    public RoleImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<AppRole> getRoles() {
        return roleRepository.findAll();
    }

    @Override
    public AppRole findById(Long id) {
        AppRole role = roleRepository.findById(id).orElse(null);
        return role;
    }

    @Override
    public AppRole save(AppRole role) {
        return roleRepository.save(role);
    }

    @Override
    public AppRole findByRoleName(String roleName) {
        return  roleRepository.findByRoleName(roleName);
    }
}
