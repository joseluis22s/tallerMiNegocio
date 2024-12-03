package com.minegocio.tallerMiNegocio.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase entity que representa la tabla "CLIENTE" de la BD
 */

@NoArgsConstructor
@AllArgsConstructor
@Data                               // Genera getters y setter
@Entity                             // Define a una clase como una entidad de la BD
@Table(name = "\"CLIENTE\"", schema="\"schTallerMiNegocio\"")

public class Cliente {

    @Id
    @Column(name="\"ID\"")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    @OneToMany(fetch=FetchType.LAZY, mappedBy="cliente",cascade=CascadeType.ALL)
    @JsonIgnoreProperties
    private List<DireccionCliente> direccionesCliente;
}
