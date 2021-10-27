package org.krukouski.pstlabs.pst_labs.repositories;

import org.krukouski.pstlabs.pst_labs.models.Genre;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;
import java.util.Optional;

public interface GenreRepository extends PagingAndSortingRepository<Genre, Long> {
    @Override
    <S extends Genre> S save(S genre);

    @Override
    Optional<Genre> findById(Long id);

    @Override
    Page<Genre> findAll(Pageable pageable);

    @Override
    void deleteById(Long id);
}
