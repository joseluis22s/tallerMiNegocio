package com.minegocio.tallerMiNegocio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.minegocio.tallerMiNegocio.entity.Cliente;
import com.minegocio.tallerMiNegocio.repository.ClienteRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase de servicio. Contiene lógica la de negocio sobre la entidad cliente. 
 * Controlador accede a ella para efectuar un proceso solicitado por un usuario.
 */
@Service                                    // Define que es una clase de servicio para agrupar repositorios
@RequiredArgsConstructor                    // Contructor para manejar dependencias
@Slf4j                                      // Registra mensaje (logs)

public class ClienteService {

    private final ClienteRepo clienteRepo;
    
    /*
     * Recupera todos los clientes de la tabla "CLIENTES".
     * @return List<Cliente>
     */
    public List<Cliente> getAllClientes(){
        return clienteRepo.findAll();
    }

    /*
     * Recupera un cliente de la tabla "CLIENTES", con el ID proporcionado.
     * @return Cliente
     */
    public Cliente getClienteById(Integer id){
        Optional<Cliente> optionalCliente = clienteRepo.findById(id);
        if(optionalCliente.isPresent()){
            return optionalCliente.get();
        }
        log.info("Cliente con ID: {} no existe", id);
        return null;
    }

    /*
     * Guarda un cliente en la tabla "CLIENTES". ID autoincremental.
     * @return Cliente (guardado)
     */
    public Cliente saveCliente (Cliente cliente){
        Cliente savedCliente = clienteRepo.save(cliente);
        log.info("Cliente con ID: {} guardado satisfactoriamente", cliente.getId());
        return savedCliente;
    }

    /*
     * Actualiza un cliente en la tabla "CLIENTES".
     * @return Cliente (actualizado) | null(si no existe el registro)
     */
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

    /*
     * Elimina un cliente en la tabla "CLIENTES".
     */
    public void deleteClienteById (Integer id){
        clienteRepo.deleteById(id);
    }
}
