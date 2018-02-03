package com.jboss.demo;

import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path(value="/payment/")
public interface RequestService {
    @Path(value="/mpay")
    @POST
    @Produces({MediaType.APPLICATION_JSON })
    public String payment(@PathParam("payment") PaymentInfo payment);
}

