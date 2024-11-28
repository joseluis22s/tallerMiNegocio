package com.minegocio.tallerMiNegocio.entity;

import jakarta.persistence.Column;
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
@Table(name = "\"CLIENTE\"", schema="\"schTallerMiNegocio\"")

public class Cliente {

    @Id
    @Column(name="\"ID\"")
    private Integer id;

    @Column(name="\"NUMERO_IDENTIFICACION\"")
    private String numero_identificacion;

    @Column(name="\"TIPO_IDENTIFICACION\"")
    private String tipo_identificacion;

    @Column(name="\"NOMBRES\"")
    private String nombres;

    @Column(name="\"CORREO\"")
    private String correo;

    @Column(name="\"NUMERO_CELULAR\"")
    private String numero_celular;

}
