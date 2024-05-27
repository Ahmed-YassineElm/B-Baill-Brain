package com.bballbrain.fileuploadservice.repository;

import com.bballbrain.fileuploadservice.model.FileMetadata;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileMetadataRepository extends JpaRepository<FileMetadata, Long> {
    
}

