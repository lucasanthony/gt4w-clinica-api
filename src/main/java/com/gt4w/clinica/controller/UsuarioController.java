package com.gt4w.clinica.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gt4w.clinica.model.Usuario;
import com.gt4w.clinica.model.DTO.UsuarioDTO;
import com.gt4w.clinica.repository.UsuarioRepository;
import com.gt4w.clinica.security.SecurityHandler;
import com.gt4w.clinica.service.UsuarioService;

@RestController
@RequestMapping({ "/usuario" })
@CrossOrigin(value = "*")
public class UsuarioController {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	SecurityHandler securityHandler;

	@PostMapping(value = "/")
	public ResponseEntity<?> save(@RequestBody UsuarioDTO usuarioDTO, HttpServletRequest http) {
		try {
			if (securityHandler.autorizarMedico(http.getHeader("authorization")) != true) {
				return new ResponseEntity<String>("Usuário não autorizado!", HttpStatus.FORBIDDEN);
			}
			Usuario usuario = usuarioService.save(usuarioDTO);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@GetMapping(value = "/")
	public ResponseEntity<?> findAll(HttpServletRequest http) {
		try {
			if (securityHandler.autorizarMedico(http.getHeader("authorization")) != true) {
				return new ResponseEntity<String>("Usuário não autorizado!", HttpStatus.FORBIDDEN);
			}
			List<Usuario> usuarios = usuarioService.findAll();
			return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(@PathVariable Long id, HttpServletRequest http) {
		try {
			if (securityHandler.autorizarMedico(http.getHeader("authorization")) != true) {
				return new ResponseEntity<String>("Usuário não autorizado!", HttpStatus.FORBIDDEN);
			}
			String retorno = usuarioService.delete(id);
			return new ResponseEntity<String>(retorno, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
}
