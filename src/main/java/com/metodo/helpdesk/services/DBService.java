package com.metodo.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

import ch.qos.logback.core.encoder.Encoder;

@Service
public class DBService {

	// aplicando injeção de dependencia
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private TecnicoRepository tecnicoRepository;

	@Autowired
	private ChamadoRepository chamadoRepository;
	
	@Autowired BCryptPasswordEncoder encoder;

	public void instanciaDB() {

		Tecnico tec1 = new Tecnico(null, "Alef Chaves", "54856805690", "alef@gmail.com", encoder.encode("1234"));
		tec1.addPerfil(Perfil.ADMIN);

		Tecnico tec2 = new Tecnico(null, "Pamela Moreira", "67667650209", "pamela@gmail.com", encoder.encode("123"));
		Tecnico tec3 = new Tecnico(null, "Tiago Sousa", "67569148398", "tiago@gmail.com", encoder.encode("123"));
		Tecnico tec4 = new Tecnico(null, "Levy Machado", "42637810823", "levy@gmail.com", encoder.encode("123"));

		Cliente cli1 = new Cliente(null, "Linus Torvalds", "73114424600", "torvalds@mail.com", encoder.encode("123"));
		Cliente cli2 = new Cliente(null, "Pedro Sampaio", "80466405499", "pedro@gmail.com", encoder.encode("123"));
		Cliente cli3 = new Cliente(null, "Laura Clent", "93451318687", "laura@gmail.com", encoder.encode("123"));

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado c1", "Primeiro chamado", tec1,cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ANDAMENTO, "Chamdo c2", "Terceiro chamdo", tec2, cli3);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ABERTO, "Chamado c3", "primeiro chamado", tec3, cli2);

		tecnicoRepository.saveAll(Arrays.asList(tec1, tec2, tec3, tec4));
		clienteRepository.saveAll(Arrays.asList(cli1, cli2, cli3));
		chamadoRepository.saveAll(Arrays.asList(c1, c2, c3));

	}

}
