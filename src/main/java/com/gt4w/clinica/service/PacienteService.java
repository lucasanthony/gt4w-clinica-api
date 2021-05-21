package com.gt4w.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.gt4w.clinica.model.Paciente;
import com.gt4w.clinica.model.DTO.PacienteDTO;
import com.gt4w.clinica.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	PacienteRepository pacienteRepository;

	public Paciente save(PacienteDTO paciente) throws Exception {
		try {
			String strong_salt = BCrypt.gensalt(10);
			String cpf_criptografado = BCrypt.hashpw(paciente.getCpf(), strong_salt);
			
			Paciente pacienteCriado = new Paciente(paciente.getNome(), cpf_criptografado, paciente.getUf(),
					paciente.getData_nascimento(), paciente.getPeso(), paciente.getAltura());
			pacienteRepository.save(pacienteCriado);
			return pacienteCriado;
		} catch (Exception e) {
			throw e;
		}

	}

	public List<Paciente> findAll() {
		List<Paciente> pacientes = this.pacienteRepository.findAll();

		return pacientes;
	}
	
	public String delete(Long id) {
		try {
			this.pacienteRepository.deleteById(id);
			return "Paciente deletado com sucesso!";
		} catch (Exception e) {
			throw e;
		}

	}
}
