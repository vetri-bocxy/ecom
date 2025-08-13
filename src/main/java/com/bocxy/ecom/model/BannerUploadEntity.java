package com.bocxy.ecom.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "banner_uploaded_files")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class BannerUploadEntity {

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

    @Column(nullable = false)
    private String description;

    @Column(name = "uploaded_at", nullable = false)
    private LocalDateTime uploadedAt;
}
