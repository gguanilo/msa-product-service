package com.fallabella.challenge.product.repository.impl;

import com.fallabella.challenge.product.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductJpaRepository extends JpaRepository<ProductModel,String> {
}
