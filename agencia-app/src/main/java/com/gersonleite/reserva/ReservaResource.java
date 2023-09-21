package com.gersonleite.reserva;


import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

import java.util.List;

@Path("/reserva")
public class ReservaResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reserva> get(){
        return Reserva.listAll();
    }

    @Transactional
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Reserva newReserva(Reserva reserva){
        reserva.id = null;
        reserva.persist();

        return reserva;
    }
}
