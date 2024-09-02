package com.orden.compras.servicio;


import java.util.List;
import java.util.Optional;

import com.orden.compras.modelo.Cliente;

public interface ClienteServicio {
	
    List<Cliente> listar();
    Optional<Cliente> porId(Long id);
    Cliente guardar(Cliente cliente);
    void eliminar(Long id);

}
