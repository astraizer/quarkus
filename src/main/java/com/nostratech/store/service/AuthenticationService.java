package com.nostratech.store.service;

import com.nostratech.store.dto.LoginRequestDTO;
import com.nostratech.store.dto.LoginResponseDTO;

import io.smallrye.jwt.build.Jwt;

public interface AuthenticationService {

	public LoginResponseDTO login(LoginRequestDTO dto);

	public String createJwt();
}
