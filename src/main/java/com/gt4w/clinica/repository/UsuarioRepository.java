package com.gt4w.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt4w.clinica.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
