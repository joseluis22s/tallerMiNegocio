package com.minegocio.tallerMiNegocio.modelRequest;

import com.minegocio.tallerMiNegocio.entity.Cliente;
import com.minegocio.tallerMiNegocio.entity.DireccionCliente;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClienteDireccionMatrizModelReq {
    
    private Cliente cliente;
    private DireccionCliente direccionCliente;
}
