package com.gersonleite.cliente;


import com.gersonleite.cliente.Cliente;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.Response.Status;

import java.util.List;

@Path("/cliente")
public class ClienteResource {


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Cliente> get(){
        return Cliente.listAll();
    }

    @GET
    @Path("findById")
    @Produces(MediaType.APPLICATION_JSON)
    public Cliente findById(@QueryParam("id") long id){
        return Cliente.findById(id);
    }

    @Transactional
    @DELETE
    @Path("deleteById")
    public void deleteById(@QueryParam("id") long id){
        Cliente.deleteById(id);
    }

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response newCliente(Cliente cliente){
        cliente.id = null;
        cliente.persist();

        return Response.status(Status.CREATED).entity(cliente).build();
    }
}
