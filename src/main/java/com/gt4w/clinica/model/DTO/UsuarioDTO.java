package com.gt4w.clinica.model.DTO;

public class UsuarioDTO {

	private String nome;
	
	private String cpf;
	
	private String senha;

	public UsuarioDTO() {
	}

	public UsuarioDTO(String nome, String cpf, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
	}

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

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
	