package org.krukouski.pstlabs.pst_labs.controller;

import org.krukouski.pstlabs.pst_labs.models.Film;
import org.krukouski.pstlabs.pst_labs.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/films")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @GetMapping
    public String getFilms(Model model) {
        Collection<Film> films = filmService.getAll();
        model.addAttribute("films", films);
        return "films/index";
    }

    @GetMapping("/{id}")
    public String getFilm(@PathVariable(name = "id") long id, Model model) {
        Optional<Film> filmById = filmService.getFilmById(id);
        model.addAttribute("film", filmById.get());
        return "films/show";
    }

    @PostMapping
    public String saveFilm(@RequestBody Film film, Model model) {
        filmService.save(film);
        return "films/index";
    }

    @DeleteMapping("/{id}")
    public String deleteFilm(@PathVariable(name = "id") long id, Model model) {
        filmService.delete(id);
        return "films/index";
    }

    @PutMapping("/id")
    public String updateFilm(@RequestBody Film film, @PathVariable (name = "id") long id){
        filmService.update(film,id);
        return "films/index";
    }


}


