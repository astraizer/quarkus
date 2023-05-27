package com.nostratech.store.web;

import javax.annotation.security.RolesAllowed;
import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

import com.nostratech.store.service.AuthorCreateRequestDTO;
import com.nostratech.store.service.AuthorResponseDTO;
import com.nostratech.store.service.AuthorService;

@Path("v1")
@Produces("application/json")
@Consumes("application/json")
@ApplicationScoped
public class AuthorResource {
	
	private final AuthorService authorService;

	public AuthorResource(AuthorService authorService) {
		super();
		this.authorService = authorService;
	}
	
	@POST
    @RolesAllowed("user")
	@Path("author")
	public Response save(AuthorCreateRequestDTO dto) {

		authorService.createAuthor(dto);
		return Response.ok().status(201).build();
	}
	
	@GET
    @RolesAllowed("user")
	@Path("author/{id}")
	public RestResponse<AuthorResponseDTO> findBookById(@RestPath Long id) {
		
		return RestResponse.ok(authorService.findAuthorkById(id));
	}
	
	

}
