package com.company.erp.erplab.source.response;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class ProductDetailResponse {

    private Long id;
    private String description;
    private String brand;
    private String imageUrl;
    private BigDecimal price;


}
