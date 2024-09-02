package com.orden.compras.modelo;

import java.io.Serializable;
 import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import jakarta.persistence.*;

@Entity
@Table(name="ordenCompra")

public class OrdenCompra implements Serializable {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.IDENTITY)
   // @Basic(optional = false)
    @Column(name="idOrdCompra")
    private String idOrdCompra;
	
	@Column(name="idCliente")
    private int idCliente;
 
    @Column(name="nombreCliene")
    private String nombrecliente;
    
    @Column(name="descripcion_orden_comp")
    private String descripcion_orden;
 
    @Column(name = "fechaOrdComp")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fecha;
    
   

	@Column(name = "total")
	private BigDecimal Total;
 
    @OneToMany(cascade= CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="IdCompra")
    private List<OrdenCompraDetalle> ordenCompraDetalle;
 
 
    public OrdenCompra(){ 
    	
    	ordenCompraDetalle=new ArrayList<OrdenCompraDetalle>();
    }


	public OrdenCompra(String idOrdCompra, int idCliente, String nombrecliente, String descripcion_orden,Date fecha,BigDecimal total) {
		super();
		this.idOrdCompra = idOrdCompra;
		this.idCliente = idCliente;
		this.nombrecliente = nombrecliente;
		this.descripcion_orden=descripcion_orden;
		this.fecha = fecha;
		Total = total;
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


	public List<OrdenCompraDetalle> getOrdenCompraDetalle() {
		return ordenCompraDetalle;
	}


	public void setOrdenCompraDetalle(List<OrdenCompraDetalle> ordenCompraDetalle) {
		this.ordenCompraDetalle = ordenCompraDetalle;
	}
    
	
    

}
