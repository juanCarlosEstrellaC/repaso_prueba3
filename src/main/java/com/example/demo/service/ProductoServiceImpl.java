package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Producto;
import com.example.demo.modelo.dto.ProductoDTO;
import com.example.demo.repository.IProductoRepository;

@Service
public class ProductoServiceImpl implements IProductoService{

	@Autowired
	private IProductoRepository iProductoRepository;
	
	@Override
	public void ingresar(Producto producto) {
		Producto productoBuscado = buscarPorCodigoTryCatch(producto.getCodigo());
		
		if (productoBuscado == null) {
			this.iProductoRepository.ingresar(producto);
		} else {
			this.iProductoRepository.actualizarStock(productoBuscado.getCodigo(), productoBuscado.getStock().add(producto.getStock()));
		}
		
	}

	@Override
	public Producto buscarPorCodigo(String codigo) {
		return this.iProductoRepository.buscarPorCodigo(codigo);
	}

	@Override
	public Producto buscarPorCodigoTryCatch(String codigo) {
		return this.iProductoRepository.buscarPorCodigoTryCatch(codigo);
	}

	@Override
	public List<Producto> buscarTodos() {
		return this.iProductoRepository.buscarTodos();
	}

	@Override
	public ProductoDTO buscarDto(String codigo) {
		return this.iProductoRepository.buscarDto(codigo);
	}

	@Override
	public int actualizarStock(String codigo, BigDecimal nuevoSock) {
		return this.iProductoRepository.actualizarStock(codigo, nuevoSock);
	}

	@Override
	public BigDecimal buscarPorCodigoCriteria(String codigo) {
		return this.iProductoRepository.buscarPorCodigoCriteria(codigo).getStock();
	}
	
}
