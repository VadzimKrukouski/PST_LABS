package org.krukouski.pstlabs.pst_labs.controller;

import org.krukouski.pstlabs.pst_labs.models.Director;
import org.krukouski.pstlabs.pst_labs.services.DirectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/directors")
public class DirectorController {
    @Autowired
    private DirectorService directorService;

    @GetMapping
    public String getDirectors(Model model){
        Collection<Director> directors = directorService.getAll();
        model.addAttribute("directors", directors);
        return "directors/index";
    }

    @GetMapping("/{id}")
    public  String getDirector(@PathVariable (name = "id") Long id, Model model){
        Optional<Director> directorById = directorService.getDirectorById(id);
        model.addAttribute("director", directorById.get());
        return "directors/show";
    }

    @PostMapping
    public String saveDirector(@RequestBody Director director){
        directorService.save(director);
        return "directors/index";
    }

    @DeleteMapping("/id")
    public String deleteDirector(@PathVariable(name = "id")Long id){
        directorService.delete(id);
        return "directors/index";
    }

    @PutMapping("/id")
    public String updateDirector(@RequestBody Director director, @PathVariable(name = "id") Long id){
        directorService.update(director,id);
        return "directors/index";
    }
}
