package org.krukouski.pstlabs.pst_labs.controller;

import org.krukouski.pstlabs.pst_labs.models.Genre;
import org.krukouski.pstlabs.pst_labs.services.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;


    @GetMapping
    public String getGenre(Model model){
        Collection<Genre> genres = genreService.getAll();
        model.addAttribute("genres", genres);
        return "genres/index";
    }

    @GetMapping("/{id}")
    public String getGenre(@PathVariable(name = "id") Long id, Model model){
        Optional<Genre> genreById = genreService.getGenreById(id);
        model.addAttribute("genre", genreById.get());
        return "genres/index";
    }

    @PostMapping("/{id}")
    public String saveGenre(@RequestBody Genre genre){
        genreService.save(genre);
        return "genres/index";
    }

    @DeleteMapping("/{id}")
    public String deleteGenre(@PathVariable(name = "id") Long id){
        genreService.delete(id);
        return "genres/index";
    }

    @PutMapping("/{id}")
    public String updateFilm(@RequestBody Genre genre, @PathVariable(name = "id") Long id){
        genreService.update(genre,id);
        return "genres/index";
    }

}
