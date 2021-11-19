package aps.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import aps.controller.dto.OngDTO;
import aps.controller.form.OngForm;
import aps.modelo.Ong;
import aps.repository.OngRepository;

@RestController
@RequestMapping("/ong")
public class OngController {
	
	@Autowired
	private OngRepository ongRepository;
	
	
	@GetMapping
	public List<OngDTO> lista(String ong) {
		if (ong == null) {
			List<Ong> ongs = ongRepository.findAll();
			return OngDTO.converter(ongs);
		} else {
			List<Ong> ongs = ongRepository.findByNome(ong);
			return OngDTO.converter(ongs);
		}
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<OngDTO> cadastrar(@RequestBody @Valid OngForm form, UriComponentsBuilder uriBuilder) {
		Ong ong = form.converter(ongRepository);
		ongRepository.save(ong);
		
		URI uri = uriBuilder.path("/ong/{id}").buildAndExpand(ong.getId()).toUri();
		return ResponseEntity.created(uri).body(new OngDTO(ong));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<OngDTO> detalhar(@PathVariable Long id) {
		Optional<Ong> ong = ongRepository.findById(id);
		if (ong.isPresent()) {
			return ResponseEntity.ok(new OngDTO(ong.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<OngDTO> atualizar(@PathVariable Long id, @RequestBody @Valid OngForm form) {
		Optional<Ong> optional = ongRepository.findById(id);
		if (optional.isPresent()) {
			Ong ong = form.atualizar(id, ongRepository);
			return ResponseEntity.ok(new OngDTO(ong));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Ong> optional = ongRepository.findById(id);
		if (optional.isPresent()) {
			ongRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();
	}
	
}







