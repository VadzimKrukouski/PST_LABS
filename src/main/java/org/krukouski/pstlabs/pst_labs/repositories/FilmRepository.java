package org.krukouski.pstlabs.pst_labs.repositories;

import org.krukouski.pstlabs.pst_labs.models.Film;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;
import java.util.Optional;

public interface FilmRepository extends PagingAndSortingRepository<Film, Long> {
    @Override
    Collection<Film> findAll();

    @Override
    Optional<Film> findById(Long id);

    @Override
    <S extends Film> S save(S film);

    @Override
    void deleteById(Long id);

}
