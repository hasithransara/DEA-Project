package com.example.eventsystem.service;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.nio.file.*;

@Service
public class FileStorageService {
    private final Path root = Paths.get("uploads");

    public FileStorageService() {
        try { Files.createDirectories(root); }
        catch (IOException e) { throw new RuntimeException("Could not init upload folder!"); }
    }

    public String save(MultipartFile file) {
        try {
            String filename = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            Files.copy(file.getInputStream(), this.root.resolve(filename));
            return filename;
        } catch (Exception e) { throw new RuntimeException("Could not store file."); }
    }
}