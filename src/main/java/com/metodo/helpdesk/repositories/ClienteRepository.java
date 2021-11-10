package com.metodo.helpdesk.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.metodo.helpdesk.domain.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
