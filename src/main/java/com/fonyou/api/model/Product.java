package com.fonyou.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(value = "products")
@Builder
public class Product {
    @Id
    private String id;
    private String description;
    private BigDecimal amount;
    private Boolean active;
    private LocalDateTime creationDate;

}
