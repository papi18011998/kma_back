package com.example.keur_maman_anthiou_backend.services;

import com.example.keur_maman_anthiou_backend.dto.ParentDTO;
import com.example.keur_maman_anthiou_backend.entities.Parent;

import java.util.List;

public interface IParent {
    public Parent addParent(Parent parent);
    public List<ParentDTO> getParents();
    public ParentDTO findByCni(String cni);
}
