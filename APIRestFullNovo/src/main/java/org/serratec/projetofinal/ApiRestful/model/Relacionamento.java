package org.serratec.projetofinal.ApiRestful.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.serratec.projetofinal.ApiRestful.DTO.UsuarioDTO;

@Entity
@Table(name = "relacionamento")
public class Relacionamento {

	@EmbeddedId
	private RelacionamentoPK id = new RelacionamentoPK();

	@Column(name = "data_inicio")
	private LocalDate dataInicio;
	
	@Column(name = "foto_url")
    private String fotoUrl; 

	public Relacionamento() {
		
	}

	public Relacionamento(Usuario usuario, Usuario usuarioseguido) {
		
		this.id.setUsuario(usuario);
		this.id.setUsuarioseguido(usuarioseguido);
		this.dataInicio = LocalDate.now();
	}

	public RelacionamentoPK getId() {
		return id;
	}

	public void setId(RelacionamentoPK id) {
		this.id = id;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}
	
	public String getFotoUrl() {
	        return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
	        this.fotoUrl = fotoUrl;
	}

	public UsuarioDTO getUsuarioDTO() {
		
		return null;
	}
}   
	
