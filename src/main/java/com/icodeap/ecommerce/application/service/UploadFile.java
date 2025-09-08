package com.icodeap.ecommerce.application.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class UploadFile {
    private final Path folder = Paths.get("images");
    private final String IMG_DEFAULT = "default.jpg";

    public String upload(MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()) {
            Files.createDirectories(folder);
            Path path = folder.resolve(multipartFile.getOriginalFilename());
            Files.write(path, multipartFile.getBytes());
            return multipartFile.getOriginalFilename();
        }
        return IMG_DEFAULT;
    }

    public void delete(String nameFile) {
        try {
            Files.deleteIfExists(folder.resolve(nameFile));
        } catch (IOException ignored) {
        }
    }

}
