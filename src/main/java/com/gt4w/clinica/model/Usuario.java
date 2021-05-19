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
@Table(name = "paciente")
public class Usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull(message = "Campo Nome não pode ser nulo!")
    @NotEmpty(message = "Campo Nome pode ser vazio!")
	@Column(name = "nome")
	private String nome;

	@Column(name = "cpf", unique = true)
	@NotNull(message = "Campo CPF não pode ser nulo!")
    @NotEmpty(message = "Campo CPF pode ser vazio!")
	@JsonIgnore
	private String cpf;
	
	@Column(name = "uf")
	@NotNull(message = "Campo Senha não pode ser nulo!")
    @NotEmpty(message = "Campo Senha pode ser vazio!")
	private String senha;

	public Usuario() {
	}

	public Usuario(String nome, String cpf, String senha) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.senha = senha;
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
}
	