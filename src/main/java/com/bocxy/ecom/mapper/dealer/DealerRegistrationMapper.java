package com.bocxy.ecom.mapper.dealer;

import com.bocxy.ecom.DTO.DealerRegistrationResponseDTO;
import com.bocxy.ecom.createDTO.dealer.DealerRegistrationDTO;
import com.bocxy.ecom.model.DealerRegistrationEntity;
import com.bocxy.ecom.repository.DealerRegistrationRepository;
import com.bocxy.ecom.updateDTO.DealerRegistrationUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DealerRegistrationMapper {

    @Autowired
    private DealerRegistrationRepository dealerRegistrationRepository;

    public DealerRegistrationResponseDTO toResponseDTO(DealerRegistrationEntity entity) {
        return DealerRegistrationResponseDTO.builder()
                .id(entity.getId())
                .fullName(entity.getFullName())
                .businessName(entity.getBusinessName())
                .gstNumber(entity.getGstNumber())
                .panNumber(entity.getPanNumber())
                .businessType(entity.getBusinessType())
                .email(entity.getEmail())
                .phone(entity.getPhone())
                .alternatePhone(entity.getAlternatePhone())
                .bankAccountNumber(entity.getBankAccountNumber())
                .bankIFSC(entity.getBankIFSC())
                .bankName(entity.getBankName())
                .accountHolderName(entity.getAccountHolderName())
                .password(entity.getPassword())
                .businessAddress(entity.getBusinessAddress())
                .addressLine1(entity.getAddressLine1())
                .city(entity.getCity())
                .state(entity.getState())
                .pinCode(entity.getPinCode())
                .country(entity.getCountry())
                .gstCertificate(entity.getGstCertificate())
                .panCard(entity.getPanCard())
                .addressProof(entity.getAddressProof())
                .cancelledCheque(entity.getCancelledCheque())
                .businessLicense(entity.getBusinessLicense())
                .storeLogo(entity.getStoreLogo())
                .aboutStore(entity.getAboutStore())
                .supportEmail(entity.getSupportEmail())
                .returnPolicy(entity.getReturnPolicy())
                .status(entity.getStatus())
                .businessPinCode(entity.getBusinessPinCode())
                .rejectionReason(entity.getRejectionReason())
                .build();
    }

    public DealerRegistrationEntity toEntity(DealerRegistrationDTO dto) {
        return DealerRegistrationEntity.builder()
                .fullName(dto.getFullName())
                .businessName(dto.getBusinessName())
                .gstNumber(dto.getGstNumber())
                .panNumber(dto.getPanNumber())
                .businessType(dto.getBusinessType())
                .email(dto.getEmail())
                .phone(dto.getMobile())
                .alternatePhone(dto.getAlternatePhone())
                .bankAccountNumber(dto.getBankAccountNumber())
                .bankIFSC(dto.getBankIFSC())
                .bankName(dto.getBankName())
                .accountHolderName(dto.getAccountHolderName())
                .password(dto.getPassword())
                .businessAddress(dto.getBusinessAddress())
                .addressLine1(dto.getAddressLine1())
                .city(dto.getCity())
                .state(dto.getState())
                .pinCode(dto.getPinCode())
                .country(dto.getCountry())
                .gstCertificate(dto.getGstCertificate())
                .panCard(dto.getPanCard())
                .addressProof(dto.getAddressProof())
                .cancelledCheque(dto.getCancelledCheque())
                .businessLicense(dto.getBusinessLicense())
                .storeLogo(dto.getStoreLogo())
                .aboutStore(dto.getAboutStore())
                .supportEmail(dto.getSupportEmail())
                .returnPolicy(dto.getReturnPolicy())
                .businessPinCode(dto.getBusinessPinCode())
                .status("PENDING")
                .build();
    }

    public DealerRegistrationEntity toEntity(DealerRegistrationUpdateDTO dto) {
        DealerRegistrationEntity entity = dealerRegistrationRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Dealer Not found " + dto.getId()));

        entity.setFullName(dto.getFullName());
        entity.setBusinessName(dto.getBusinessName());
        entity.setGstNumber(dto.getGstNumber());
        entity.setPanNumber(dto.getPanNumber());
        entity.setBusinessType(dto.getBusinessType());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());
        entity.setAlternatePhone(dto.getAlternatePhone());
        entity.setBankAccountNumber(dto.getBankAccountNumber());
        entity.setBankIFSC(dto.getBankIFSC());
        entity.setBankName(dto.getBankName());
        entity.setAccountHolderName(dto.getAccountHolderName());
        entity.setPassword(dto.getPassword());
        entity.setBusinessAddress(dto.getBusinessAddress());
        entity.setAddressLine1(dto.getAddressLine1());
        entity.setCity(dto.getCity());
        entity.setState(dto.getState());
        entity.setPinCode(dto.getPinCode());
        entity.setCountry(dto.getCountry());
        entity.setGstCertificate(dto.getGstCertificate());
        entity.setPanCard(dto.getPanCard());
        entity.setAddressProof(dto.getAddressProof());
        entity.setCancelledCheque(dto.getCancelledCheque());
        entity.setBusinessLicense(dto.getBusinessLicense());
        entity.setStoreLogo(dto.getStoreLogo());
        entity.setAboutStore(dto.getAboutStore());
        entity.setSupportEmail(dto.getSupportEmail());
        entity.setReturnPolicy(dto.getReturnPolicy());
        entity.setStatus(dto.getStatus());
        entity.setBusinessPinCode(dto.getBusinessPinCode());
        entity.setRejectionReason(dto.getRejectionReason());

        return entity;
    }
}
