package com.gt4w.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.gt4w.clinica.model.Usuario;
import com.gt4w.clinica.model.DTO.UsuarioDTO;
import com.gt4w.clinica.repository.UsuarioRepository;

import domain.Roles;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario save(UsuarioDTO usuario) throws Exception {
		try {
			String salt = BCrypt.gensalt(12);
			String cpf_criptografado = BCrypt.hashpw(usuario.getCpf(), salt);
			String senha_criptografada = BCrypt.hashpw(usuario.getSenha(), salt);

			Usuario usuarioCriado = new Usuario(usuario.getNome(), cpf_criptografado, senha_criptografada,
					Roles.ROLE_ENFERMEIRO);
			
			usuarioRepository.save(usuarioCriado);
			return usuarioCriado;
		} catch (Exception e) {
			throw e;
		}

	}

	public List<Usuario> findAll() {
		List<Usuario> usuarios = this.usuarioRepository.findByRole("ENFERMEIRO");

		return usuarios;
	}

	public String delete(Long id) {
		try {
			this.usuarioRepository.deleteById(id);
			return "Usuário deletado com sucesso!";
		} catch (Exception e) {
			throw e;
		}

	}
}
