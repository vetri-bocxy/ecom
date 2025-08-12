package com.bocxy.ecom.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "dealers")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DealerRegistrationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Personal Info
    @Column(name = "full_name", nullable = false)
    private String fullName;

    @Column(name = "gst_number", nullable = false, unique = true, length = 20)
    private String gstNumber;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, length = 15)
    private String phone;

    @Column(name = "alternate_phone", length = 15)
    private String alternatePhone;

    @Column(nullable = false)
    private String password; // Store encrypted

    // Business Info
    @Column(name = "business_name", length = 255)
    private String businessName;

    @Column(name = "pan_number", length = 20)
    private String panNumber;

    @Column(name = "business_type", length = 50)
    private String businessType;

    @Column(name = "business_address", columnDefinition = "TEXT")
    private String businessAddress;

    @Column(length = 100)
    private String city;

    @Column(length = 100)
    private String state;

    @Column(length = 10)
    private String pinCode;

    @Column(length = 10)
    private String businessPinCode;

    @Column(length = 50)
    private String country;

    // Bank Info
    @Column(name = "bank_account_number", length = 30)
    private String bankAccountNumber;

    @Column(name = "bank_ifsc", length = 15)
    private String bankIFSC;

    @Column(name = "bank_name")
    private String bankName;

    @Column(name = "account_holder_name")
    private String accountHolderName;

    // Address Info
    @Column(name = "address_line1", length = 255)
    private String addressLine1;

    // File URLs or Base64 Encoded Strings
    @Column(name = "gst_certificate")
    private String gstCertificate;

    @Column(name = "pan_card")
    private String panCard;

    @Column(name = "address_proof")
    private String addressProof;

    @Column(name = "cancelled_cheque")
    private String cancelledCheque;

    @Column(name = "business_license")
    private String businessLicense;

    @Column(name = "store_logo")
    private String storeLogo;

    // Store Info
    @Column(name = "about_store", length = 1000)
    private String aboutStore;

    @Column(name = "support_email", length = 255)
    private String supportEmail;

    @Column(name = "return_policy", length = 1000)
    private String returnPolicy;

    // Existing Fields
    @Column(nullable = false)
    private String status; // ACTIVE, PENDING, SUSPENDED

    private String rejectionReason;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;
}
