package com.fallabella.challenge.product.expose;

import com.fallabella.challenge.product.bean.Product;
import com.fallabella.challenge.product.business.ProductService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;


@RestController
@RequestMapping("/products")
@Slf4j
@OpenAPIDefinition(info =
@Info(
        title = "Api Products",
        version = "1.0",
        description = "Api Challenge Fallabela",
        license = @License(name = "Apache 2.0", url = "http://foo.bar"),
        contact = @Contact(url = "https://falabella.com.pe", name = "Gustavo Guanilo", email = "gguanilo@gmail.com")
)
)
public class ProductRestController {

    @Autowired
    private ProductService service;

    @PostMapping
    @Operation(summary = "Add Product",
            description = "Add item product catalog")
    public void createProduct(@RequestBody Product request) {
        service.createProduct(request);
    }

    @PutMapping
    @Operation(summary = "Update Product",
            description = "Update item product catalog")
    public void updateProduct(@RequestBody Product request) {
        service.updateProduct(request);
    }

    @GetMapping
    @Operation(summary = "Get all Products",
            description = "Get all Products from catalog")
    public Flux<List<Product>> getAllProducts() {
        return Flux.just(service.getProducts());
    }

    @GetMapping(value = "/{sku}", produces = MediaType.APPLICATION_NDJSON_VALUE)
    @Operation(summary = "Get Product",
            description = "Get Product by SKU")
    public Mono<Product> getProduct(@PathVariable("sku") String sku) {
        return Mono.just(service.getProduct(sku));
    }


    @DeleteMapping(value = "/{sku}", produces = MediaType.APPLICATION_NDJSON_VALUE)
    @Operation(summary = "Delete Product",
            description = "Delete Product by SKU")
    public void deleteProduct(@PathVariable("sku") String sku) {
        service.deleteProduct(sku);
    }

}
