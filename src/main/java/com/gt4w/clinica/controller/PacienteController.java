package com.gt4w.clinica.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gt4w.clinica.model.Paciente;
import com.gt4w.clinica.model.DTO.PacienteDTO;
import com.gt4w.clinica.security.SecurityHandler;
import com.gt4w.clinica.service.PacienteService;


@RestController
@RequestMapping({ "/paciente" })
@CrossOrigin(value = "*")
public class PacienteController {

	@Autowired
	PacienteService pacienteService;
	
	@Autowired
	SecurityHandler securityHandler;

	@RequestMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
	public ResponseEntity<?> save(@RequestBody PacienteDTO pacienteDTO, HttpServletRequest http) {
		try {
			if (securityHandler.autorizarAmbos(http.getHeader("authorization")) != true) {
				return new ResponseEntity<String>("Usuário não autorizado", HttpStatus.FORBIDDEN);
			}
			
			Paciente paciente = pacienteService.save(pacienteDTO);
			return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}

	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public ResponseEntity<?> findAll(HttpServletRequest http) {
		try {
			if (securityHandler.autorizarMedico(http.getHeader("authorization")) != true) {
				return new ResponseEntity<String>("Usuário não autorizado!", HttpStatus.FORBIDDEN);
			}
			List<Paciente> pacientes = pacienteService.findAll();
			return new ResponseEntity<List<Paciente>>(pacientes, HttpStatus.OK);
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
			String retorno = pacienteService.delete(id);
			return new ResponseEntity<String>(retorno, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
}
