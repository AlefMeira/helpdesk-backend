package com.metodo.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metodo.helpdesk.domain.Chamado;

public interface ChamadoRepository extends JpaRepository<Chamado, Integer> {

}
