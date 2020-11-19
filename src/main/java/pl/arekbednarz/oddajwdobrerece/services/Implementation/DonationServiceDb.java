package pl.arekbednarz.oddajwdobrerece.services.Implementation;

import org.springframework.stereotype.Service;
import pl.arekbednarz.oddajwdobrerece.entity.Donation;
import pl.arekbednarz.oddajwdobrerece.repositories.DonationRepository;
import pl.arekbednarz.oddajwdobrerece.services.DonationService;

import java.util.List;

@Service
public class DonationServiceDb implements DonationService {

    DonationRepository donationRepository;

    public DonationServiceDb(DonationRepository donationRepository) {
        this.donationRepository = donationRepository;
    }

    @Override

    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    @Override
    public Donation save(Donation donation) {
        return donationRepository.save(donation);
    }
}
