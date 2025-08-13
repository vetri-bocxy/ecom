package com.bocxy.ecom.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ecom_product_quantity")
public class EcomProductQuantity {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    private int sales;

    private int available;

    private int freeQuantity;

    private int alertCount;

    @OneToOne
    @JoinColumn(name = "product_id")  // Foreign key reference
    private EcomProduct ecomProduct;

    private String storeId;

    private String userId;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
