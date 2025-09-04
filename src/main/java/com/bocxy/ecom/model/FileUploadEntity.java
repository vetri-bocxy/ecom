package com.bocxy.ecom.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.time.LocalDateTime;
import javax.persistence.*;


@Entity
@Table(name = "uploaded_files")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class FileUploadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "original_file_name", nullable = false)
    private String originalFileName;

    @Column(name = "stored_file_name", nullable = false)
    private String storedFileName;

    @Column(nullable = false)
    private String path;

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    private Long mid;

    @Column(name = "uploaded_at", nullable = false)
    private LocalDateTime uploadedAt;

}
