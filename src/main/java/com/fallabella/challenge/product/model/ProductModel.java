package com.fallabella.challenge.product.model;


import com.fallabella.challenge.product.util.Constants;
import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.*;

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
    @Min(value =3)
    @Max(value =50)
    private String brandName;

    @Column
    @Min(value =3)
    @Max(value =50)
    @NotBlank
    private String size;

    @Column(nullable = false)
    @DecimalMin(value ="1.00")
    @DecimalMax(value ="99999999.00")
    private Double price;

    @Column(nullable = false)
    @Pattern(regexp = Constants.URL_PATTERN)
    private String urlImage;

    @Column
    @Pattern(regexp = Constants.URL_PATTERN)
    private String otherImage;
}
