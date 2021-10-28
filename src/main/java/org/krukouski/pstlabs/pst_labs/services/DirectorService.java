package org.krukouski.pstlabs.pst_labs.services;

import org.krukouski.pstlabs.pst_labs.models.Director;
import org.krukouski.pstlabs.pst_labs.repositories.DirectorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DirectorService {
    private final DirectorRepository directorRepository;

    @Autowired
    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public Page<Director> getAll(PageRequest pageRequest){
        return directorRepository.findAll(pageRequest);
    }

    public Optional<Director> getDirectorById(Long id){
        return directorRepository.findById(id);
    }

    public Director save(Director director){
        return directorRepository.save(director);
    }

    public void delete(Long id){
        directorRepository.deleteById(id);
    }

    public Director update(Director director, Long id){
        Optional<Director> optionalDirector = getDirectorById(id);
        Director updateDirector = optionalDirector.get();
        updateDirector.setName(director.getName());
        updateDirector.setAge(director.getAge());
        return save(updateDirector);
    }


}
