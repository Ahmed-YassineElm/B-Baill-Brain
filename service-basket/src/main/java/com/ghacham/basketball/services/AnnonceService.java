package com.ghacham.basketball.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ghacham.basketball.entities.Announcement;
import com.ghacham.basketball.repository.AnnonceRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AnnonceService {

    @Autowired
    private AnnonceRepository annonceRepository;
    
    public List<Announcement> getAllAnnouncements() {
        return annonceRepository.findAll();
    }

    // Méthode pour créer une nouvelle annonce
    public Announcement createAnnouncement(Announcement annonce) {
        return annonceRepository.save(annonce);
    }
 // Méthode pour mettre à jour une annonce existante
    public Announcement updateAnnouncement(Long announcementId, Announcement newAnnouncement) {
        Announcement existingAnnouncement = annonceRepository.findById(announcementId)
                .orElseThrow(() -> new EntityNotFoundException("Announcement not found"));

        existingAnnouncement.setTitle(newAnnouncement.getTitle());
        existingAnnouncement.setContent(newAnnouncement.getContent());
        existingAnnouncement.setDate(newAnnouncement.getDate());
        existingAnnouncement.setTeam(newAnnouncement.getTeam());
        existingAnnouncement.setVisibility(newAnnouncement.getVisibility());

        return annonceRepository.save(existingAnnouncement);
    }

    // Méthode pour supprimer une annonce existante
    public void deleteAnnouncement(Long announcementId) {
        annonceRepository.deleteById(announcementId);
    }
}
