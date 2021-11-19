package aps.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import aps.modelo.Ong;

public interface OngRepository extends JpaRepository<Ong, Long> {

	List<Ong> findByNome(String nome);
	
}
