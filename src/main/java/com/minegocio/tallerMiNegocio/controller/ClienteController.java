package com.minegocio.tallerMiNegocio.controller;
/**
 * Controller class is where all the user requests are handled and required/appropriate
 * responses are sent
 */

import java.util.List;

import org.apache.catalina.connector.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.minegocio.tallerMiNegocio.entity.Cliente;
import com.minegocio.tallerMiNegocio.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/employee/v1")
@RequiredArgsConstructor
@Validated

public class ClienteController {
    private final ClienteService clienteService;

    @GetMapping("/")
    public ResponseEntity<List<Cliente>> getAllClientes(){
        return ResponseEntity.ok().body(clienteService.getAllClientes());
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Cliente> getClienteById(@PathVariable Integer id) {
    //     return ResponseEntity.ok();
    // }


    
}
