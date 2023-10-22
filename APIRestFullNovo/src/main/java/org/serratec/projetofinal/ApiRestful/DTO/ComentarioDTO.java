package org.serratec.projetofinal.ApiRestful.DTO;

import java.io.Serializable;
import java.util.Date;

public class ComentarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String texto;
	private Date data;
	private UsuarioDTO autor;
	private Long idPostagem;

	public ComentarioDTO() {
	}

	public ComentarioDTO(String texto, Date data, UsuarioDTO autor) {
		this.texto = texto;
		this.data = data;
		this.autor = autor;
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

	public UsuarioDTO getAutor() {
		return autor;
	}

	public void setAutor(UsuarioDTO autor) {
		this.autor = autor;
	}

	public void setIdPostagem(Long idPostagem) {
		this.idPostagem = idPostagem;

	}

	public Long getIdPostagem() {
		return idPostagem;
	}

}


