package com.gt4w.clinica.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gt4w.clinica.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	Usuario findByCpf(String cpf);

	List<Usuario> findByRole(String role);

	Usuario findByNomeIgnoreCase(String nome);
}
