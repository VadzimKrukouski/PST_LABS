package org.krukouski.pstlabs.pst_labs.services;

import org.krukouski.pstlabs.pst_labs.models.Genre;
import org.krukouski.pstlabs.pst_labs.repositories.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Page<Genre> getAll(PageRequest pageRequest){
        return genreRepository.findAll(pageRequest);
    }

    public Optional<Genre> getGenreById(Long id){
        return genreRepository.findById(id);
    }

    public Genre save(Genre genre){
        return genreRepository.save(genre);
    }

    public void delete(Long id){
        genreRepository.deleteById(id);
    }

    public Genre update(Genre genre, Long id){
        Optional<Genre> optionalGenre = getGenreById(id);
        Genre updateGenre = optionalGenre.get();
        updateGenre.setName(genre.getName());
        return save(updateGenre);
    }

}
