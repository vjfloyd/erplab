package com.company.erp.erplab.business.services.implentations;

import com.company.erp.erplab.business.services.ProductDetailService;
import com.company.erp.erplab.config.exception.ErpBussinesException;
import com.company.erp.erplab.entity.Product;
import com.company.erp.erplab.entity.ProductDetail;
import com.company.erp.erplab.persitency.ProductDetailRepository;
import com.company.erp.erplab.persitency.ProductRepository;
import com.company.erp.erplab.source.request.ProductDetailRequest;
import com.company.erp.erplab.source.response.ProductDetailResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class ProductDetailServiceImpl implements ProductDetailService {

    private ProductDetailRepository productDetailRepository;
    private ProductRepository productRepository;

    public ProductDetailServiceImpl(ProductDetailRepository productDetailRepository, ProductRepository productRepository) {
        this.productDetailRepository = productDetailRepository;
        this.productRepository = productRepository;
    }


    @Override
    public ProductDetailResponse insert(ProductDetailRequest productDetailRequest) {
        log.info(" ProductDetailServiceImpl -> insert ");

        com.company.erp.erplab.entity.Product  product = new com.company.erp.erplab.entity.Product();
        product.setCategory(productDetailRequest.getCategory());
        product.setName(productDetailRequest.getName());
        Product rsp = productRepository.save(product);

        ProductDetail productDetail = new ProductDetail();
        productDetail.setProduct(rsp);
        productDetail.setBrand(productDetailRequest.getBrand());
        productDetail.setImageUrl(productDetailRequest.getImageUrl());
        productDetail.setDescription(productDetailRequest.getDescription());
        productDetail.setPrice(productDetailRequest.getPrice());
        ProductDetail pd = productDetailRepository.save(productDetail);

        return  ProductDetailResponse
                .builder()
                .id(pd.getId())
                .price(productDetail.getPrice())
                .description(productDetail.getDescription())
                .imageUrl(productDetail.getImageUrl())
                .brand(productDetail.getBrand())
                .build();
    }

    @Override
    public ProductDetailResponse update(ProductDetailRequest productDetailRequest, Long id)  {

//        com.company.erp.erplab.entity.Product  product = new com.company.erp.erplab.entity.Product();
//        product.setCategory(productDetailRequest.getCategory());
//        product.setName(productDetailRequest.getName());
//        Product rsp = productRepository.save(product);

        Optional<ProductDetail> productDetail = productDetailRepository.findById(id);
        if(!productDetail.isPresent()){
            throw new ErpBussinesException("No existe el producto");
        }

        productDetail.get().setBrand(productDetailRequest.getBrand());
        productDetail.get().setImageUrl(productDetailRequest.getImageUrl());
        productDetail.get().setDescription(productDetailRequest.getDescription());
        productDetail.get().setPrice(productDetailRequest.getPrice());
        ProductDetail pd = productDetailRepository.save(productDetail.get());

        return  ProductDetailResponse
                .builder()
                .id(pd.getId())
                .price(pd.getPrice())
                .description(pd.getDescription())
                .imageUrl(pd.getImageUrl())
                .brand(pd.getBrand())
                .build();

    }

    @Override
    public ProductDetailResponse get(Long productId) {
        log.info(" ProductDetailServiceImpl -> get ");

       Optional<ProductDetail> productDetail =
               productDetailRepository.findById(productId);
       if(!productDetail.isPresent()){
            throw new ErpBussinesException("No existe el producto");
       }

       return ProductDetailResponse.builder()
               .id(productDetail.get().getId())
               .description(productDetail.get().getDescription())
               .brand(productDetail.get().getBrand())
               .imageUrl(productDetail.get().getImageUrl())
               .price(productDetail.get().getPrice())
               .build();
    }
}
