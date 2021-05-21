package com.gt4w.clinica.controller;

import static org.springframework.http.ResponseEntity.ok;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gt4w.clinica.model.DTO.AuthBody;
import com.gt4w.clinica.service.AuthService;

@RestController
@RequestMapping({ "/auth" })
@CrossOrigin(value = "*")
public class AuthController {

	@Autowired
	AuthService authService;

	@PostMapping("/")
	public ResponseEntity<?> login(@RequestBody AuthBody data) {
		try {
			if (data.getNome() == null) {
				return new ResponseEntity<String>("Forneça um nome", HttpStatus.BAD_REQUEST);
			} else if (data.getSenha() == null) {
				return new ResponseEntity<String>("Forneça uma senha", HttpStatus.BAD_REQUEST);
			}
			
			Map<String, Object> response = authService.login(data);

			return new ResponseEntity<Object>(response.get("message"), HttpStatus.valueOf((int) response.get("status")));
		} catch (AuthenticationException e) {
			throw new BadCredentialsException("Invalid cpf/password supplied");
		}
	}
}
