package com.bocxy.ecom.apiService;

import com.bocxy.ecom.model.BannerUploadEntity;
import com.bocxy.ecom.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class BannerApiService {

    @Autowired
    private BannerService bannerService;

    public BannerUploadEntity saveBanner(MultipartFile file, String path, String description) {
        return bannerService.uploadFile(file,path,description);
    }
}
