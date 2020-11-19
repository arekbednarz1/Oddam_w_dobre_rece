package pl.arekbednarz.oddajwdobrerece.services.Implementation;

import org.springframework.stereotype.Service;
import pl.arekbednarz.oddajwdobrerece.entity.Institution;
import pl.arekbednarz.oddajwdobrerece.repositories.InstitutionRepository;
import pl.arekbednarz.oddajwdobrerece.services.InstitutionService;

import java.util.List;

@Service
public class InstitutionServiceDb implements InstitutionService {
    InstitutionRepository institutionRepository;

    public InstitutionServiceDb(InstitutionRepository institutionRepository) {
        this.institutionRepository = institutionRepository;
    }

    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        institutionRepository.deleteById(id);
    }

    @Override
    public Institution save(Institution institution) {
        return institutionRepository.save(institution);
    }

    @Override
    public Institution findById(Long id) {
        return institutionRepository.findById(id).orElse(null);
    }
}
