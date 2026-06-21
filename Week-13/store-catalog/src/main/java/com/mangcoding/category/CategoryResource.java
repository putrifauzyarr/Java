package com.mangcoding.category;

import java.util.List;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/categories")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CategoryResource {

    @GET
    public List<Category> getAll() {
        return Category.listAll();
    }

    @POST
    @Transactional
    public Category create(Category category) {
        category.persist();
        return category;
    }
}