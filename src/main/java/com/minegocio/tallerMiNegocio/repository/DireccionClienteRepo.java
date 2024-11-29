package com.minegocio.tallerMiNegocio.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minegocio.tallerMiNegocio.entity.DireccionCliente;
/**
 * Repositorio es la interface (punto de conexión) que da acceso a los datros de la BD.
 * Repositorio para acceso a los datos de la tabla "DIRECCION_CLIENTE"
 */
public interface DireccionClienteRepo extends JpaRepository<DireccionCliente, Integer>{

}
