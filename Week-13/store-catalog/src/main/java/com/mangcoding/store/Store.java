package com.mangcoding.store;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Store extends PanacheEntity {
    public String name;
    public String address;
    public String description;
}