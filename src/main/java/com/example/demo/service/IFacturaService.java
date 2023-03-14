package com.example.demo.service;

import java.util.List;

import com.example.demo.modelo.Factura;
import com.example.demo.modelo.dto.ProductoDTO;

public interface IFacturaService {

	public void realizarFactura(Factura factura);
	public void realizarFacturaLista(List<ProductoDTO> listaDto, String cedula, String numeroVenta);
	
}
