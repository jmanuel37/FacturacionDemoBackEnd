package com.orden.compras.modelo;

import jakarta.persistence.*;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_cliente")
    private Long idCliente;
    @Basic(optional = false)

    @Column(name = "nombre_cliente")
    private String nombreCliente;

    @Column(name = "descripcion_cliente")
    private String descripcionCliente;

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDescripcionCliente() {
        return descripcionCliente;
    }

    public void setDescripcionCliente(String descripcionCliente) {
        this.descripcionCliente = descripcionCliente;
    }

    public Cliente() {
    }

    public Cliente(Long idCliente, String nombreCliente, String descripcionCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.descripcionCliente = descripcionCliente;
    }
}
