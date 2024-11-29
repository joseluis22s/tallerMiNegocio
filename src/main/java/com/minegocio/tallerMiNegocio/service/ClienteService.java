package com.minegocio.tallerMiNegocio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.minegocio.tallerMiNegocio.entity.Cliente;
import com.minegocio.tallerMiNegocio.repository.ClienteRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Service layer is where all the business logic lies
 */
@Service
@RequiredArgsConstructor
@Slf4j

public class ClienteService {

    private final ClienteRepo clienteRepo;

    public List<Cliente> getAllClientes(){
        return clienteRepo.findAll();
    }

    public Cliente getClienteById(Integer id){
        Optional<Cliente> optionalCliente = clienteRepo.findById(id);
        if(optionalCliente.isPresent()){
            return optionalCliente.get();
        }
        log.info("Cliente con ID: {} no existe", id);
        return null;
    }

    public Cliente saveCliente (Cliente cliente){
        Cliente savedCliente = clienteRepo.save(cliente);
        log.info("Cliente con ID: {} guardado satisfactoriamente", cliente.getId());
        return savedCliente;
    }

    public Cliente updateCliente (Cliente cliente){        
        Optional<Cliente> existingCliente = clienteRepo.findById(cliente.getId());
        if(existingCliente.isPresent()){
            Cliente updatedCliente = clienteRepo.save(cliente);
            log.info("Cliente con ID: {} actualizado correctamente", cliente.getId());
            return updatedCliente;
        }

        log.info("Cliente con ID: {} no existe", cliente.getId());
        return null;
    }

    public void deleteClienteById (Integer id){
        clienteRepo.deleteById(id);
    }
}
