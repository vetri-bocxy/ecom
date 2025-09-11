package com.bocxy.ecom.DTO;

import com.bocxy.ecom.model.DealerRegistrationEntity;
import com.bocxy.ecom.model.EcomProduct;
import lombok.Data;

import java.util.List;

@Data
public class DealerProductNotificationDTO {
    private List<EcomProduct> products;
    private List<DealerRegistrationEntity> dealers;
}

