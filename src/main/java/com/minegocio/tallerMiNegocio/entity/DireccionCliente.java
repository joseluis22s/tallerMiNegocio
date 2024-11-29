package com.minegocio.tallerMiNegocio.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Clase entity que representa la tabla "DIRECCION_CLIENTE" de la BD
 */

@NoArgsConstructor
@AllArgsConstructor
@Data                               // Genera getters y setter
@Entity                             // Define a una clase como una entidad de la BD
@Table(name="\"DIRECCION_CLIENTE\"", schema="\"schTallerMiNegocio\"")
public class DireccionCliente {
    
    @Id
    @Column(name="\"ID\"")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    @Column(name="\"PROVINCIA\"")
    private String provincia;

    @Column(name="\"CIUDAD\"")
    private String ciudad;

    @Column(name="\"DIRECCION\"")
    private String direccion;

    @ManyToOne
    @JoinColumn(name="\"ID_CLIENTE\"")
    // @Column(name="\"ID_CLIENTE\"")
    private Integer id_cliente;

}
