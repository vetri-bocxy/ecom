package com.bocxy.ecom.apiService;

import com.bocxy.ecom.DTO.BannerUploadResponseDTO;
import com.bocxy.ecom.model.BannerUploadEntity;
import com.bocxy.ecom.mapper.BannerUploadMapper;
import com.bocxy.ecom.repository.BannerUploadRepository;
import com.bocxy.ecom.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Service
public class BannerApiService {

    @Autowired
    private BannerService bannerService;

    @Autowired
    private BannerUploadMapper bannerUploadMapper;

    @Autowired
    private BannerUploadRepository bannerUploadRepository;

    public BannerUploadEntity saveBanner(MultipartFile file, String path, String description) {
        return bannerService.uploadFile(file,path,description);
    }

    public List<BannerUploadResponseDTO> getAllBanners() {
        List<BannerUploadEntity> data=bannerService.getAllBanners();
        return data.stream().map(bannerUploadMapper::toDTO).toList();
    }

    public String deleteById(Long id) {
        return bannerService.deleteById(id);
    }

    public BannerUploadResponseDTO getBannerById(Long id) {
        return bannerService.findById(id)
                .map(bannerUploadMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Banner not found"));
    }
}
