package com.orden.compras.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.orden.compras.modelo.OrdenCompra;
import com.orden.compras.repositorio.OrdenCompraRepository;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {
	
	@Autowired
	OrdenCompraRepository repository;
	
	 @Override
	    @Transactional(readOnly=true)
	    public List<OrdenCompra> listar() {
	        return (List<OrdenCompra>) repository.findAll();
	    }
	 

	    @Override
	    @Transactional(readOnly = true)
	    public Optional<OrdenCompra> porId(String id) {
	        return repository.findById(id);
	    }
	    @Override
	    @Transactional
	    public OrdenCompra guardar(OrdenCompra ordenCompra) {
	        return repository.save(ordenCompra);
	    }
	    @Override
	    @Transactional
	    public void eliminar(String id) {
	        repository.deleteById(id);
	    }


}
