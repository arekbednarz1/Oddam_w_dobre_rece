package pl.arekbednarz.oddajwdobrerece.services;

import pl.arekbednarz.oddajwdobrerece.entity.Institution;

import java.util.List;

public interface InstitutionService {
    List<Institution> findAll();
    void deleteById(Long id);
    Institution save(Institution institution);
    Institution findById(Long id);
}
