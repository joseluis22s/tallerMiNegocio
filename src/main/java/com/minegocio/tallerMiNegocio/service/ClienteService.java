package com.minegocio.tallerMiNegocio.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.minegocio.tallerMiNegocio.entity.Cliente;
import com.minegocio.tallerMiNegocio.entity.DireccionCliente;
import com.minegocio.tallerMiNegocio.modelRequest.ClienteDireccionMatrizModelReq;
import com.minegocio.tallerMiNegocio.repository.ClienteRepo;
import com.minegocio.tallerMiNegocio.repository.DireccionClienteRepo;

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
    private final DireccionClienteRepo direccionClienteRepo;
    
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
    /////TODO: Reviar aqui
    public Cliente getClienteByNumeroIdentificacion(String numeroIdentificacion){
        List<Cliente> existingClienteList = clienteRepo.findByNumeroIdentificacion(numeroIdentificacion);
        if(existingClienteList.isEmpty()){
            log.info("Cliente con número de identificación: {} no existe", numeroIdentificacion);
            return null; // TODO: vER COMO HACER PARA QUE NO SEA NULL
        }
        Cliente existingCliente = existingClienteList.getFirst();
        return existingCliente; 
    }
    /*
     * Recupera un cliente de la tabla "CLIENTE", con el ID proporcionado.
     * @return Cliente | null
     */
    /////TODO: Reviar aqui
    public List<Cliente> getClienteByNombres(String nombres){
        List<Cliente> existingClienteList = clienteRepo.findByNombres(nombres);
        if(existingClienteList.isEmpty()){
            log.info("Clientes con nombre: {} no existe", nombres);
            return null; // TODO: vER COMO HACER PARA QUE NO SEA NULL
        }
        return existingClienteList; 
    }
    // /*
    //  * Recupera un cliente de la tabla "CLIENTE", con el ID proporcionado.
    //  * @return Cliente | null
    //  */
    // public Cliente getClienteById(Integer id){
    //     Optional<Cliente> optionalCliente = clienteRepo.findById(id);
    //     if(optionalCliente.isPresent()){
    //         log.info("Cliente con ID: {} no existe", optionalCliente.get());
    //         return optionalCliente.get();
    //     }
    //     log.info("Cliente con ID: {} no existe", id);
    //     return null; //TODO: No retornar null
    // }

    /*
     * Guarda un cliente en la tabla "CLIENTE". ID autoincremental.
     * @return Cliente (guardado)
     */
    public Cliente saveNuevoClienteConDireccionMatriz (ClienteDireccionMatrizModelReq clienteDireccionMatrizModelReq){
        Cliente cliente = clienteDireccionMatrizModelReq.getCliente();
        List<Cliente> existingClienteList = clienteRepo.findByNumeroIdentificacion(cliente.getNumeroIdentificacion());

        if(!existingClienteList.isEmpty()){
            // TODO: Veficar si esta bien lo de las llaves
            log.info("Cliente '{}' con ID: {} y {}: {} ya existe.",cliente.getNombres(), 
                                                                cliente.getId(), 
                                                                cliente.getTipoIdentificacion(), 
                                                                cliente.getNumeroIdentificacion());
            return null; // TOD0: REvisar para no devolver null, mas bien un esatdfo http
        }
        DireccionCliente nuevaDireccionCliente = clienteDireccionMatrizModelReq.getDireccionCliente();
        nuevaDireccionCliente.setCliente(cliente);
        Cliente savedCliente = clienteRepo.save(cliente);
        
        direccionClienteRepo.save(nuevaDireccionCliente);
        log.info("Cliente '{}' con ID: {} y {}: {} y su direccion guardado satisfactoriamente", cliente.getNombres(), 
                                                                                    cliente.getId(),
                                                                                    cliente.getTipoIdentificacion(),
                                                                                    cliente.getNumeroIdentificacion());
        return savedCliente ;
    }

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
