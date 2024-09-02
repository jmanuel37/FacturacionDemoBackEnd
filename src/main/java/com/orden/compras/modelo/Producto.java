package com.orden.compras.modelo;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name = "producto")
public class Producto  implements Serializable {
	
	@Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_producto")
    private Integer idProducto;
    @Basic(optional = false)
    
    @Column(name = "nombre_prod")
	private String nombreProd;
    
    @Column(name = "precio_prod")
	private BigDecimal precioProd;
    
    @Column(name = "uni_medida_prod")
	private String uniMedidaProd;
    
    @Column(name = "descripcion_prod")
   	private String descripcionProd;

	public Producto(Integer idProducto, String nombreProd, BigDecimal precioProd, String uniMedidaProd,
			String descripcionProd) {
		super();
		this.idProducto = idProducto;
		this.nombreProd = nombreProd;
		this.precioProd = precioProd;
		this.uniMedidaProd = uniMedidaProd;
		this.descripcionProd = descripcionProd;
	}

	public Producto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Integer getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProd() {
		return nombreProd;
	}

	public void setNombreProd(String nombreProd) {
		this.nombreProd = nombreProd;
	}

	public BigDecimal getPrecioProd() {
		return precioProd;
	}

	public void setPrecioProd(BigDecimal precioProd) {
		this.precioProd = precioProd;
	}

	public String getUniMedidaProd() {
		return uniMedidaProd;
	}

	public void setUniMedidaProd(String uniMedidaProd) {
		this.uniMedidaProd = uniMedidaProd;
	}

	public String getDescripcionProd() {
		return descripcionProd;
	}

	public void setDescripcionProd(String descripcionProd) {
		this.descripcionProd = descripcionProd;
	}

}
