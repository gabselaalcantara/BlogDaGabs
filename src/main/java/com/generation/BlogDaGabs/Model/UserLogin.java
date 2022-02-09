package com.generation.BlogDaGabs.Model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class UserLogin {

	private long id;
	
	@NotBlank(message = "O atributo nome não pode estar em branco")
	private String nome;

	@NotBlank(message = "Necessario Email")
	@Email(message = "O usuario deve seguir o padrão usuario@email.com")
	private String usuario;

	private String senha;

	private String token;
	
	// Metódos Getters and Setters

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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
		
}
