package com.fallabella.challenge.product.mapper;

import com.fallabella.challenge.product.bean.Product;
import com.fallabella.challenge.product.model.ProductModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product modelToBean(ProductModel model);

    ProductModel beanToModel(Product bean);
}
