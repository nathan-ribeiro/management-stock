package com.management.stock.controller;

import com.management.stock.controller.request.CreateProductDTO;
import com.management.stock.controller.request.UpdateProductDTO;
import com.management.stock.dto.ProductDTO;
import com.management.stock.entity.ProductEntity;
import com.management.stock.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/{productId}")
    public ResponseEntity<ProductEntity> findProduct(@PathVariable("productId") Long productId) {
        return ResponseEntity.ok(productService.findProduct(productId));
    }

    @DeleteMapping("/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable("productId") Long productId) {
        return ResponseEntity.ok(productService.deleteProduct(productId));
    }

    @PutMapping
    public ResponseEntity<ProductEntity> updateProduct(@RequestBody UpdateProductDTO productDTO) {
        return ResponseEntity.ok(productService.updateProduct(productDTO));
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@RequestBody CreateProductDTO productDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(productDTO));
    }



}
