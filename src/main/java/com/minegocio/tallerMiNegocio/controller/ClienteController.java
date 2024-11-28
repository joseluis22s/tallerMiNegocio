package com.minegocio.tallerMiNegocio.controller;
/**
 * Controller class is where all the user requests are handled and required/appropriate
 * responses are sent
 */

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

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
@Validated

public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping("/clientes")
    public ResponseEntity<List<Cliente>> getAllClientes(){
        return ResponseEntity.ok().body(clienteService.getAllClientes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
        return ResponseEntity.ok().body(clienteService.getClienteById(id));
    }

    @PostMapping("/")
    public ResponseEntity<Cliente> saveCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok().body(clienteService.saveCliente(cliente));
    }

    @PutMapping("path/{id}")
    public ResponseEntity<Cliente> updatedCliente(@RequestBody Cliente cliente) {
        return ResponseEntity.ok().body(clienteService.updateCliente(cliente));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(){
        return ResponseEntity.ok().body("Cliente eliminado existosamente.");
    }

}