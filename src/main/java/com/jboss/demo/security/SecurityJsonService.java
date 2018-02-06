package com.jboss.demo.security;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/")
public class SecurityJsonService {
	
	public SecurityJsonService(){}
	
	@POST
	@Path("/sjson")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces (MediaType.APPLICATION_JSON)
	public Root doSecurity(Root root){
		return root;
	}
}
