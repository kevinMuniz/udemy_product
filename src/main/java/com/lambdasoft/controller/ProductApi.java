package com.lambdasoft.controller;

import com.lambdasoft.entities.Product;
import com.lambdasoft.repository.ProductRepository;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("product")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ProductApi {

    @Inject
    ProductRepository productRepository;

    @GET
    public List<Product> list() {
        return this.productRepository.getAll();
    }

    @GET
    @Path("{idProduct}")
    public Product find(@PathParam("idProduct") Long id) {
        return this.productRepository.findById(id);
    }

    @POST
    public Response add(Product product) {
        this.productRepository.create(product);
        return Response.ok().build();
    }

    @PUT
    public Response update(Product product) {
        this.productRepository.update(product);
        return Response.ok().build();
    }

    @DELETE
    public Response remove(Product product) {
        this.productRepository.delete(product);
        return Response.ok().build();
    }

}
