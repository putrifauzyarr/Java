package com.mangcoding.category;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Category extends PanacheEntity {
    public String name;
    public String description;
}