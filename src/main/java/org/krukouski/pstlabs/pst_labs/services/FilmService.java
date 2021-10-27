package org.krukouski.pstlabs.pst_labs.services;

import org.krukouski.pstlabs.pst_labs.models.Film;
import org.krukouski.pstlabs.pst_labs.repositories.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class FilmService {
    private final FilmRepository filmRepository;

    @Autowired
    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public Page<Film> getAll(PageRequest pageRequest){
        return filmRepository.findAll(pageRequest);
    }

    public Optional<Film> getFilmById(Long id){
        return filmRepository.findById(id);
    }

    public Film save(Film film){
        return filmRepository.save(film);
    }

    public void delete(Long id){
        filmRepository.deleteById(id);
    }

    public Film update(Film film, Long id){
        Optional<Film> optionalFilm = getFilmById(id);
        Film updateFilm = optionalFilm.get();
        updateFilm.setName(film.getName());
        updateFilm.setDescription(film.getDescription());
        return  save(updateFilm);
    }
}
