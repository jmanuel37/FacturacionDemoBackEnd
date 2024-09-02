package com.orden.compras.servicio;

import java.util.List;
import java.util.Optional;

import com.orden.compras.modelo.OrdenCompra;

public interface OrdenCompraService {
	
	 List<OrdenCompra> listar();

	    Optional<OrdenCompra> porId(String id);
	   
	    OrdenCompra guardar(OrdenCompra cliente);
	    
	    void eliminar(String id);

}
