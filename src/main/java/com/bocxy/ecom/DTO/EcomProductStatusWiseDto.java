package com.bocxy.ecom.DTO;

import lombok.Data;

import java.util.List;

@Data
public class EcomProductStatusWiseDto {
    private List<EcomProductDTO> pending;
    private List<EcomProductDTO> approved;
    private List<EcomProductDTO> rejected;

}
