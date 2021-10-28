package org.krukouski.pstlabs.pst_labs.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.krukouski.pstlabs.pst_labs.models.Genre;
import org.krukouski.pstlabs.pst_labs.services.GenreService;
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
@RequestMapping("api/genres")
public class GenreController {
    @Autowired
    private GenreService genreService;

    @Operation(summary = "Get all directors pageable")
    @GetMapping
    public ResponseEntity<List<Genre>> getGenre(Model model,
                                                @RequestParam(defaultValue = "0") int page,
                                                @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Genre> pageGenres = genreService.getAll(pageRequest);
        List<Genre> genres = pageGenres.getContent();
        return new ResponseEntity<>(genres, HttpStatus.OK);
    }

    @Operation(summary = "Get genre by id")
    @GetMapping("/{id}")
    public ResponseEntity<Genre> getGenre(@PathVariable(name = "id") Long id, Model model) {
        Optional<Genre> genreById = genreService.getGenreById(id);
        Genre genre = genreById.get();
        return new ResponseEntity<>(genre, HttpStatus.OK);
    }

    @Operation(summary = "Create genre")
    @PostMapping("/{id}")
    public ResponseEntity<Genre> saveGenre(@RequestBody Genre genre) {
        Genre saveGenre = genreService.save(genre);
        return new ResponseEntity<>(saveGenre, HttpStatus.OK);
    }

    @Operation(summary = "Delete genre")
    @DeleteMapping("/{id}")
    public ResponseEntity<Genre> deleteGenre(@PathVariable(name = "id") Long id) {
        genreService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "update genre")
    @PutMapping("/{id}")
    public ResponseEntity<Genre> updateFilm(@RequestBody Genre genre, @PathVariable(name = "id") Long id) {
        Genre updateGenre = genreService.update(genre, id);
        return new ResponseEntity<>(updateGenre, HttpStatus.OK);
    }

}
