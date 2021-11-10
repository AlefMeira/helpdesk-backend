package com.metodo.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metodo.helpdesk.domain.Chamado;
import com.metodo.helpdesk.domain.Cliente;
import com.metodo.helpdesk.domain.Tecnico;
import com.metodo.helpdesk.domain.enums.Perfil;
import com.metodo.helpdesk.domain.enums.Prioridade;
import com.metodo.helpdesk.domain.enums.Status;
import com.metodo.helpdesk.repositories.ChamadoRepository;
import com.metodo.helpdesk.repositories.ClienteRepository;
import com.metodo.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {

	// aplicando injeção de dependencia
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {

		Tecnico tec1 = new Tecnico(null, "Alef Chaves", "12028874575", "metodo@gmail.com", "1234");
		tec1.addPerfil(Perfil.ADMIN);

		Tecnico tec2 = new Tecnico(null, "Pamela Moreira", "53927310158", "pamela@gmail.com", "1234");
		Tecnico tec3 = new Tecnico(null, "Tiago Sousa", "20239277228", "tiago@gmail.com", "1234");
		Tecnico tec4 = new Tecnico(null, "Levy Machado", "88577615332", "levy@gmail.com", "1234");

		Cliente cli1 = new Cliente(null, "Linus Torvalds", "18551216384", "torvalds@mail.com", "123");
		Cliente cli2 = new Cliente(null, "Pedro Sampaio", "54447775760", "pedro@gmail.com", "1234");
		Cliente cli3 = new Cliente(null, "Laura Clent", "68932226458", "laura@gmail.com", "1234");

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado c1", "Primeiro chamado", tec1,cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamdo c2", "Terceiro chamdo", tec2, cli3);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado c3", "primeiro chamado", tec3, cli2);

		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3));

	}

}
