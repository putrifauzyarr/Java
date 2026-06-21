package com.mangcoding.product;

import java.math.BigDecimal;
import com.mangcoding.category.Category;
import com.mangcoding.store.Store;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;

@Entity
public class Product extends PanacheEntity {
    public String name;
    
    public String description;

    public BigDecimal price;

    @ManyToOne
    public Store store;

    @ManyToOne
    public Category category;
}