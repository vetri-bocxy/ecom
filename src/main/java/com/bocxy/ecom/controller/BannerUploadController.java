package com.bocxy.ecom.controller;

import com.bocxy.ecom.DTO.BannerUploadResponseDTO;
import com.bocxy.ecom.DTO.ResponseDTO;
import com.bocxy.ecom.apiService.BannerApiService;
import com.bocxy.ecom.model.BannerUploadEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    @GetMapping("/getAll")
    public ResponseEntity<ResponseDTO> getAllBanners(){
        List<BannerUploadResponseDTO> responseDTO=bannerApiService.getAllBanners();
        return ResponseEntity.ok(new ResponseDTO(200,"Success",responseDTO));
    }

    @GetMapping("/getById")
    public ResponseEntity<ResponseDTO> getBannerById(@RequestParam Long id){
        BannerUploadResponseDTO responseDTO=bannerApiService.getBannerById(id);
        return ResponseEntity.ok(new ResponseDTO(200,"Success",responseDTO));
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<ResponseDTO> deleteById(@RequestParam Long id){
        String message=bannerApiService.deleteById(id);
        return ResponseEntity.ok(new ResponseDTO(200,"Success",message));
    }

}
