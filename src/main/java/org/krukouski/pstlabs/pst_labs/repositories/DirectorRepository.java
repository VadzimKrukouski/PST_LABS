package org.krukouski.pstlabs.pst_labs.repositories;

import org.krukouski.pstlabs.pst_labs.models.Director;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface DirectorRepository extends PagingAndSortingRepository<Director, Long> {
    @Override
    Page<Director> findAll(Pageable pageable);

    @Override
    Optional<Director> findById(Long id);

    @Override
    <S extends Director> S save(S director);

    @Override
    void deleteById(Long id);
}
