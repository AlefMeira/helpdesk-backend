package com.metodo.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metodo.helpdesk.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
