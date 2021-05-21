package com.gt4w.clinica.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.gt4w.clinica.model.Usuario;
import com.gt4w.clinica.model.DTO.AuthBody;
import com.gt4w.clinica.repository.UsuarioRepository;
import com.gt4w.clinica.security.SecurityHandler;

@Service
public class AuthService {

	@Autowired
	UsuarioRepository usuarioRepository;

	@Autowired
	SecurityHandler securityHandler;

	public Map<String, Object> login(AuthBody data) {
		try {

			Map<String, Object> responseData = new HashMap<>();
			
			Usuario usuario = usuarioRepository.findByNomeIgnoreCase(data.getNome());

			if (usuario == null) {
				responseData.put("status", 404);
				responseData.put("message", "Usuário não existe!");
			}
			
			Boolean senhaConfere = BCrypt.checkpw(data.getSenha(), usuario.getSenha());

			if (!senhaConfere) {
				responseData.put("status", 401);
				responseData.put("message", "Senha incorreta!");
			} else {
				List<String> content = new ArrayList<>();
				String token = this.securityHandler.createJWT(usuario);
				content.add(token);
				content.add(usuario.getRole());
				responseData.put("status", 200);
				responseData.put("message", content);
			}

			return responseData;
		} catch (Exception e) {
			throw e;
		}
	}
}
