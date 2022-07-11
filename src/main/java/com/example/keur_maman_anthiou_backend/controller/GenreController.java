package com.example.keur_maman_anthiou_backend.controller;

import com.example.keur_maman_anthiou_backend.dto.GenreDTO;
import com.example.keur_maman_anthiou_backend.services.IGenre;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.hateoas.MediaTypes;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Data @AllArgsConstructor
@RestController
@CrossOrigin("*")
public class GenreController {
    private final IGenre genre;
    @GetMapping(path="/genres", produces = MediaTypes.ALPS_JSON_VALUE)
    public List<GenreDTO> getGenre(){
        return genre.getGenres();
    }
}
