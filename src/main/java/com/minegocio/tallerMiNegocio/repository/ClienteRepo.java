package com.minegocio.tallerMiNegocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minegocio.tallerMiNegocio.entity.Cliente;


/**
 * Repositorio es la interface (punto de conexión) que da acceso a los datros de la BD.
 * Repositorio para acceso a los datos de la tabla "CLIENTE"
 */
  
public interface ClienteRepo extends JpaRepository<Cliente, Integer>{

    List<Cliente> findByNumeroIdentificacion(String numeroIdentificacion);
    List<Cliente> findByNombres(String nombres);
}
