package com.example.demo.modelo;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "producto")
@NamedNativeQuery(name = "Producto.buscarPorCodigo", query = "SELECT  *  FROM  producto  WHERE prod_codigo=:datoCod", resultClass = Producto.class)
@NamedQuery(name = "Productos.buscarTodos", query = "SELECT p FROM Producto p")
public class Producto {

	// 36 a 58
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prod_seq")
	@SequenceGenerator(name = "prod_seq", sequenceName = "prod_seq", allocationSize = 1)
	@Column(name = "prod_id")
	private Integer id;
	@Column(name = "prod_codigo")
	private String codigo;
	@Column(name = "prod_nombre")
	private String nombre;
	@Column(name = "prod_tipo")
	private String tipo;
	@Column(name = "prod_stock")
	private BigDecimal stock;
	@Column(name = "prod_precio")
	private BigDecimal precio;

	// RELACIONES:
	@OneToMany(mappedBy = "miProducto")
	private List<Detalle> miListaDetalleProd;

	// TOSTRING:
	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", nombre=" + nombre + ", tipo=" + tipo + ", stock="
				+ stock + ", precio=" + precio + "]";
	}

	// GET Y SET:
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getStock() {
		return stock;
	}

	public void setStock(BigDecimal stock) {
		this.stock = stock;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public List<Detalle> getMiListaDetalleProd() {
		return miListaDetalleProd;
	}

	public void setMiListaDetalleProd(List<Detalle> miListaDetalleProd) {
		this.miListaDetalleProd = miListaDetalleProd;
	}

}
