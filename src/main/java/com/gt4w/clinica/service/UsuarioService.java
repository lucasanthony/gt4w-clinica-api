package com.gt4w.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.gt4w.clinica.model.Usuario;
import com.gt4w.clinica.model.DTO.UsuarioDTO;
import com.gt4w.clinica.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;

	public Usuario save(UsuarioDTO usuario) throws Exception {
		try {
			// nome, cpf e uf obrigatorios
			String strong_salt = BCrypt.gensalt(10);
			String cpf_criptografado = BCrypt.hashpw(usuario.getCpf(), strong_salt);
			String senha_criptografado = BCrypt.hashpw(usuario.getSenha(), strong_salt);

			Usuario usuarioCriado = new Usuario(usuario.getNome(), cpf_criptografado, senha_criptografado);
			usuarioRepository.save(usuarioCriado);
			return usuarioCriado;
		} catch (Exception e) {
			throw e;
		}

	}

	public List<Usuario> findAll() {
		List<Usuario> usuarios = this.usuarioRepository.findAll();

		return usuarios;
	}
}
