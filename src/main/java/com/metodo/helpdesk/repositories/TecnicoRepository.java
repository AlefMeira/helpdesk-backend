package com.metodo.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metodo.helpdesk.domain.Tecnico;

public interface TecnicoRepository  extends JpaRepository<Tecnico, Integer> {

}
