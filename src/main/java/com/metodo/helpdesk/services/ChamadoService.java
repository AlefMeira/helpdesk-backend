package com.metodo.helpdesk.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.metodo.helpdesk.domain.Chamado;
import com.metodo.helpdesk.domain.dtos.ChamadoDTO;
import com.metodo.helpdesk.repositories.ChamadoRepository;
import com.metodo.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ChamadoService {

	@Autowired
	private ChamadoRepository chamadoRepository;

	public Chamado findById(Integer id) {
		Optional<Chamado> obj = chamadoRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: " + id));
	}
	
	public List<Chamado> findAll() {
		return chamadoRepository.findAll();
	}

}
