package com.company.erp.erplab.entity;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "productDetail")
@Entity
@Data
public class ProductDetail {
    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;
    private BigDecimal price;
    private String brand;
    private String imageUrl;
    private String description;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    private Product product;

}
