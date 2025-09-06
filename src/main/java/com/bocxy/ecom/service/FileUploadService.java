package com.bocxy.ecom.service;

import com.bocxy.ecom.apiService.FileUploadApiService;
import com.bocxy.ecom.model.FileUploadEntity;
import com.bocxy.ecom.repository.FileUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

@Service
public class FileUploadService {

    @Autowired
    private FileUploadRepository fileUploadRepository;

    private static final String BASE_URL = "https://partnersapi.bocxy.com";
    private static final String UPLOAD_DIR = System.getProperty("os.name").toLowerCase().contains("win")
            ? "C:/uploads/ecommerce"
            : "/var/uploads/ecommerce";
//    private static final String BASE_URL = "http://localhost:8005";

//    private static final String UPLOAD_DIR = "C:/uploads/ecommerce";

    private static final String SEND_URL = "/uploads/ecommerce";



    private String getFileExtension(String fileName) {
        if (fileName != null && fileName.contains(".")) {
            return fileName.substring(fileName.lastIndexOf("."));
        }
        return "";
    }

    public FileUploadEntity uploadImages(MultipartFile file, String path, Long id) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty. Please upload a valid file.");
        }
        try {
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            String uuid = UUID.randomUUID().toString();
            String extension = getFileExtension(file.getOriginalFilename());
            String storedFileName = timestamp + "_" + uuid + extension;

            String formattedPath = path.startsWith("/") ? path : "/" + path;
            if (!formattedPath.endsWith("/")) {
                formattedPath += "/";
            }

            File uploadDir = new File(UPLOAD_DIR + formattedPath);
            if (!uploadDir.exists() && !uploadDir.mkdirs()) {
                throw new IOException("Failed to create upload directory: " + uploadDir.getAbsolutePath());
            }

            File destinationFile = new File(uploadDir, storedFileName);
            file.transferTo(destinationFile);

            String fileUrl = BASE_URL + SEND_URL + formattedPath + storedFileName;

            FileUploadEntity uploadedFile = FileUploadEntity.builder()
                    .originalFileName(file.getOriginalFilename())
                    .storedFileName(storedFileName)
                    .path(formattedPath)
                    .url(fileUrl)
                    .mid(id)
                    .uploadedAt(LocalDateTime.now())
                    .build();

            return fileUploadRepository.save(uploadedFile);

        } catch (IOException e) {
            throw new RuntimeException("Failed to upload the file. Please try again.", e);
        }
    }
}
