package com.nostratech.store.service.impl;

import javax.enterprise.context.ApplicationScoped;

import com.nostratech.store.dto.LoginRequestDTO;
import com.nostratech.store.dto.LoginResponseDTO;
import com.nostratech.store.service.AuthenticationService;

import io.smallrye.jwt.build.Jwt;

@ApplicationScoped
public class AuthenticationServiceImpl implements AuthenticationService {
	public String createJwt() {
		return Jwt.issuer("nostratech.com")
				.subject("user1").groups("user")
				.expiresAt(System.currentTimeMillis() + 3600).sign();
	}

	@Override
	public LoginResponseDTO login(LoginRequestDTO dto) {
		String token = createJwt();
		return new LoginResponseDTO(token);
	}
}
