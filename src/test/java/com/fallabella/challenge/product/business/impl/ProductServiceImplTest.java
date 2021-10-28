package com.fallabella.challenge.product.business.impl;

import com.fallabella.challenge.product.bean.Product;
import com.fallabella.challenge.product.mapper.ProductMapper;
import com.fallabella.challenge.product.model.ProductModel;
import com.fallabella.challenge.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;


@SpringBootTest
public class ProductServiceImplTest {
    @Mock
    private ProductRepository repository;
    @Mock
    private ProductMapper productMapper;

    @InjectMocks
    private ProductServiceImpl productServiceImpl;

    @Test
    public void testGetProduct() throws Exception {
        Optional<ProductModel> optionalProductModel = Optional.of(ProductModel.builder()
                .sku("FAL-8406270")
                .name("500 Zapatilla Urbana Mujer")
                .brandName("NEW BALANCE")
                .size("37")
                .price(42990.00d)
                .urlImage("https://falabella.scene7.com/is/image/Falabella/8406270_1")
                .build());
        when(repository.findById(anyString())).thenReturn(optionalProductModel);
        Product product = Product.builder()
                .sku("FAL-8406270")
                .name("500 Zapatilla Urbana Mujer")
                .brandName("NEW BALANCE")
                .size("37")
                .price(42990.00d)
                .urlImage("https://falabella.scene7.com/is/image/Falabella/8406270_1")
                .build();
        when(productMapper.modelToBean(any(ProductModel.class))).thenReturn(product);
        assertEquals(product, productServiceImpl.getProduct("FAL-8406270"));
    }

    @Test
    public void testGetProducts() throws Exception {
        List<ProductModel> all = new ArrayList<>();
        ProductModel model = ProductModel.builder()
                .sku("FAL-8406270")
                .name("500 Zapatilla Urbana Mujer")
                .brandName("NEW BALANCE")
                .size("37")
                .price(42990.00d)
                .urlImage("https://falabella.scene7.com/is/image/Falabella/8406270_1")
                .build();
        all.add(model);
        when(repository.findAll()).thenReturn(all);
        List<Product> result = new ArrayList<>();
        result.add(productMapper.modelToBean(model));
        assertEquals(result, productServiceImpl.getProducts());
    }

    @Test
    public void testCreateProduct() throws Exception {
        Product product = Product.builder()
                .sku("FAL-8406270")
                .name("500 Zapatilla Urbana Mujer")
                .brandName("NEW BALANCE")
                .size("37")
                .price(42990.00d)
                .urlImage("https://falabella.scene7.com/is/image/Falabella/8406270_1")
                .build();
        ProductModel productModel = ProductModel.builder()
                .sku("FAL-8406270")
                .name("500 Zapatilla Urbana Mujer")
                .brandName("NEW BALANCE")
                .size("37")
                .price(42990.00d)
                .urlImage("https://falabella.scene7.com/is/image/Falabella/8406270_1")
                .build();
        when(repository.existsById(anyString())).thenReturn(false);
        when(productMapper.beanToModel(any(Product.class))).thenReturn(productModel);
        when(repository.save(any(ProductModel.class))).thenReturn(productModel);
        when(productMapper.modelToBean(any(ProductModel.class))).thenReturn(product);
        assertEquals(product, productServiceImpl.createProduct(product));
    }

    @Test
    public void testUpdateProduct() throws Exception {
        Product product = Product.builder()
                .sku("FAL-8406270")
                .name("500 Zapatilla Urbana Mujer")
                .brandName("NEW BALANCE")
                .size("37")
                .price(42990.00d)
                .urlImage("https://falabella.scene7.com/is/image/Falabella/8406270_1")
                .build();
        ProductModel productModel = ProductModel.builder()
                .sku("FAL-8406270")
                .name("500 Zapatilla Urbana Mujer")
                .brandName("NEW BALANCE")
                .size("37")
                .price(42990.00d)
                .urlImage("https://falabella.scene7.com/is/image/Falabella/8406270_1")
                .build();
        when(repository.existsById(anyString())).thenReturn(true);
        when(productMapper.beanToModel(any(Product.class))).thenReturn(productModel);
        when(repository.save(any(ProductModel.class))).thenReturn(productModel);
        when(productMapper.modelToBean(any(ProductModel.class))).thenReturn(product);
        assertEquals(product, productServiceImpl.updateProduct(product));
    }

    @Test
    public void testDeleteProduct() throws Exception {
        productServiceImpl.deleteProduct("sku");
    }
}