package com.example.demo.controller;

import java.time.LocalDateTime;
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

	Factura fac = null;
	List<Detalle> det = null;
	List<ProductoDTO> listadto = new ArrayList<>();

	@GetMapping("/visualizarProductos") // URL: http://localhost:8085/facturas/visualizarProductos
	public String visualizarProductos(Model model, Factura factura) {
		List<Producto> listaProductos = this.iProductoService.buscarTodos();
		model.addAttribute("factura", factura);
		model.addAttribute("listaProductos", listaProductos);
		return "vistaVisualizarProductos";
	}

	String cod = null;

	@GetMapping("/preVenta/{id}")
	public String preVenta(@PathVariable("id") String codigo, Model model, ProductoDTO dto) {
		cod = codigo;
		dto.setCodigo(codigo);
		model.addAttribute("dto", dto);
		return "vistaPreVenta";
	}

	@PostMapping("/guardarElemento")
	public String guardarElemento(Model model, ProductoDTO dto) {
		dto.setCodigo(cod);
		listadto.add(dto);
		return "redirect:/facturas/visualizarProductos";
	}

	@PostMapping("/guardarFactura")
	public String guardarElemento(Model model, Factura factura) {
		this.iFacturaService.realizarFacturaLista(listadto, factura.getCedula(), "A102");
		model.addAttribute("factura", factura);

		return "vistaDetalle";
	}

//	@GetMapping("/preVenta/{codigo}")
//	public String preVenta(@PathVariable("codigo") String codigo, Model model, Detalle detalle) {		
//		Producto pro = this.iProductoService.buscarPorCodigo(codigo);
//		detalle.setMiProducto(pro);
//		detalle.setPrecioUnitario(pro.getPrecio());
//		model.addAttribute("detalle", detalle);
//
//		return "vistaPreVenta";
//	}

}
