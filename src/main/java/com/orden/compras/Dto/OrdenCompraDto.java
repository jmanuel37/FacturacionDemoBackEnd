package com.orden.compras.Dto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.orden.compras.modelo.OrdenCompraDetalle;

public class OrdenCompraDto {
	private String idOrdCompra;

	private int idCliente;

	private String nombrecliente;

	private Date fecha;
	
	private String descripcion_orden;

	private BigDecimal Total;

	private List<OrdenCompraDetalleDto> ordenCompraDetalle;

	public OrdenCompraDto() {

		ordenCompraDetalle = new ArrayList<OrdenCompraDetalleDto>();
	}

	public String getIdOrdCompra() {
		return idOrdCompra;
	}

	public void setIdOrdCompra(String idOrdCompra) {
		this.idOrdCompra = idOrdCompra;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}




	public String getNombrecliente() {
		return nombrecliente;
	}

	public void setNombrecliente(String nombrecliente) {
		this.nombrecliente = nombrecliente;
	}
	
	

	public String getDescripcion_orden() {
		return descripcion_orden;
	}

	public void setDescripcion_orden(String descripcion_orden) {
		this.descripcion_orden = descripcion_orden;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getTotal() {
		return Total;
	}

	public void setTotal(BigDecimal total) {
		Total = total;
	}
	
	

	public List<OrdenCompraDetalleDto> getOrdenCompraDetalle() {
		return ordenCompraDetalle;
	}

	public void setOrdenCompraDetalle(List<OrdenCompraDetalleDto> ordenCompraDetalle) {
		this.ordenCompraDetalle = ordenCompraDetalle;
	}

}
