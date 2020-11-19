package pl.arekbednarz.oddajwdobrerece.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.arekbednarz.oddajwdobrerece.entity.Donation;

@Repository
public interface DonationRepository extends JpaRepository<Donation, Long> {
}