package com.minegocio.tallerMiNegocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minegocio.tallerMiNegocio.entity.Cliente;

/**
 * Repository is an interface that provides access to data in a database
 */

public interface ClienteRepo extends JpaRepository<Cliente, Integer>{

}
