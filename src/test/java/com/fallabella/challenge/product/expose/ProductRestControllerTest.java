package com.fallabella.challenge.product.expose;

import com.fallabella.challenge.product.bean.Product;
import com.fallabella.challenge.product.business.ProductService;
import com.fallabella.challenge.product.business.impl.ProductServiceImpl;
import com.fallabella.challenge.product.repository.ProductRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

@ExtendWith(SpringExtension.class)
@WebFluxTest(controllers = ProductRestController.class)
@Import(ProductServiceImpl.class)
public class ProductRestControllerTest {
    @Mock
    private ProductService service;

    @MockBean
    private ProductRepository productRepository;

    @Autowired
    private WebTestClient webTestClient;

    @InjectMocks
    private ProductRestController productRestController;


    @Test
    public void testCreateProduct() throws Exception {
        Product request = Product.builder()
                .sku("FAL-8406270")
                .name("500 Zapatilla Urbana Mujer")
                .brandName("NEW BALANCE")
                .size("37")
                .price(42990.00d)
                .urlImage("https://falabella.scene7.com/is/image/Falabella/8406270_1")
                .build();
        webTestClient.post().uri("/products")
                .body(BodyInserters.fromObject(request))
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    public void testUpdateProduct() throws Exception {
        when(service.updateProduct(any())).thenReturn(new Product("sku", "name", "brandName", "size", Double.valueOf(0), "urlImage", "otherImage"));

        productRestController.updateProduct(new Product("sku", "name", "brandName", "size", Double.valueOf(0), "urlImage", "otherImage"));
    }

    @Test
    public void testGetAllProducts() throws Exception {
        when(service.getProducts()).thenReturn(Arrays.<Product>asList(new Product("sku", "name", "brandName", "size", Double.valueOf(0), "urlImage", "otherImage")));

        Flux<List<Product>> result = productRestController.getAllProducts();

    }

    @Test
    public void testGetProduct() throws Exception {
        when(service.getProduct(anyString())).thenReturn(new Product("sku", "name", "brandName", "size", Double.valueOf(0), "urlImage", "otherImage"));

        Mono<Product> result = productRestController.getProduct("sku");
    }

    @Test
    public void testDeleteProduct() throws Exception {
        productRestController.deleteProduct("sku");
    }
}