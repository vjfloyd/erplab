package com.company.erp.erplab.source;

import com.company.erp.erplab.business.services.ProductService;
import com.company.erp.erplab.source.request.ProductRequest;
import com.company.erp.erplab.source.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/erp/")
public class ProductExpose {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<ProductResponse> insertProduct(@Valid @RequestBody ProductRequest productRequest){
        return new ResponseEntity<>(productService.insert(productRequest), HttpStatus.CREATED);
    }

    @PutMapping("/product/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@Valid @RequestBody ProductRequest productRequest,
                                                         @PathVariable Long id){
        return new ResponseEntity<>(productService.update(productRequest, id), HttpStatus.ACCEPTED);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id){
        return new ResponseEntity<>(productService.get(id),HttpStatus.ACCEPTED);
    }

}
