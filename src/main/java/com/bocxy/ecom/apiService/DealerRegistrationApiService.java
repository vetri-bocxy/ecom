package com.bocxy.ecom.apiService;

import com.bocxy.ecom.DTO.DealerRegistrationResponseDTO;
import com.bocxy.ecom.Exception.UsernameAlreadyExistsException;
import com.bocxy.ecom.createDTO.dealer.DealerRegistrationDTO;
import com.bocxy.ecom.mapper.dealer.DealerRegistrationMapper;
import com.bocxy.ecom.model.DealerRegistrationEntity;
import com.bocxy.ecom.service.DealerRegistrationService;
import com.bocxy.ecom.updateDTO.DealerRegistrationUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DealerRegistrationApiService {

    @Autowired
    private DealerRegistrationService dealerRegistrationService;

    @Autowired
    private DealerRegistrationMapper dealerRegistrationMapper;

    public DealerRegistrationResponseDTO create(DealerRegistrationDTO registrationDTO) {
        try {
            DealerRegistrationEntity savedDealer = dealerRegistrationService.create(
                    dealerRegistrationMapper.toEntity(registrationDTO));
            return dealerRegistrationMapper.toResponseDTO(savedDealer);
        } catch (DataIntegrityViolationException ex) {
            throw new UsernameAlreadyExistsException("Dealer creation failed");
        }
    }


    public List<DealerRegistrationResponseDTO> getAllDealerList() {
        List<DealerRegistrationEntity> data=dealerRegistrationService.getAll();
        return data.stream().map(dealerRegistrationMapper::toResponseDTO).toList();
    }

    public DealerRegistrationResponseDTO update(DealerRegistrationUpdateDTO registrationUpdateDTO) {
        return dealerRegistrationMapper.toResponseDTO(dealerRegistrationService.update(dealerRegistrationMapper.toEntity(registrationUpdateDTO)));
    }
}
