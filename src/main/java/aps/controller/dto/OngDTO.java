package aps.controller.dto;

import java.util.List;
import java.util.stream.Collectors;

import aps.modelo.Ong;

public class OngDTO {

	private Long id;
	private String nome;;
	
	public OngDTO(Ong ong) {
		this.id = ong.getId();
		this.nome = ong.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public static List<OngDTO> converter(List<Ong> ongs) {
		return ongs.stream().map(OngDTO::new).collect(Collectors.toList());
	}

	

}
