package com.company.erp.erplab.business.services;


import com.company.erp.erplab.source.request.ProductDetailRequest;
import com.company.erp.erplab.source.response.ProductDetailResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProductDetailService {

    ProductDetailResponse insert(ProductDetailRequest productRequest);
    ProductDetailResponse update(ProductDetailRequest productRequest, Long id);
    ProductDetailResponse get(Long productId) throws Exception;

}
