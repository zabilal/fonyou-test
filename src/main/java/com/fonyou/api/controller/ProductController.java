package com.fonyou.api.controller;

import com.fonyou.api.dto.ProductRequest;
import com.fonyou.api.dto.ProductResponse;
import com.fonyou.api.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity createProduct(@RequestBody ProductRequest productRequest){
        productService.createProduct(productRequest);
        return  new ResponseEntity("Product saved successfully", HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<ProductResponse>> getAllProducts(){
        return new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity getAllProducts(@PathVariable("id") String id){
        ProductResponse productResponse = productService.getProductById(id);
        if (Objects.nonNull(productResponse)) {
            return new ResponseEntity<>(productService.getProductById(id), HttpStatus.OK);
        }
        return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
    }
}
