package com.metodo.helpdesk.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.metodo.helpdesk.domain.Tecnico;
import com.metodo.helpdesk.domain.dtos.TecnicoDTO;
import com.metodo.helpdesk.services.TecnicoService;

@RestController
@RequestMapping("/tecnicos")
public class TecnicoResource {

	@Autowired
	private TecnicoService service;

	@GetMapping("/{id}")
	public ResponseEntity<TecnicoDTO> findById(@PathVariable Integer id) {
		Tecnico obj = service.findById(id);
		return ResponseEntity.ok().body(new TecnicoDTO(obj));
	}

	@GetMapping
	public ResponseEntity<List<TecnicoDTO>> findAll() {
		List<Tecnico> list = service.findAll();
		List<TecnicoDTO> listDTO = list.stream().map(obj -> new TecnicoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok(listDTO);
	}

}
