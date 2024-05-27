package com.ghacham.basketball.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ghacham.basketball.entities.Announcement;
import com.ghacham.basketball.services.AnnonceService;


@RestController
@RequestMapping("/annonces")
public class AnnonceController {

    @Autowired
    private AnnonceService annonceService;

    @GetMapping
    public List<Announcement> getAllAnnouncements() {
        return annonceService.getAllAnnouncements();
    }
    
    // Endpoint pour créer une nouvelle annonce
    @PostMapping("/creer")
    public ResponseEntity<Announcement> creerAnnonce(@RequestBody Announcement annonce) {
    	Announcement nouvelleAnnonce = annonceService.createAnnouncement(annonce);
        return new ResponseEntity<>(nouvelleAnnonce, HttpStatus.CREATED);
    }
    
 // Endpoint pour mettre à jour une annonce existante
    @PutMapping("/modifier/{id}")
    public ResponseEntity<Announcement> updateAnnouncement(@PathVariable Long id, @RequestBody Announcement announcement) {
        Announcement updatedAnnouncement = annonceService.updateAnnouncement(id, announcement);
        return new ResponseEntity<>(updatedAnnouncement, HttpStatus.OK);
    }

    // Endpoint pour supprimer une annonce existante
    @DeleteMapping("/supprimer/{id}")
    public ResponseEntity<Void> deleteAnnouncement(@PathVariable Long id) {
        annonceService.deleteAnnouncement(id);
        return ResponseEntity.noContent().build();
    }
    
}