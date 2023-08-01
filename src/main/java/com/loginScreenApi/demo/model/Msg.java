package com.loginScreenApi.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "mensagens")
public class Msg {
	
	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;
	  
	  @Column(nullable = false)
	  private String usuario;
	  
	  @Column(nullable = false)
	  private String titulo;
	  
	  @Column(nullable = false)
	  private String post;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Msg() {
		super();
	}

	public Msg(String usuario, String titulo, String post) {
		super();
		
		this.usuario = usuario;
		this.titulo = titulo;
		this.post = post;
	}
	  
	

}
