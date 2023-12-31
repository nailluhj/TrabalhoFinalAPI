package org.serratec.projetofinal.ApiRestful.DTO;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.serratec.projetofinal.ApiRestful.model.Relacionamento;
import org.serratec.projetofinal.ApiRestful.model.Usuario;

public class UsuarioDTO implements Serializable {
    private static final long serialVersionUID = 1L;
    
    private Long id;
    private String nome;
    private String sobrenome;
    private String email;
    private LocalDate dataNascimento;
    private List<RelacionamentoDTO> relacionamentos;

    public UsuarioDTO() {
    }

    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.sobrenome = usuario.getSobrenome();
        this.email = usuario.getEmail();
        this.dataNascimento = usuario.getDataNascimento();
        relacionamentos = new ArrayList<>();
        
        for (Relacionamento relacionamento : usuario.getRelacionamento()) {
        	UsuarioDTO target = relacionamento.getUsuarioDTO();
        	
        	if (target == null)
        		continue;
        	
        	relacionamentos.addAll(target.getRelacionamentos());
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public List<RelacionamentoDTO> getRelacionamentos() {
        return relacionamentos;
    }

    public void setRelacionamentos(List<RelacionamentoDTO> relacionamennto) {
        this.relacionamentos = relacionamennto;
    }

	public void setUrlImagem(String string) {
			
	}
}
