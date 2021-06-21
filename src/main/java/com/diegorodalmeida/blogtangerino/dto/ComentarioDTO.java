package com.diegorodalmeida.blogtangerino.dto;

import java.io.Serializable;

import javax.xml.crypto.Data;

public class ComentarioDTO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String comentario;
	private Data data;
	private AutorDTO autor;

	public ComentarioDTO () {
		
	}

	public ComentarioDTO(String comentario, Data data, AutorDTO autor) {
		super();
		this.comentario = comentario;
		this.data = data;
		this.autor = autor;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	public AutorDTO getAutor() {
		return autor;
	}

	public void setAutor(AutorDTO autor) {
		this.autor = autor;
	}
	
}

