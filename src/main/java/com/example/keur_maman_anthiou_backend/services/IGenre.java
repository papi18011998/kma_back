package com.example.keur_maman_anthiou_backend.services;

import com.example.keur_maman_anthiou_backend.dto.GenreDTO;

import java.util.List;

public interface IGenre {
    public List<GenreDTO> getGenres();
}
