package com.loginScreenApi.demo.controller;


public class Reqmsg {
	
	
	
	  
	  
	  
	  private String titulo;
	  
	  
	  private String post;

	

	

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

	public Reqmsg() {
		super();
	}

	public Reqmsg(String titulo, String post) {
		
		this.titulo = titulo;
		this.post = post;
	}

}
