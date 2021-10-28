package com.fallabella.challenge.product.business.impl;

import com.fallabella.challenge.product.bean.Product;
import com.fallabella.challenge.product.business.ProductService;
import com.fallabella.challenge.product.mapper.ProductMapper;
import com.fallabella.challenge.product.model.ProductModel;
import com.fallabella.challenge.product.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;


@Service
@Slf4j
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    private final ProductMapper productMapper;

    @Override
    public Product getProduct(String sku) {
        Optional<ProductModel> optionalProductModel = repository.findById(sku);
        Optional<Product> product = optionalProductModel.map(productMapper::modelToBean);
        return  product.get();
    }

    @Override
    public List<Product> getProducts() {
        return repository.findAll().stream()
                .map(productMapper::modelToBean)
                .collect(toList());
    }

    @Override
    public Product createProduct(Product product) {
        try {
            if (!repository.existsById(product.getSku())) {
                ProductModel model = repository.save(productMapper.beanToModel(product));
                return productMapper.modelToBean(model);
            }else{
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Bad Request");
            }
        } catch (DataIntegrityViolationException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Bad Request", ex);
        }
    }

    @Override
    public Product updateProduct(Product product) {
        try {
            if (repository.existsById(product.getSku())) {
                ProductModel model = repository.save(productMapper.beanToModel(product));
                return productMapper.modelToBean(model);
            }else{
                throw new ResponseStatusException(
                        HttpStatus.BAD_REQUEST, "Bad Request");
            }
        } catch (DataIntegrityViolationException ex) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST, "Bad Request", ex);
        }
    }

    @Override
    public void deleteProduct(String sku) {
        repository.deleteById(sku);
    }
}