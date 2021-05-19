package com.gt4w.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt4w.clinica.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
