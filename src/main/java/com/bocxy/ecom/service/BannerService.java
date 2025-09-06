package com.bocxy.ecom.service;

import com.bocxy.ecom.model.BannerUploadEntity;
import com.bocxy.ecom.repository.BannerUploadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static com.google.common.io.Files.getFileExtension;


@Service
public class BannerService {

    @Autowired
    private BannerUploadRepository bannerUploadRepository;

    private static final String BASE_URL = "https://partnersapi.bocxy.com";
    private static final String UPLOAD_DIR = System.getProperty("os.name").toLowerCase().contains("win")
            ? "C:/uploads/ecommerce"
            : "/var/uploads/ecommerce";
//    private static final String BASE_URL = "http://localhost:8089";

//    private static final String UPLOAD_DIR = "C:/uploads/ecommerce";

    private static final String SEND_URL = "/uploads/ecommerce";

    public BannerUploadEntity uploadFile(MultipartFile file,String path, String description) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("File is empty. Please upload a valid image.");
        }
        try {

            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
            String uuid = UUID.randomUUID().toString();
            String extension = getFileExtension(file.getOriginalFilename());
            String storedFileName = timestamp + "_" + uuid +"."+ extension;

            String formattedPath = path.startsWith("/") ? path : "/" + path;
            if (!formattedPath.endsWith("/")) {
                formattedPath += "/";
            }

            File uploadDir = new File(UPLOAD_DIR + formattedPath);
            if (!uploadDir.exists() && !uploadDir.mkdirs()) {
                throw new IOException("Failed to create upload directory: " + uploadDir.getAbsolutePath());
            }

            // Step 3: Store the new file
            File destinationFile = new File(uploadDir, storedFileName);
            file.transferTo(destinationFile);

            String fileUrl = BASE_URL + SEND_URL + formattedPath + storedFileName;

            BannerUploadEntity uploadedFile = BannerUploadEntity.builder()
                    .originalFileName(file.getOriginalFilename())
                    .storedFileName(storedFileName)
                    .path(formattedPath)
                    .url(fileUrl)
                    .mid(902L)
                    .description(description)
                    .uploadedAt(LocalDateTime.now())
                    .build();

            return bannerUploadRepository.save(uploadedFile);

        } catch (IOException e) {
            throw new RuntimeException("Failed to upload the file. Please try again.", e);
        }
    }

    public List<BannerUploadEntity> getAllBanners() {
      return bannerUploadRepository.findAll();
    }

    public String deleteById(Long id) {
        BannerUploadEntity banner = bannerUploadRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Banner not found with ID: " + id));

        // Build full path to file
        String fullFilePath = UPLOAD_DIR + banner.getPath() + banner.getStoredFileName();

        // Delete file from storage
        File fileToDelete = new File(fullFilePath);
        if (fileToDelete.exists()) {
            if (!fileToDelete.delete()) {
                throw new RuntimeException("Failed to delete file from storage: " + fullFilePath);
            }
        }

        // Delete record from DB
        bannerUploadRepository.delete(banner);

        return "Banner deleted successfully";
    }

    public Optional<BannerUploadEntity> findById(Long id) {
      return bannerUploadRepository.findById(id);
    }
}
