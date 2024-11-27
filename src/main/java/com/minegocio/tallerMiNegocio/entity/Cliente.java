package com.minegocio.tallerMiNegocio.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * An entity class represents a table in a relational database
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "cliente")

public class Cliente {

    @Id
    private Integer id;
    private String numero_identificacion;
    private String tipo_identificacion;
    private String nombres;
    private String correo;
    private String numero_celular;

}
