package aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import aps.modelo.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByNome(String nome);
	
}
