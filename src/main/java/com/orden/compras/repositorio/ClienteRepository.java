package com.orden.compras.repositorio;


import org.springframework.data.jpa.repository.JpaRepository;

import com.orden.compras.modelo.Cliente;
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
