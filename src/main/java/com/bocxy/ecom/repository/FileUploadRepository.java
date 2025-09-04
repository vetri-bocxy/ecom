package com.bocxy.ecom.repository;

import com.bocxy.ecom.model.FileUploadEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FileUploadRepository extends JpaRepository<FileUploadEntity,Long> {

    List<FileUploadEntity> findAllByMid(Long id);
}
