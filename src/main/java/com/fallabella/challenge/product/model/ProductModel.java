package com.fallabella.challenge.product.model;


import com.fallabella.challenge.product.util.Constants;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Pattern;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductModel {
    @Id
    @Column(nullable = false)
    private String sku;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String brandName;
    @Column
    private String size;
    @Column(nullable = false)
    private Double price;
    @Column(nullable = false)
    @Pattern(regexp = Constants.URL_PATTERN)
    private String urlImage;
    @Column
    @Pattern(regexp = Constants.URL_PATTERN)
    private String otherImage;
}
