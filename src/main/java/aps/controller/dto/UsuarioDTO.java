package aps.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import aps.modelo.Usuario;

public class UsuarioDTO {

	private Long id;
	private String nome;
	private String login;
	
	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.login = usuario.getLogin();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public String getLogin() {
		return login;
	}
	
	public static List<UsuarioDTO> converter(List<Usuario> usuarios) {
		return usuarios.stream().map(UsuarioDTO::new).collect(Collectors.toList());
	}

	

}
