package com.generation.BlogDaGabs.Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_postagem")
public class Postagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull (message = "O atributo titulo não pode estar vazio!")
	@Size(min = 5, max = 255)
	private String titulo;
	
	@NotNull (message = "O atributo texto não pode estar vazio!")
	@Size(min = 10, max = 1000)
	private String texto;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date data = new java.sql.Date(System.currentTimeMillis());
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")	
	@JoinColumn(name = "tema_id") 
	private Tema tema;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;

	// Getters And Setter
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
}
