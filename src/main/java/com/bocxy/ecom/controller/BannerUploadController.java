package com.bocxy.ecom.controller;

import com.bocxy.ecom.DTO.ResponseDTO;
import com.bocxy.ecom.apiService.BannerApiService;
import com.bocxy.ecom.model.BannerUploadEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/banner")
public class BannerUploadController {

    private final BannerApiService bannerApiService;

    public BannerUploadController(BannerApiService bannerApiService){
        super();
        this.bannerApiService=bannerApiService;
    }

    @PostMapping("/upload")
    public ResponseEntity<ResponseDTO> uploadFile(
            @RequestParam("description") String description,
            @RequestParam("path") String path,
            @RequestParam("file") MultipartFile file) {
        try {
            BannerUploadEntity response = bannerApiService.saveBanner(file,path,description);
            return ResponseEntity.ok(new ResponseDTO(200, "Success", response));
        } catch (Exception e) {
            return ResponseEntity.status(500)
                    .body(new ResponseDTO(500, "Error uploading banner", e.getMessage()));
        }
    }

}
