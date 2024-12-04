package com.minegocio.tallerMiNegocio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.minegocio.tallerMiNegocio.entity.Cliente;
import com.minegocio.tallerMiNegocio.repository.ClienteRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * Clase de servicio. Contiene lógica la de negocio sobre la entidad Cliente. 
 * Controlador accede a ella para efectuar un proceso solicitado por un usuario.
 */
@Service                                    // Define que es una clase de servicio para agrupar repositorios
@RequiredArgsConstructor                    // Contructor para manejar dependencias
@Slf4j                                      // Registra mensaje (logs)

public class ClienteService {

    private final ClienteRepo clienteRepo;
    
    /*
     * Recupera todos los clientes de la tabla "CLIENTE".
     * @return List<Cliente>
     */
    public List<Cliente> getAllClientes(){

        return clienteRepo.findAll(); 
    }

    /*
     * Recupera un cliente de la tabla "CLIENTE", con el ID proporcionado.
     * @return Cliente | null
     */
    public Cliente getClienteById(Integer id){
        Optional<Cliente> optionalCliente = clienteRepo.findById(id);
        if(optionalCliente.isPresent()){
            return optionalCliente.get();
        }
        log.info("Cliente con ID: {} no existe", id);
        return null; //TODO: No retornar null
    }

    /*
     * Guarda un cliente en la tabla "CLIENTE". ID autoincremental.
     * @return Cliente (guardado)
     */
    public Cliente saveClienteConDireccionMatriz (Cliente cliente){
        log.info("Cliente con ID: {} guardado satisfactoriamente", cliente.getId());
        return clienteRepo.save(cliente);
    }

    // /*
    //  * Guarda un cliente en la tabla "CLIENTE". ID autoincremental.
    //  * @return Cliente (guardado)
    //  */
    // public Cliente saveCliente (Cliente cliente){
    //     log.info("Cliente con ID: {} guardado satisfactoriamente", cliente.getId());
    //     return clienteRepo.save(cliente);
    // }

    /*
     * Actualiza un cliente en la tabla "CLIENTE".
     * @return Cliente (actualizado) | null (si no existe el registro)
     */
    public Cliente updateCliente (Cliente cliente){        
        Optional<Cliente> existingCliente = clienteRepo.findById(cliente.getId());
        if(existingCliente.isPresent()){
            log.info("Cliente con ID: {} actualizado correctamente", cliente.getId());
            return clienteRepo.save(cliente);
        }
        log.info("Cliente con ID: {} no existe", cliente.getId());
        return null; //TODO: Ver como hacer para no retornar null
    }

    /*
     * Elimina un cliente en la tabla "CLIENTE".
     */
    public void deleteClienteById (Integer id){
        clienteRepo.deleteById(id);
    }
}
