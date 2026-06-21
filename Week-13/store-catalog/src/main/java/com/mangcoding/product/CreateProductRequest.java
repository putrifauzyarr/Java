package com.mangcoding.product;

import java.math.BigDecimal;

public class CreateProductRequest {
    public String name;
    public String description;
    public BigDecimal price;
    public Long storeId;
    public Long categoryId;
}