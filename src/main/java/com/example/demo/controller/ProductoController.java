package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Producto;
import com.example.demo.service.IProductoService;

@Controller
@RequestMapping("/productos") 
public class ProductoController {

	@Autowired
	private IProductoService iProductoService;
	
	@GetMapping("/ingresarProducto") // URL:   http://localhost:8085/productos/ingresarProducto
	public String ingresarProducto(Model model, Producto producto) {
		model.addAttribute("producto", producto);
		return "vistaIngresoProducto";
	}
	
	@PostMapping("/guardarProducto")
	public String guardarProducto(Model model, Producto producto) {
		this.iProductoService.ingresar(producto);
		return "redirect:/productos/ingresarProducto";
	}
	
}
