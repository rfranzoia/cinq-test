package br.com.cinq.spring.data.sample.rest;

import java.net.URI;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import br.com.cinq.spring.data.sample.entity.City;
import br.com.cinq.spring.data.sample.service.CityService;

@Component
@Path("cities")
public class CityREST {

	@Autowired
	CityService service;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response listByCountryName(@QueryParam("country") String countryName) {
		
		if (countryName == null) {
			return Response.ok().entity(service.listAll()).build();
			
		} else {
			return Response.ok().entity(service.listByCountryName(countryName)).build();
		}
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public Response insert(City city, @Context UriInfo uriInfo) {
		city = service.save(city);
		
		URI location = uriInfo.getRequestUriBuilder().path(city.getId().toString()).build();
		
		return Response.created(location).entity(city).build();
	}
	
	@PUT
	@Path("/{cityId}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	@Consumes(MediaType.APPLICATION_JSON_VALUE)
	public Response update(@PathParam("cityId") Integer cityId, City city) {
		city = service.update(cityId, city);
		return Response.ok().entity(city).build();
	}
	
	@DELETE
	@Path("/{cityId}")
	@Produces(MediaType.APPLICATION_JSON_VALUE)
	public Response delete(@PathParam("cityId") Integer cityId) {
		service.delete(cityId);
		return Response.ok().build();
	}
}
