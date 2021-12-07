package com.company.erp.erplab.entity;

import lombok.Data;

import javax.persistence.*;

@Table(name = "product")
@Entity
@Data
public class Product {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String category;


    @OneToOne(mappedBy = "product")
    private ProductDetail productDetail;

}
