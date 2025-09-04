package com.bocxy.ecom.apiService;

import com.bocxy.ecom.model.FileUploadEntity;
import com.bocxy.ecom.service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileUploadApiService {

    @Autowired
    private FileUploadService fileUploadService;

    public FileUploadEntity uploadMultipleProductImages(MultipartFile file, String path, Long id) {
        return fileUploadService.uploadImages(file,path,id);
    }
}
