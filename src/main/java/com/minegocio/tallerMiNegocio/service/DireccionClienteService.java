package com.minegocio.tallerMiNegocio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.minegocio.tallerMiNegocio.entity.Cliente;
import com.minegocio.tallerMiNegocio.entity.DireccionCliente;
import com.minegocio.tallerMiNegocio.repository.ClienteRepo;
import com.minegocio.tallerMiNegocio.repository.DireccionClienteRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service                                    // Define que es una clase de servicio para agrupar repositorios
@RequiredArgsConstructor                    // Contructor para manejar dependencias
@Slf4j                                      // Registra mensaje (logs)
public class DireccionClienteService {

    private final DireccionClienteRepo direccionClienteRepo;
    private final ClienteRepo clienteRepo;

    /*
     * Recupera todas las direcciones de clientes de la tabla "DIRECCION_CLIENTE".
     * @return List<DireccionCliente>
     */
    public List<DireccionCliente> getAllDireccionesCliente(){
        return direccionClienteRepo.findAll();
    }

    /*
     * Recupera una dirección de un cliente de la tabla "DIRECCION_CLIENTE", con el ID proporcionado.
     * @return DireccionCliente
     */
    public DireccionCliente getDireccionClienteById(Integer id){
        Optional<DireccionCliente> optionalDireccionCliente = direccionClienteRepo.findById(id);
        if(optionalDireccionCliente.isPresent()){
            return optionalDireccionCliente.get();
        }
        log.info("Dirección con ID: {} no existe", id);
        return null;
    }

    /*
     * Guarda una dirección de un cliente en la tabla "DIRECCION_CLIENTE". ID autoincremental.
     * @return DireccionCliente (guardado)v 
     */
    public DireccionCliente saveDireccionClienteByIdCliente (DireccionCliente direccionCliente, Integer idCliente){
        Optional<Cliente> optionalCliente = clienteRepo.findById(idCliente);
        if(!optionalCliente.isPresent()){
            log.info("Cliente con ID: {} no existe", idCliente);
            return null; // TODO: VER COMO MANDAR UN STATUS DE VALOR NO ENCONTRADO
        }
        direccionCliente.setCliente(optionalCliente.get());
        DireccionCliente savedDireccionCliente = direccionClienteRepo.save(direccionCliente);
        log.info("Dirección con ID: {} guardado satisfactoriamente", direccionCliente.getId());
        return savedDireccionCliente;
    }

    // public DireccionCliente saveDireccionClienteByIdCliente (DireccionCliente direccionCliente, Integer idCliente){
    //     Optional<Cliente> optionalCliente = clienteRepo.findById(idCliente);
    //     if(optionalCliente.isPresent()){
    //         log.info("Cliente con ID: {} no existe", idCliente);
    //         return null;
    //     }
    //     DireccionCliente savedDireccionCliente = direccionClienteRepo.save(direccionCliente);
    //     log.info("Dirección con ID: {} guardado satisfactoriamente", direccionCliente.getId());
    //     return savedDireccionCliente;
    // }

    /*
     * Actualiza una direccion de un cliente en la tabla "DIRECCION_CLIENTE".
     * @return DireccionCliente (actualizado) | null(si no existe el registro)
     */
    public DireccionCliente updateDireccionCliente (DireccionCliente direccionCliente){        
        Optional<DireccionCliente> existingDireccionCliente = direccionClienteRepo.findById(direccionCliente.getId());
        if(existingDireccionCliente.isPresent()){
            DireccionCliente updatedDireccionCliente = direccionClienteRepo.save(direccionCliente);
            log.info("Dirección  con ID: {} actualizado correctamente", direccionCliente.getId());
            return updatedDireccionCliente;
        }
        log.info("Dirección con ID: {} no existe", direccionCliente.getId());
        return null;
    }

    /*
     * Elimina una direccion de un cliente en la tabla "DIRECCION_CLIENTE".
     */
    public void deleteDireccionClienteById (Integer id){
        direccionClienteRepo.deleteById(id);
    }
}
