package com.minegocio.tallerMiNegocio.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minegocio.tallerMiNegocio.entity.Cliente;
import com.minegocio.tallerMiNegocio.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController                             // Define que la clase es un controlador
@RequestMapping("/clientes")                // Mapea un grupo de para la API
@RequiredArgsConstructor                    // Contructor para manejar dependencias 
@Validated                                  // Manejar los argumentos de un método

/**
 * Clase controller es a la que accede el cliente (solicitudes). Realice un método en función de la URL
 */

public class ClienteController {

    private final ClienteService clienteService;

    /*
     * Método de solicitud GET. Recupera todos los clientes de la tabla "CLIENTES"
     * URL: localhost:8080/clientes/allclientes
     * @return List<Cliente>
     */
    @GetMapping("/allclientes")
    public ResponseEntity<List<Cliente>> getAllClientes(){
        return ResponseEntity.ok().body(clienteService.getAllClientes());
    }
    
    /*
     * Método de solicitud GET. Recupera un cliente de la tabla "CLIENTES", con el ID proporcionado 
     * URL: localhost:8080/clientes/{id}
     * @return Cliente
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(clienteService.getClienteById(id));
    }

    /*
     * Método de solicitud POST. Guarda un cliente en la tabla "CLIENTES". ID autoincremental
     * URL: localhost:8080/clientes
     * @return Cliente (guardado)
     */
    @PostMapping("/")
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok().body(clienteService.saveCliente(cliente));
    }

    /*
     * Método de solicitud PUT. Actualiza un cliente en la tabla "CLIENTES".
     * URL: localhost:8080/clientes/{id}
     * @return Cliente (actualizado)
     */
    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updatedCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok().body(clienteService.updateCliente(cliente));
    }

    /*
     * Método de solicitud PUT. Elimina un cliente en la tabla "CLIENTES"
     * URL: localhost:8080/clientes
     * @return String (Mensaje de eliminación)
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(){
        return ResponseEntity.ok().body("Cliente eliminado existosamente.");
    }

}