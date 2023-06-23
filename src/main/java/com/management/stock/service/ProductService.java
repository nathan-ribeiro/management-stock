package com.management.stock.service;

import com.management.stock.controller.request.CreateProductDTO;
import com.management.stock.controller.request.UpdateProductDTO;
import com.management.stock.entity.ProductEntity;
import com.management.stock.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    private String DELETED_MESSAGE = "Product deleted sucessfully!";


    public ProductEntity createProduct(CreateProductDTO productDTO){

        var productEntity = ProductEntity.builder()
                .description(productDTO.getDescription())
                .quantity(productDTO.getQuantity())
                .build();

        return productRepository.save(productEntity);
    }

    public ProductEntity updateProduct(UpdateProductDTO productDTO){

        if(productRepository.findById(productDTO.getId()) != null){
            //Throw exception
        }

        var productEntity = ProductEntity.builder()
                .id(productDTO.getId())
                .description(productDTO.getDescription())
                .quantity(productDTO.getQuantity())
                .build();

        return productRepository.save(productEntity);


    }

    public ProductEntity findProduct(Long productId){

        var product = productRepository.findById(productId);

        if (product.isEmpty()){
            //Throw exception
        }

        return product.get();
    }

    public String deleteProduct(Long productId){

        var product = productRepository.findById(productId);

        if (product.isEmpty()){
            //Throw exception
        }

        productRepository.deleteById(productId);

        return DELETED_MESSAGE;
    }

}
