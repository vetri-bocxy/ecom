package com.bocxy.ecom.updateDTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DealerRegistrationUpdateDTO {

    private Long id;
    private String fullName;
    private String gstNumber;
    private String email;
    private String phone;
    private String alternatePhone;
    private String password;

    // Business Info
    private String businessName;
    private String panNumber;
    private String businessType;
    private String businessAddress;
    private String city;
    private String state;
    private String pinCode;
    private String country;

    // Bank Info
    private String bankAccountNumber;
    private String bankIFSC;
    private String bankName;
    private String accountHolderName;

    // Address Info
    private String addressLine1;

    // File URLs or Base64 Encoded Strings
    private String gstCertificate;
    private String panCard;
    private String addressProof;
    private String cancelledCheque;
    private String businessLicense;
    private String storeLogo;

    // Store Info
    private String aboutStore;
    private String supportEmail;
    private String returnPolicy;
    private String businessPinCode;

    // Status Info
    private String status;
    private String rejectionReason;
}
