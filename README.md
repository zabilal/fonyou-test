## Spring Boot JPA MySQL - Building A Simple Rest CRUD API FOR FONYOU

# Instruction

Develop small rest Api:

Given the following model (Database). Develop a small rest api with an endpoint that allows you to retrieve the amount from product id.
You donʼt need to spend a lot of time on it. Add those aspects you consider important to deploy it in production. Database model

```
public class Product {
    private String id;
    private String description;
    private BigDecimal amount;
    private Boolean active;
    private LocalDateTime creationDate;
}

```