package com.bocxy.ecom.createDTO;

import lombok.Data;

import java.time.ZonedDateTime;

@Data
public class EcomStatusDTO {

    private Long id;
    private String productId;
    private String ProductName;
    private String projectName;
    private String status;
    private ZonedDateTime statusAt;
    private String rejectRemarks;
}
