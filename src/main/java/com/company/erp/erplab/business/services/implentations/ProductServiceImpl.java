package com.company.erp.erplab.business.services.implentations;


import com.company.erp.erplab.business.services.ProductService;
import com.company.erp.erplab.caller.ProductApiCaller;
import com.company.erp.erplab.config.PropertiesEnv;
import com.company.erp.erplab.config.exception.ErpBussinesException;
import com.company.erp.erplab.entity.Product;
import com.company.erp.erplab.persitency.ProductRepository;
import com.company.erp.erplab.source.request.ProductRequest;
import com.company.erp.erplab.source.response.ProductResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private ProductApiCaller productApiCaller;
    private PropertiesEnv propertiesEnv;


    public ProductServiceImpl(ProductRepository productRepository, ProductApiCaller productApiCaller,
                              PropertiesEnv propertiesEnv) {
        this.productRepository = productRepository;
        this.productApiCaller = productApiCaller;
        this.propertiesEnv = propertiesEnv;
    }




    @Override
    public ProductResponse insert(ProductRequest productRequest) {
        log.info(" ProductServiceImpl -> insert ");

        com.company.erp.erplab.entity.Product  product = new com.company.erp.erplab.entity.Product();
        product.setCategory(productRequest.getCategory());
        product.setName(productRequest.getName());
        productRepository.save(product);

        return  ProductResponse
                .builder()
                .id(product.getId())
                .name(product.getName())
                .category(product.getCategory())
                .build();
    }

    @Override
    public ProductResponse update(ProductRequest productRequest,Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (!product.isPresent()){
            throw new ErpBussinesException("No existe el producto");
        }
        product.get().setCategory(productRequest.getCategory());
        product.get().setName(productRequest.getName());

        productRepository.save(product.get());

        return ProductResponse.builder()
                .category(productRequest.getCategory())
                .name(productRequest.getName())
                .build();
    }

    @Override
    public ProductResponse get(Long productId) {
        com.company.erp.erplab.business.model.Product product = null;
        try {
             product = productApiCaller.getProduct(productId);
        } catch (Exception e) {
            new ErpBussinesException("Error en invocacion del servicio Externo");
        }
        return ProductResponse
                .builder()
                .id(product.getId())
                .category(product.getCategory())
                .name(product.getName())
                .build();

    }
}
