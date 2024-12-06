package com.minegocio.tallerMiNegocio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.minegocio.tallerMiNegocio.entity.Cliente;


/**
 * Repositorio es la interface (punto de conexión) que da acceso a los datros de la BD.
 * Repositorio para acceso a los datos de la tabla "CLIENTE"
 */
  
public interface ClienteRepo extends JpaRepository<Cliente, Integer>{

    // @Query(value="SELECT c FROM Cliente c WHERE e.numeroIdentificacion = :numeroIdentificacion", nativeQuery=true)
    // List<Cliente> findByNumeroIdentificacion(@Param("numero_identificacion") String numeroIdentificacion);
    List<Cliente> findByNumeroIdentificacion(String numeroIdentificacion);
}
