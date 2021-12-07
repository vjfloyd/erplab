package com.company.erp.erplab.business.services;


import com.company.erp.erplab.source.request.ProductRequest;
import com.company.erp.erplab.source.response.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public interface ProductService {

    ProductResponse insert(ProductRequest productRequest);
    ProductResponse update(ProductRequest productRequest, Long id);
    ProductResponse get(Long productId);

}
