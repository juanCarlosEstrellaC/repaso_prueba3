package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.modelo.Producto;
import com.example.demo.modelo.dto.ProductoDTO;

public interface IProductoService {
	
	public void ingresar(Producto producto);
	public Producto buscarPorCodigo(String codigo);
	public Producto buscarPorCodigoTryCatch(String codigo);
	public int actualizarStock(String codigo, BigDecimal nuevoSock);
	public List<Producto> buscarTodos();
	public ProductoDTO buscarDto(String codigo);
	public BigDecimal buscarPorCodigoCriteria(String codigo);

}
