package com.metodo.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metodo.helpdesk.domain.Cliente;
import com.metodo.helpdesk.domain.Pessoa;
import com.metodo.helpdesk.domain.Tecnico;
import com.metodo.helpdesk.domain.dtos.ClienteDTO;
import com.metodo.helpdesk.repositories.ClienteRepository;
import com.metodo.helpdesk.repositories.PessoaRepository;
import com.metodo.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.metodo.helpdesk.services.exceptions.ObjectNotFoundException;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PessoaRepository pessoaRepository;

	public Cliente findById(Integer id) {
		Optional<Cliente> obj = clienteRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Cliente não encontrado: " + id));
	}

	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	public Cliente create(ClienteDTO objDTO) {
		objDTO.setId(null);
		validaPorEmailECpf(objDTO);
		Cliente newObj = new Cliente(objDTO);
		return clienteRepository.save(newObj);
	}
	
	public Cliente update(Integer id, ClienteDTO objDTO) {
		objDTO.setId(id);
		Cliente oldObj = findById(id);
		validaPorEmailECpf(objDTO);
		oldObj = new Cliente(objDTO);
		return clienteRepository.save(oldObj);
	}
	
	public void delete(Integer id) {
		Cliente obj = findById(id);

		if (obj.getChamados().size() > 0) {
			throw new DataIntegrityViolationException("O Cliente possui chamadas em aberto e não pode ser deletado!");
		}
		clienteRepository.deleteById(id);
	}
	
	private void validaPorEmailECpf(ClienteDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já existe no sistema!");
		}

		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Email já existe no sistema!");
		}

	}

}
