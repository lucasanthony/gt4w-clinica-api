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
public class Paciente {

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
	@NotNull(message = "Campo UF não pode ser nulo!")
    @NotEmpty(message = "Campo UF pode ser vazio!")
	private String uf;

	@Column(name = "data_nascimento")
	private String data_nascimento;
	
	@Column(name = "peso")
	private int peso;
	
	@Column(name = "altura")
	private String altura;

	public Paciente() {
	}

	public Paciente(String nome, String cpf, String uf, String data_nascimento, int peso, String altura) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.uf = uf;
		this.data_nascimento = data_nascimento;
		this.peso = peso;
		this.altura = altura;
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

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getData_nascimento() {
		return data_nascimento;
	}

	public void setData_nascimento(String data_nascimento) {
		this.data_nascimento = data_nascimento;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}

	public String getAltura() {
		return altura;
	}

	public void setAltura(String altura) {
		this.altura = altura;
	}
}
	