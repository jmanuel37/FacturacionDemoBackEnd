package com.orden.compras.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import jakarta.persistence.*;

@Entity
@Table(name = "OrdenCompraDetalle")

public class OrdenCompraDetalle implements Serializable {
	
	@Id
    @Column(name="idDetalle")    
    private String idDetalle;
 
    @ManyToOne
    @JoinColumn(name="IdCompra")
    private OrdenCompra ordenCompra;
    
    @Column(name="cantidad")
    private int cantidad;
    
    @Column(name="idProducto")
    private int idProducto;
    
    @Column(name="nombreProducto")
    private String nombreProducto;
    
    @Column(name="precioProducto")
    private BigDecimal precioProducto;
    
    

	public OrdenCompraDetalle() {
		super();
	}



	public OrdenCompraDetalle(String idDetalle, OrdenCompra ordenCompra,int cantidad, int idProducto, String nombreProducto,
			BigDecimal precioProducto) {
		super();
		this.idDetalle = idDetalle;
		this.ordenCompra = ordenCompra;
		this.cantidad=cantidad;
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precioProducto = precioProducto;
	}



	public String getIdDetalle() {
		return idDetalle;
	}



	public void setIdDetalle(String idDetalle) {
		this.idDetalle = idDetalle;
	}



	public OrdenCompra getOrdenCompra() {
		return ordenCompra;
	}



	public void setOrdenCompra(OrdenCompra ordenCompra) {
		this.ordenCompra = ordenCompra;
	}



	public int getIdProducto() {
		return idProducto;
	}



	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}



	public String getNombreProducto() {
		return nombreProducto;
	}



	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}



	public BigDecimal getPrecioProducto() {
		return precioProducto;
	}



	public void setPrecioProducto(BigDecimal precioProducto) {
		this.precioProducto = precioProducto;
	}



	public int getCantidad() {
		return cantidad;
	}



	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	
	
    
    
 

}
