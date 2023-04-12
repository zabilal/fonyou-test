package com.fonyou.api.service;

import com.fonyou.api.dto.ProductRequest;
import com.fonyou.api.dto.ProductResponse;
import com.fonyou.api.model.Product;
import com.fonyou.api.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProductService {

    private final ProductRepository productRepository;

    public void createProduct(ProductRequest productRequest){
        Product product = Product.builder()
                .description(productRequest.getDescription())
                .amount(productRequest.getAmount())
                .active(productRequest.getActive())
                .creationDate(LocalDateTime.now())
                .build();
        productRepository.save(product);
        log.info("Product {} is saved", product.getId());
    }

    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream().map(this::mapToProductResponse).toList();
    }

    public ProductResponse getProductById(String productId) {
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()){
            return mapToProductResponse(productOptional.get());
        }
        return null;
    }

    private ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .description(product.getDescription())
                .amount(product.getAmount())
                .active(product.getActive())
                .creationDate(product.getCreationDate())
                .build();
    }
}
