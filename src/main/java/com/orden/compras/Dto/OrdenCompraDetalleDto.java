package com.orden.compras.Dto;

import java.math.BigDecimal;

import com.orden.compras.modelo.OrdenCompra;

public class OrdenCompraDetalleDto {
	
	 private String idDetalle;
	 private String idOrdenCompra;
	 private int cantidad;
	 private int idProducto;
	 private String nombreProducto;
	 private BigDecimal precioProducto;
	 
	 
	public OrdenCompraDetalleDto() {
	
	}
	public OrdenCompraDetalleDto(String idDetalle, String idOrdenCompra,int cantidad, int idProducto, String nombreProducto,
			BigDecimal precioProducto) {
		super();
		this.idDetalle = idDetalle;
		this.idOrdenCompra = idOrdenCompra;
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
	public String getIdOrdenCompra() {
		return idOrdenCompra;
	}
	public void setIdOrdenCompra(String idOrdenCompra) {
		this.idOrdenCompra = idOrdenCompra;
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
