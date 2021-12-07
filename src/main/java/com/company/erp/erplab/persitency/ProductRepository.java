package com.company.erp.erplab.persitency;

import com.company.erp.erplab.entity.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {


}
