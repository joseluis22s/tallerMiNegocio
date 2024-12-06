package com.minegocio.tallerMiNegocio.service;

import java.util.List;

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
     * Funcionalidad: Obtener un cliente en base a su número de identificación.
     * Recupera un cliente de la tabla "CLIENTE", con el NUMERO DE IDETIFICACIÓN proporcionado.
     * @return Cliente | null (Al no existir un registro)
     */
    public Cliente getClienteByNumeroIdentificacion(String numeroIdentificacion){
        List<Cliente> existingClienteList = clienteRepo.findByNumeroIdentificacion(numeroIdentificacion);
        if(existingClienteList.isEmpty()){
            log.info("Cliente con número de identificación: {} no existe.", numeroIdentificacion);
            // TODO: Revisar para que retorno algo diferente a "null".
            return null; 
        }
        Cliente existingCliente = existingClienteList.getFirst();
        return existingCliente; 
    }

    /*
     * Funcionalidad: Obtener un listado de clientes en base a un nombre.
     * Recupera una lista de clientes de la tabla "CLIENTE", con un nombre proporcionado proporcionado.
     * @return List<Cliente> | null (Al no existir registros)
     */
    public List<Cliente> getClienteByNombres(String nombres){
        List<Cliente> existingClienteList = clienteRepo.findByNombres(nombres);
        if(existingClienteList.isEmpty()){
            log.info("Clientes con nombre: {} no existe.", nombres);
            // TODO: Revisar para que retorno algo diferente a "null".
            return null;
        }
        return existingClienteList; 
    }

    /*
     * Funcionalidad: Crear un nuevo cliente con la dirección matriz.
     *                En caso de recibir "false" en la propiedad "esMatriz", aqui se convierte en "true", para
     *                definir que el nuevo cliente se guarda obligatoriamente con una dirección matriz.
     * Guarda un nuevo cliente en la tabla "CLIENTE". ID autoincremental.
     * Guarda una dirección cliente en la tabla "DIRECCION_CLIENTE" como su dirección matriz. ID autoincremental.
     * @return Cliente (guardado) | null (Al existir un cliente)
     */
    public Cliente saveNuevoClienteConDireccionMatriz (ClienteDireccionMatrizModelReq clienteDireccionMatrizModelReq){
        Cliente cliente = clienteDireccionMatrizModelReq.getCliente();
        List<Cliente> existingClienteList = clienteRepo.findByNumeroIdentificacion(cliente.getNumeroIdentificacion());

        if(!existingClienteList.isEmpty()){
            log.info("Cliente '{}' con ID: {} y {}: {} ya existe.",cliente.getNombres(), 
                                                                cliente.getId(), 
                                                                cliente.getTipoIdentificacion(), 
                                                                cliente.getNumeroIdentificacion());
            // TOD0: Revisar para no devolver null.
            return null;
        }
        DireccionCliente nuevaDireccionCliente = clienteDireccionMatrizModelReq.getDireccionCliente();

        boolean esMatriz = nuevaDireccionCliente.getEsMatriz();
        esMatriz = esMatriz ? esMatriz : true;
        nuevaDireccionCliente.setEsMatriz(esMatriz);
        nuevaDireccionCliente.setCliente(cliente);

        Cliente savedCliente = clienteRepo.save(cliente);
        direccionClienteRepo.save(nuevaDireccionCliente);

        log.info("Cliente '{}' con ID: {} y {}: {} y su direccion guardado satisfactoriamente.",
                    cliente.getNombres(), 
                    cliente.getId(),
                    cliente.getTipoIdentificacion(),
                    cliente.getNumeroIdentificacion());
        return savedCliente ;
    }

    /*
     * Funcionalidad: Editar los datos del cliente en función del número de identificación.
     * Actualiza un cliente en la tabla "CLIENTE".
     * @return Cliente (actualizado) | null (si no existe el registro en base al número de identificación)
     */
    public Cliente updateCliente (Cliente cliente){     

        List<Cliente> existingClienteList = clienteRepo.findByNumeroIdentificacion(cliente.getNumeroIdentificacion());
        if(!existingClienteList.isEmpty()){
            Cliente updtatedCliente = existingClienteList.getFirst();
            clienteRepo.save(updtatedCliente);
            log.info("Cliente con NÚMERO DE IDENTIFICACIÓN: {} actualizado correctamente.", cliente.getNumeroIdentificacion());
            return updtatedCliente;
        }
        log.info("Cliente con NÚMERO DE IDENTIFICACIÓN: {} no existe.", cliente.getNumeroIdentificacion());
        // TOD0: Revisar para no devolver null.
        return null;
    }

    /*
     * Funcionalidad: Eliminar un cliente en base a su número de identificación.
     * Elimina un cliente en la tabla "CLIENTE".
     */
    public void deleteClienteByNumeroIdentificacion (String numeroIdentificacion){
        List<Cliente> existingClienteList = clienteRepo.findByNumeroIdentificacion(numeroIdentificacion);
        if(!existingClienteList.isEmpty()){
            Cliente cliente = existingClienteList.getFirst();
            clienteRepo.deleteById(cliente.getId());
            log.info("Cliente '{}' con NÚMERO DE IDENTIFICACIÓN: {} ha sido eliminado.",cliente.getNombres(),  
                                                                cliente.getNumeroIdentificacion());
        }
    }
}
