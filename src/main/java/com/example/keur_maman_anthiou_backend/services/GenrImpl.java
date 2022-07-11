package com.example.keur_maman_anthiou_backend.services;

import com.example.keur_maman_anthiou_backend.dto.GenreDTO;
import com.example.keur_maman_anthiou_backend.entities.Genre;
import com.example.keur_maman_anthiou_backend.mappers.KmaMapper;
import com.example.keur_maman_anthiou_backend.repositories.GenreRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
@Data @AllArgsConstructor
public class GenrImpl implements IGenre{
    private KmaMapper mapper;
    private GenreRepository genreRepository;
    @Override
    public List<GenreDTO> getGenres() {
        List <Genre> genres = genreRepository.findAll();
        return genres.stream().map(genre -> mapper.genre_to_genreDTO(genre)).collect(Collectors.toList());
    }
}
