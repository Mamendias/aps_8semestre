package aps.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import aps.modelo.Usuario;
import aps.repository.UsuarioRepository;

public class UsuarioForm {

	@NotNull @NotEmpty
	private String nome;
	
	@NotNull @NotEmpty
	private String login;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Usuario converter(UsuarioRepository usuarioRepository) {
		return new Usuario(nome, login);
		
	}
	public Usuario atualizar(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.getOne(id);
		System.out.println("teste" + usuario);
		usuario.setNome(this.nome);
		usuario.setLogin(this.login);
		
		return usuario;
	}

}
