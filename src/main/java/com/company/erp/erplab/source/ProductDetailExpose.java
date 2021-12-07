package com.company.erp.erplab.source;

import com.company.erp.erplab.business.services.ProductDetailService;
import com.company.erp.erplab.source.request.ProductDetailRequest;
import com.company.erp.erplab.source.response.ProductDetailResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/erp")
@Slf4j
public class ProductDetailExpose {

    private ProductDetailService productDetailService;

    public ProductDetailExpose(ProductDetailService productDetailService) {
        this.productDetailService = productDetailService;
    }

    @PostMapping("/product-detail")
    public ResponseEntity<ProductDetailResponse> insertProduct(@Valid @RequestBody ProductDetailRequest productRequest){
        log.info("ProductDetailExpose -> insertProduct");
        return new ResponseEntity<>(productDetailService.insert(productRequest), HttpStatus.CREATED);
    }

    @PutMapping("/product-detail/{id}")
    public ResponseEntity<ProductDetailResponse> updateProduct(@Valid @RequestBody ProductDetailRequest productRequest,
        @PathVariable Long id){
        return new ResponseEntity<>(productDetailService.update(productRequest,id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/product-detail/{id}")
    public ResponseEntity<ProductDetailResponse> getProduct(@PathVariable Long id) throws Exception {
        return new ResponseEntity<>(productDetailService.get(id),HttpStatus.ACCEPTED);
    }

}
