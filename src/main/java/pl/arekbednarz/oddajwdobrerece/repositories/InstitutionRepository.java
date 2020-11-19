package pl.arekbednarz.oddajwdobrerece.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arekbednarz.oddajwdobrerece.entity.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}