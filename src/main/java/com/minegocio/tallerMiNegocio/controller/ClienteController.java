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
import com.minegocio.tallerMiNegocio.modelRequest.ClienteDireccionMatrizModelReq;
import com.minegocio.tallerMiNegocio.service.ClienteService;

import lombok.RequiredArgsConstructor;

@RestController                             // Define que la clase es un controlador para manejar un servicio
@RequestMapping("/clientes")                // Mapea un grupo de para la API
@RequiredArgsConstructor                    // Contructor para manejar dependencias 
@Validated                                  // Manejar/validar los argumentos de un método

/*
 * Clase controller a la que accede el cliente (solicitudes). Realiza un método en función de la URL.
 */

public class ClienteController {

    private final ClienteService clienteService;

    /*
     * Método de solicitud GET. Recupera un cliente de la tabla "CLIENTE", con el número de identificación proporcionado.
     * URL: localhost:8080/clientes/cliente
     * @return Cliente
     */
    @GetMapping("/cliente/{numeroIdentificacion}")
    public ResponseEntity<Cliente> getClienteByNumeroIdentificacion(@PathVariable String numeroIdentificacion){
        return ResponseEntity.ok().body(clienteService.getClienteByNumeroIdentificacion(numeroIdentificacion));
    }
    
    /*
     * Método de solicitud GET. Recupera una lista de clientes de la tabla "CLIENTE", con el nombre proporcionado.
     * URL: localhost:8080/clientes/{id}
     * @return Cliente
     */
    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(clienteService.getClienteById(id));
    }

    /*
     * Método de solicitud POST. Guarda un cliente en la tabla "CLIENTE". ID autoincremental.
     * URL: localhost:8080/clientes/pst
     * @return Cliente (guardado)
     */
    @PostMapping("/pst")
    public ResponseEntity<Cliente> saveNuevoClienteConDireccionMatriz(@RequestBody ClienteDireccionMatrizModelReq clienteDireccionMatrizModelReq) {
        return ResponseEntity.ok().body(clienteService.saveNuevoClienteConDireccionMatriz(clienteDireccionMatrizModelReq));
    }

    // /*
    //  * Método de solicitud POST. Guarda un cliente en la tabla "CLIENTE". ID autoincremental.
    //  * URL: localhost:8080/clientes
    //  * @return Cliente (guardado)
    //  */
    // @PostMapping("/")
    // public ResponseEntity<Cliente> saveClienteConDireccionMatriz(@RequestBody Cliente cliente) {
    //     return ResponseEntity.ok().body(clienteService.saveNuevoClienteConDireccionMatriz(cliente, direccionCliente));
    // }

    /*
     * Método de solicitud PUT. Actualiza un cliente en la tabla "CLIENTE" con el objeto Cliente proporcionado
     * URL: localhost:8080/clientes/upt
     * @return Cliente (actualizado)
     */
    @PutMapping("/upt")
    public ResponseEntity<Cliente> updatedCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok().body(clienteService.updateCliente(cliente));
    }

    /*
     * Método de solicitud DELETE. Elimina un cliente en la tabla "CLIENTE" con el ID proporcinado
     * URL: localhost:8080/clientes/dlt/{id}"
     * @return String (Mensaje de eliminación)
     */
    @DeleteMapping("/dlt/{id}")
    public ResponseEntity<String> deleteClienteById(@PathVariable Integer id){
        clienteService.deleteClienteById(id);
        return ResponseEntity.ok().body("Cliente eliminado existosamente.");
    }

}