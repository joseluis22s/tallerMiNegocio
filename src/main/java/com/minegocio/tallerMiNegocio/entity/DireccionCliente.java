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

 @NoArgsConstructor                 // Genera constructor sin argumentos. Requerido por @Entity y @AllArgsContructor, debido a JPA/Hibernate, que lo necesita.
 @AllArgsConstructor                // Genera constructor con parametro, que son los campos de la clase. Inicializar
@Data                               // Genera getters y setter
@Entity                             // Define a una clase como una entidad de la BD
@Table(name="\"DIRECCION_CLIENTE\"", schema="\"schTallerMiNegocio\"")
public class DireccionCliente {

    // TODO: VErificar con postman si es necesaria la notation @NonNull
    
    @Id
    @Column(name="\"ID\"")
    //@Nonnull
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;

    //@Nonnull
    @Column(name="\"PROVINCIA\"")
    private String provincia;

    //@Nonnull
    @Column(name="\"CIUDAD\"")
    private String ciudad;

    //@Nonnull
    @Column(name="\"DIRECCION\"")
    private String direccion;

    // @Nonnull
    @Column(name="\"ES_MATRIZ\"")
    private Boolean esMatriz;

    // @Nonnull
    @ManyToOne
    @JoinColumn(name="\"ID_CLIENTE\"")
    private Cliente cliente;

}
