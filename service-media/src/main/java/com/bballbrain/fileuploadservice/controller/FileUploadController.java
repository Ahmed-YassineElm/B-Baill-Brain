package com.bballbrain.fileuploadservice.controller;

import com.bballbrain.fileuploadservice.model.FileMetadata;
import com.bballbrain.fileuploadservice.service.FileService;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Controller
@RequestMapping("/files")
public class FileUploadController {
    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public ResponseEntity<FileMetadata> handleFileUpload(@RequestParam("file") MultipartFile file) {
        FileMetadata metadata = fileService.store(file);
        return ResponseEntity.ok(metadata);
    }
    @GetMapping("/upload")
    public String showUploadForm(Model model) {
        return "uploadVideo";
    }


    @GetMapping("/files")
    public ResponseEntity<List<FileMetadata>> listAllFiles() {
        return fileService.listAllFiles();
    }

    @GetMapping("/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) {
        Resource file = fileService.loadAsResource(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.name() + "\"")
                .body(file);
    }
}

