package com.nostratech.store.web;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.jboss.resteasy.reactive.RestResponse;

import com.nostratech.store.dto.LoginRequestDTO;
import com.nostratech.store.dto.LoginResponseDTO;
import com.nostratech.store.service.AuthenticationService;

@Path("v1")
@Produces("application/json")
@Consumes("application/json")
@ApplicationScoped
public class AuthResource {
	
	private final AuthenticationService authService;
	

	public AuthResource(AuthenticationService authService) {
		super();
		this.authService = authService;
	}


	@POST
	@Path("/auth/login")
	public RestResponse<LoginResponseDTO> login(LoginRequestDTO dto){
		LoginResponseDTO response = authService.login(dto);
		return RestResponse.ok(response);
	}
	
	

}
