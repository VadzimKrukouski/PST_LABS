package org.krukouski.pstlabs.pst_labs.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.krukouski.pstlabs.pst_labs.models.Film;
import org.krukouski.pstlabs.pst_labs.services.FilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/films")
public class FilmController {
    @Autowired
    private FilmService filmService;

    @Operation (summary = "Get all films pageable")
    @GetMapping
    public ResponseEntity<List<Film>> getFilms(Model model,
                                               @RequestParam(defaultValue = "0") int page,
                                               @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);

        Page<Film> pageFilms = filmService.getAll(pageRequest);
        List<Film> films = pageFilms.getContent();
        return new ResponseEntity<>(films, HttpStatus.OK);
    }

    @Operation(summary ="Get film by id" )
    @GetMapping("/{id}")
    public ResponseEntity<Film>getFilm(@PathVariable(name = "id") long id, Model model) {
        Optional<Film> filmById = filmService.getFilmById(id);
        Film film = filmById.get();
        return new ResponseEntity<>(film, HttpStatus.OK);
    }

    @Operation (summary = "Create film")
    @PostMapping
    public ResponseEntity<Film> saveFilm(@RequestBody Film film, Model model) {
        Film saveFilm = filmService.save(film);
        return new ResponseEntity<>(saveFilm, HttpStatus.OK);
    }

    @Operation(summary = "Delete film")
    @DeleteMapping("/{id}")
    public ResponseEntity<Film> deleteFilm(@PathVariable(name = "id") long id, Model model) {
        filmService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "update film")
    @PutMapping("/{id}")
    public ResponseEntity<Film> updateFilm(@RequestBody Film film, @PathVariable (name = "id") long id){
        Film updateFilm = filmService.update(film, id);
        return new ResponseEntity<>(updateFilm, HttpStatus.OK);
    }


}


