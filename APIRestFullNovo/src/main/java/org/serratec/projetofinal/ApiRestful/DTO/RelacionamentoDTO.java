package org.serratec.projetofinal.ApiRestful.DTO;

import java.time.LocalDate;

import org.serratec.projetofinal.ApiRestful.model.Relacionamento;

public class RelacionamentoDTO {

	private UsuarioDTO usuarioDTO;

	private LocalDate dataInicio;
	
	private String url;

	public RelacionamentoDTO() {
		super();
	}

	public RelacionamentoDTO(Relacionamento relacionamento, String url) {
	    super();
	    this.usuarioDTO = new UsuarioDTO(relacionamento.getId().getUsuario());
	    this.dataInicio = relacionamento.getDataInicio();
	    this.setUrl(url);
	}

	public UsuarioDTO getUsuarioDTO() {
		return usuarioDTO;
	}

	public void setUsuarioDTO(UsuarioDTO usuarioDTO) {
		this.usuarioDTO = usuarioDTO;
	}

	public LocalDate getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(LocalDate dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}

