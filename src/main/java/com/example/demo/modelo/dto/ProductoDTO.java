package com.example.demo.modelo.dto;

import java.math.BigDecimal;

public class ProductoDTO {

	private String codigo;
	private BigDecimal cantidad;
	
	public ProductoDTO() {}

	public ProductoDTO(String codigo) {
		super();
		this.codigo = codigo;
	}

	@Override
	public String toString() {
		return "ProductoDTO [codigo=" + codigo + ", cantidad=" + cantidad + "]";
	}
	
	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public BigDecimal getCantidad() {
		return cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}
	
	
}
