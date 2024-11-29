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

import com.minegocio.tallerMiNegocio.entity.DireccionCliente;
import com.minegocio.tallerMiNegocio.service.DireccionClienteService;

import lombok.RequiredArgsConstructor;

/*
 * Clase controller a la que accede el cliente (solicitudes). Realiza un método en función de la URL.
 */

@RestController                                 // Define que la clase es un controlador para manejar un servicio
@RequestMapping("/direcciones")                 // Mapea un grupo de para la API
@RequiredArgsConstructor                        // Contructor para manejar dependencias 
@Validated                                      // Manejar/validar los argumentos de un método
public class DireccionClienteController {

    private final DireccionClienteService direccionClienteService;

    /*
     * Método de solicitud GET. Recupera todas las direcciones de los clientes de la tabla "DIRECCION_CLIENTE".
     * URL: localhost:8080/direcciones/alldirecciones
     * @return List<DireccionCliente>
     */
    @GetMapping("/alldirecciones")
    public ResponseEntity<List<DireccionCliente>> getAllDireccionesClient(){
        return ResponseEntity.ok().body(direccionClienteService.getAllDireccionesCliente());
    }

    /*
     * Método de solicitud GET. Recupera una dirección de la tabla "DIRECCION_CLIENTE", con el ID proporcionado.
     * URL: localhost:8080/direcciones/{id}
     * @return DireccionCliente
     */
    @GetMapping("/{id}")
    public ResponseEntity<DireccionCliente> getDireccionClienteById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(direccionClienteService.getDireccionClienteById(id));
    }
    
    /*
     * Método de solicitud POST. Guarda una dirección de un cliente en la tabla "DIRECCION_CLIENTE". ID autoincremental.
     * URL: localhost:8080/direcciones
     * @return DireccionCliente (guardado)
     */
    @PostMapping("/")
    public ResponseEntity<DireccionCliente> saveDireccionCliente(@RequestBody DireccionCliente direccionCliente) {
        return ResponseEntity.ok().body(direccionClienteService.saveDireccionCliente(direccionCliente));
    }

    /*
     * Método de solicitud PUT. Actualiza una dirección en la tabla "DIRECCION_CLIENTE" con el objeto DireccionCliente proporcionado
     * URL: localhost:8080/direcciones/upt
     * @return DireccionCliente (actualizado)
     */
    @PutMapping("/upt")
    public ResponseEntity<DireccionCliente> updatedDireccionCliente(@RequestBody DireccionCliente direccionCliente) {
        return ResponseEntity.ok().body(direccionClienteService.updateDireccionCliente(direccionCliente));
    }

    /*
     * Método de solicitud DELETE. Elimina un cliente en la tabla "DIRECCION_CLIENTE" con el ID proporcinado
     * URL: localhost:8080/direcciones/dlt/{id}"
     * @return String (Mensaje de eliminación)
     */
    @DeleteMapping("/dlt/{id}")
    public ResponseEntity<String> deleteDireccionClienteById(@PathVariable Integer id){
        direccionClienteService.deleteDireccionClienteById(id);
        return ResponseEntity.ok().body("Dirección eliminada existosamente.");
    }
}
