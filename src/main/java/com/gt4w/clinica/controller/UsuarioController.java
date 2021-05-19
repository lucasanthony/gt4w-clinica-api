package com.gt4w.clinica.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gt4w.clinica.model.Usuario;
import com.gt4w.clinica.model.DTO.UsuarioDTO;
import com.gt4w.clinica.service.UsuarioService;

@RestController
@RequestMapping({ "/usuario" })
@CrossOrigin(value = "*")
public class UsuarioController {
	
	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
//	@ApiOperation(value = "retorna os pacientes")
	public ResponseEntity<?> save(@RequestBody UsuarioDTO usuarioDTO) {
		try {
			Usuario usuario = usuarioService.save(usuarioDTO);
			return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
//	@ApiOperation(value = "retorna os pacientes")
	public ResponseEntity<?> findAll() {
		try {
			List<Usuario> usuarios = usuarioService.findAll();
			return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
}
