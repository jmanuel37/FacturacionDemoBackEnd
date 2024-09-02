package com.orden.compras.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orden.compras.modelo.OrdenCompra;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompra, String>  {

}
