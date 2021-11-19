package aps.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import aps.modelo.Ong;
import aps.repository.OngRepository;

public class OngForm {

	@NotNull @NotEmpty
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Ong converter(OngRepository ongRepository) {
		return new Ong(nome);
		
	}
	public Ong atualizar(Long id, OngRepository ongRepository) {
		Ong ong = ongRepository.getOne(id);
		ong.setNome(this.nome);
		
		return ong;
	}

}
