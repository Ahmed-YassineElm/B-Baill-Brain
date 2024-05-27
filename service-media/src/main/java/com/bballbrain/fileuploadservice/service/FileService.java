package com.bballbrain.fileuploadservice.service;

import com.bballbrain.fileuploadservice.model.FileMetadata;
import com.bballbrain.fileuploadservice.repository.FileMetadataRepository;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

@Service
public class FileService {
    @Autowired
    private FileMetadataRepository fileMetadataRepository;

    private final Path rootLocation = Paths.get("C:/upload-dir");


    @PostConstruct
    public void init() {
        try {
            Files.createDirectories(rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not initialize storage location", e);
        }
    }

    public FileMetadata store(MultipartFile file) {
        try {
            if (file.isEmpty()) {
                throw new RuntimeException("Failed to store empty file");
            }

            // Résoudre le chemin du fichier à télécharger
            Path destinationFile = this.rootLocation.resolve(
                            Paths.get(StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()))))
                    .normalize().toAbsolutePath();

            // Copier le fichier vers l'emplacement de destination
            Files.copy(file.getInputStream(), destinationFile, StandardCopyOption.REPLACE_EXISTING);

            // Enregistrer les métadonnées du fichier dans la base de données
            FileMetadata metadata = new FileMetadata(
                    null,
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getSize(),
                    LocalDateTime.now()
            );
            return fileMetadataRepository.save(metadata);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }



    // Méthode pour lister tous les fichiers et leurs métadonnées
    public ResponseEntity<List<FileMetadata>> listAllFiles() {
        try {
            List<FileMetadata> fileMetadataList = fileMetadataRepository.findAll();
            return ResponseEntity.ok().body(fileMetadataList);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Méthode pour charger tous les fichiers stockés
    public Stream<Path> loadAll() {
        try {
            return Files.walk(rootLocation, 1)
                    .filter(path -> !path.equals(rootLocation))
                    .map(rootLocation::relativize);
        } catch (IOException e) {
            throw new RuntimeException("Failed to read stored files", e);
        }
    }

    public Resource loadAsResource(String filename) {
        try {
            Path file = rootLocation.resolve(filename).normalize().toAbsolutePath();
            UrlResource resource = new UrlResource(file.toUri());
            if (resource.exists() && resource.isReadable()) {
                return (Resource) resource;
            } else {
                throw new RuntimeException("Could not read file: " + filename);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("Could not read file: " + filename, e);
        }
    }
}

