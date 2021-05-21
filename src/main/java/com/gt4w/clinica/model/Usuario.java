package com.gt4w.clinica.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "usuario")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotNull(message = "Campo Nome não pode ser nulo!")
	@NotEmpty(message = "Campo Nome pode ser vazio!")
	@Column(name = "nome", unique = true)
	private String nome;

	@Column(name = "cpf", unique = true)
	@NotNull(message = "Campo CPF não pode ser nulo!")
	@NotEmpty(message = "Campo CPF pode ser vazio!")
	@JsonIgnore
	private String cpf;

	@Column(name = "senha")
	@NotNull(message = "Campo Senha não pode ser nulo!")
	@NotEmpty(message = "Campo Senha pode ser vazio!")
	private String senha;

	@Column(name = "role")
	@NotNull(message = "Campo Role não pode ser nulo!")
	@NotEmpty(message = "Campo Role pode ser vazio!")
	private String role;

	public Usuario() {
	}

	public Usuario(String nome, String cpf, String senha, String role) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
		this.role = role;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public void setUf(String senha) {
		this.senha = senha;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
}
