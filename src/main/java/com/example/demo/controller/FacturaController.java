package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Detalle;
import com.example.demo.modelo.Factura;
import com.example.demo.modelo.Producto;
import com.example.demo.modelo.dto.ProductoDTO;
import com.example.demo.service.IFacturaService;
import com.example.demo.service.IProductoService;

@Controller
@RequestMapping("/facturas")
public class FacturaController {

	@Autowired
	private IFacturaService iFacturaService;

	@Autowired
	private IProductoService iProductoService;

	private String cod = null;
	private List<Detalle> listaDet = null;
	private List<ProductoDTO> listadto = new ArrayList<>();

	@GetMapping("/visualizarProductos") 	// URL: http://localhost:8085/facturas/visualizarProductos
	public String visualizarProductos(Model model, Factura factura) {
//	    cod = null;
//		listaDet = new ArrayList<>();
//		listadto = new ArrayList<>();
		
		List<Producto> listaProductos = this.iProductoService.buscarTodos();
		model.addAttribute("factura", factura);
		model.addAttribute("listaProductos", listaProductos);
		return "vistaFacturaVisualizarProductos";
	}


	@GetMapping("/añadirProducto/{codigo}")
	public String añadirProducto(@PathVariable("codigo") String codigo, Model model, ProductoDTO dto) {
		cod = codigo;
		dto.setCodigo(codigo);
		model.addAttribute("dto", dto);
		return "vistaFacturaAñadirProducto";
	}

	// NO SERÁ SOLO GET?
	@GetMapping("/guardarCantidadProducto")
	public String guardarElemento(Model model, ProductoDTO dto) {
		dto.setCodigo(cod);
		listadto.add(dto);
		return "redirect:/facturas/visualizarProductos";
	}

	@PostMapping("/guardarFactura")
	public String guardarElemento(Model model, Factura factura) {
		Factura facturaTotal = this.iFacturaService.realizarFacturaLista(listadto, factura.getCedula(), "A102");
		listaDet = facturaTotal.getMiListaDetalleFact();
		model.addAttribute("listaDet", listaDet);

		return "vistaDetalle";
	}


}
