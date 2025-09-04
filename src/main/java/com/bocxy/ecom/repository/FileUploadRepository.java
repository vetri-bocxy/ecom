package com.bocxy.ecom.repository;

import com.bocxy.ecom.model.FileUploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FileUploadRepository extends JpaRepository<FileUploadEntity,Long> {

}
