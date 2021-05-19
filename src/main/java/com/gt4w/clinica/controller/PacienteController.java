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

import com.gt4w.clinica.model.Paciente;
import com.gt4w.clinica.model.DTO.PacienteDTO;
import com.gt4w.clinica.service.PacienteService;

@RestController
@RequestMapping({ "/paciente" })
@CrossOrigin(value = "*")
public class PacienteController {
	
	@Autowired
	PacienteService pacienteService;

	@RequestMapping(value = "/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST)
//	@ApiOperation(value = "retorna os pacientes")
	public ResponseEntity<?> save(@RequestBody PacienteDTO pacienteDTO) {
		try {
			Paciente paciente = pacienteService.save(pacienteDTO);
			return new ResponseEntity<Paciente>(paciente, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
	
	@RequestMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
//	@ApiOperation(value = "retorna os pacientes")
	public ResponseEntity<?> findAll() {
		try {
			List<Paciente> pacientes = pacienteService.findAll();
			return new ResponseEntity<List<Paciente>>(pacientes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.SERVICE_UNAVAILABLE);
		}
	}
}
