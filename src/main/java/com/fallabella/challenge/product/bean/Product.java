package com.fallabella.challenge.product.bean;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    private String sku;
    private String name;
    private String brandName;
    private String size;
    private Double price;
    private String urlImage;
    private String otherImage;
}
