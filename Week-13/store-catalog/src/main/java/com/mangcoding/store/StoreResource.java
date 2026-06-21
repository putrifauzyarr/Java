package com.mangcoding.store;

import java.util.List;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/stores")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StoreResource {

    @GET
    public List<Store> getAll() {
        return Store.listAll();
    }

    @POST
    @Transactional
    public Store create(Store store) {
        store.persist();
        return store;
    }
}