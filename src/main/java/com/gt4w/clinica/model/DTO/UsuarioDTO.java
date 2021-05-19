package com.gt4w.clinica.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioDTO {

	@JsonProperty(value ="Necessário fornecer um nome", required = true)
	private String nome;
	
	@JsonProperty(value ="Necessário fornecer um cpf", required = true)
	private String cpf;
	
	@JsonProperty(value ="Necessário fornecer uma senha", required = true)
	private String senha;

//	public PacienteDTO() {
//	}
//
//	public PacienteDTO(String nome, String cpf, String uf, String data_nascimento, int peso, String altura) {
//		super();
//		this.nome = nome;
//		this.cpf = cpf;
//		this.uf = uf;
//		this.data_nascimento = data_nascimento;
//		this.peso = peso;
//		this.altura = altura;
//	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSenha() {
		return senha;
	}

	public void setUf(String senha) {
		this.senha = senha;
	}
}
	