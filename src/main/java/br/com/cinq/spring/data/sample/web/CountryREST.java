package br.com.cinq.spring.data.sample.web;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import br.com.cinq.spring.data.sample.domain.country.Country;
import br.com.cinq.spring.data.sample.service.CountryService;

@Component
@Path("countries")
public class CountryREST {

	@Autowired
	CountryService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response listAll() {
		return Response.ok().entity(service.listAll()).build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public Response insert(Country country, @Context UriInfo uriInfo) {
		country = service.save(country);
		
		URI location = uriInfo.getRequestUriBuilder().path(country.getId().toString()).build();
		
		return Response.created(location).entity(country).build();
	}
	
	@PUT
	@Path("/{countryId}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response update(@PathParam("countryId") Integer countryId, Country country) {
		country = service.update(countryId, country);
		return Response.ok().entity(country).build();
	}
	
	@DELETE
	@Path("/{countryId}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response delete(@PathParam("countryId") Integer countryId) {
		service.delete(countryId);
		return Response.ok().build();
	}
}
