package com.gt4w.clinica.model.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PacienteDTO {

	@JsonProperty(value ="Necessário fornecer um nome", required = true)
	private String nome;
	
	@JsonProperty(value ="Necessário fornecer um cpf", required = true)
	private String cpf;
	
	@JsonProperty(value ="Necessário fornecer um UF", required = true)
	private String uf;

	@JsonProperty(required = false)
	private String data_nascimento;
	
	@JsonProperty(required = false)
	private int peso;

	@JsonProperty(required = false)
	private String altura;

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
	