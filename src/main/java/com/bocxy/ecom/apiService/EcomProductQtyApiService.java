package com.bocxy.ecom.apiService;

import com.bocxy.ecom.DTO.EcomProductDTO;
import com.bocxy.ecom.DTO.EcomProductQtyResponseDTO;
import com.bocxy.ecom.createDTO.EcomProductQuantityDTO;
import com.bocxy.ecom.mapper.EcomProductQtyMapper;
import com.bocxy.ecom.model.DealerRegistrationEntity;
import com.bocxy.ecom.model.EcomProductQuantity;
import com.bocxy.ecom.service.EcomProductQtyService;
import com.bocxy.ecom.updateDTO.EcomProductQtyUpdateDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EcomProductQtyApiService {

    @Autowired
    private EcomProductQtyService ecomProductQtyService;

    @Autowired
    private EcomProductQtyMapper ecomProductQtyMapper;

    public EcomProductQtyResponseDTO create(EcomProductQuantityDTO ecomProductQuantityDTO) {
        return ecomProductQtyMapper.toDTO(ecomProductQtyService.create(ecomProductQtyMapper.toEntity(ecomProductQuantityDTO)));
    }

    public List<EcomProductQtyResponseDTO> getAllProductQuantity() {
        List<EcomProductQuantity> data=ecomProductQtyService.getAll();
        return data.stream().map(ecomProductQtyMapper::toDTO).toList();
    }

    public EcomProductQtyResponseDTO update(EcomProductQtyUpdateDTO ecomProductQtyUpdateDTO) {
        return ecomProductQtyMapper.toDTO(ecomProductQtyService.update(ecomProductQtyMapper.toEntity(ecomProductQtyUpdateDTO)));
    }

    public EcomProductQtyResponseDTO getProductQuantityById(Long id) {
        Optional<EcomProductQuantity> entity = ecomProductQtyService.getById(id);
        return ecomProductQtyMapper.toDTO(entity.get());
    }

    public List<EcomProductQtyResponseDTO> getProductQuantityByUserId(String userId) {
        return ecomProductQtyService.getAllByUserId(userId)
                .map(list -> list.stream()
                        .map(ecomProductQtyMapper::toDTO)
                        .collect(Collectors.toList()))
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
