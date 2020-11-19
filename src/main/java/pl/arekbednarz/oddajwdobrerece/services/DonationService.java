package pl.arekbednarz.oddajwdobrerece.services;

import pl.arekbednarz.oddajwdobrerece.entity.Donation;

import java.util.List;

public interface DonationService {
    List<Donation> findAll();
    Donation save(Donation donation);

}
