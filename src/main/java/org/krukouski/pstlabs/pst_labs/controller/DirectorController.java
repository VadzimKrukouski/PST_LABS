package org.krukouski.pstlabs.pst_labs.controller;

import io.swagger.v3.oas.annotations.Operation;
import org.krukouski.pstlabs.pst_labs.models.Director;
import org.krukouski.pstlabs.pst_labs.services.DirectorService;
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
@RequestMapping("api/directors")
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @Operation(summary = "Get all directors pageable")
    @GetMapping
    public ResponseEntity<List<Director>> getDirectors(Model model,
                                                       @RequestParam(defaultValue = "0") int page,
                                                       @RequestParam(defaultValue = "10") int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        Page<Director> pageDirectors = directorService.getAll(pageRequest);
        List<Director> directors = pageDirectors.getContent();
        return new ResponseEntity<>(directors, HttpStatus.OK);
    }

    @Operation(summary = "Get director by id")
    @GetMapping("/{id}")
    public ResponseEntity<Director> getDirector(@PathVariable(name = "id") Long id, Model model) {
        Optional<Director> directorById = directorService.getDirectorById(id);
        Director director = directorById.get();
        return new ResponseEntity<>(director, HttpStatus.OK);
    }

    @Operation(summary = "Create director")
    @PostMapping
    public ResponseEntity<Director> saveDirector(@RequestBody Director director) {
        Director saveDirector = directorService.save(director);
        return new ResponseEntity<>(saveDirector, HttpStatus.OK);
    }

    @Operation(summary = "Delete director")
    @DeleteMapping("/{id}")
    public ResponseEntity<Director> deleteDirector(@PathVariable(name = "id") Long id) {
        directorService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Operation(summary = "update director")
    @PutMapping("/{id}")
    public ResponseEntity<Director> updateDirector(@RequestBody Director director, @PathVariable(name = "id") Long id) {
        Director updateDirector = directorService.update(director, id);
        return new ResponseEntity<>(updateDirector, HttpStatus.OK);
    }
}
