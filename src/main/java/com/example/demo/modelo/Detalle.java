package com.example.demo.modelo;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "detalle")
public class Detalle {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "deta_seq")
	@SequenceGenerator(name = "deta_seq", sequenceName = "deta_seq", allocationSize = 1)
	@Column(name = "deta_id")
	private Integer id;
	@Column(name = "deta_cantidad")
	private BigDecimal cantidad;
	@Column(name = "deta_precio_unit")
	private BigDecimal precioUnitario;
	@Column(name = "deta_subtotal")
	private BigDecimal subtotal;

	// RELACIONES
	@ManyToOne
	@JoinColumn(name = "deta_id_producto")
	private Producto miProducto;

	@ManyToOne
	@JoinColumn(name = "deta_id_factura")
	private Factura miFactura;

	// TOSTRING:
	@Override
	public String toString() {
		return "Detalle [id=" + id + ", cantidad=" + cantidad + ", precioUnitario=" + precioUnitario + ", subtotal="
				+ subtotal + ", miProducto=" + miProducto + ", miFactura=" + miFactura + "]";
	}

	// GET Y SET:
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getPrecioUnitario() {
		return precioUnitario;
	}

	public void setPrecioUnitario(BigDecimal precioUnitario) {
		this.precioUnitario = precioUnitario;
	}

	public BigDecimal getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Producto getMiProducto() {
		return miProducto;
	}

	public void setMiProducto(Producto miProducto) {
		this.miProducto = miProducto;
	}

	public Factura getMiFactura() {
		return miFactura;
	}

	public void setMiFactura(Factura miFactura) {
		this.miFactura = miFactura;
	}

}
