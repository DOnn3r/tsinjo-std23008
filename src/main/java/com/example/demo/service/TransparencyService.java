package com.example.demo.service;

import com.example.demo.model.Donation;
import com.example.demo.model.Help;
import com.example.demo.repository.DonationRepository;
import com.example.demo.repository.HelpRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransparencyService {
    private final DonationRepository donationRepository;
    private final HelpRepository helpRepository;

    public TransparencyService(DonationRepository donationRepository, HelpRepository helpRepository) {
        this.donationRepository = donationRepository;
        this.helpRepository = helpRepository;
    }

    public List<Donation> getAllDonations() {
        return donationRepository.findAll();
    }

    public List<Help> getAllHelps() {
        return helpRepository.findAll();
    }
}