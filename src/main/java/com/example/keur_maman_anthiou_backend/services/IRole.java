package com.example.keur_maman_anthiou_backend.services;


import com.example.keur_maman_anthiou_backend.entities.AppRole;

import java.util.List;

public interface IRole {
    public List<AppRole> getRoles();
    public AppRole findById(Long id);
    public AppRole save(AppRole role);
    public AppRole findByRoleName(String roleName);
}
