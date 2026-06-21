package com.mangcoding.product;

import java.util.List;

import com.mangcoding.category.Category;
import com.mangcoding.store.Store;

import jakarta.transaction.Transactional;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.MediaType;

@Path("/products")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class ProductResource {
    
    @GET
    public List<Product> getAll() {
        return Product.listAll();
    }

    @GET 
    @Path("/search")
    public List<Product> search(
        @QueryParam("name") String name
    ) {
        return Product.list("LOWER(name) LIKE LOWER(?!)", 
        "%" + name + "%");
    }

    @GET
    @Path("/paged")
    public List<Product> paged(
        @QueryParam("page") int page,
        @QueryParam("size") int size
    ) {
        return Product.findAll().page(page, size).list();
    }

    @POST
    @Transactional
    public Product create(CreateProductRequest request) {
        Store store = Store.findById(request.storeId);
        Category category = Category.findById(request.categoryId);

        Product product = new Product();

        product.name = request.name;
        product.description = request.description;
        product.price = request.price;
        product.store = store;
        product.category = category;

        product.persist();

        return product;
    }
}