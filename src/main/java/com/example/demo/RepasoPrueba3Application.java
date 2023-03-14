package com.example.demo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modelo.Producto;
import com.example.demo.modelo.dto.ProductoDTO;
import com.example.demo.service.IFacturaService;
import com.example.demo.service.IProductoService;

@SpringBootApplication
public class RepasoPrueba3Application implements CommandLineRunner {

	@Autowired
	private IProductoService iProductoService;
	
	@Autowired
	private IFacturaService iFacturaService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(RepasoPrueba3Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		System.out.println("lol");
		
		
		// ************************** Ingreso Productos ********************************
//		Producto miProducto = new Producto();
//		miProducto.setCodigo("753");
//		miProducto.setNombre("linterna");
//		miProducto.setPrecio(new BigDecimal(15.05));
//		miProducto.setTipo("Herramienta");
//		miProducto.setStock(new BigDecimal(1002));
//		
//		this.iProductoService.ingresar(miProducto);
		
		
		//*********************** Realizar una Venta (factura) **************************
//		List<ProductoDTO> listaDto = new ArrayList<>();
//
//		ProductoDTO prodDto = this.iProductoService.buscarDto("753");
//		prodDto.setCantidad(new BigDecimal(300));
//		System.out.println(prodDto);
//		listaDto.add(prodDto);
//
//		ProductoDTO prodDto2 = this.iProductoService.buscarDto("369");
//		prodDto2.setCantidad(new BigDecimal(1));
//		System.out.println(prodDto2);
//		listaDto.add(prodDto2);
//		
//		this.iFacturaService.realizarFacturaLista(listaDto, "1723522403", "num");
		
		// **************************** Busqueda de Stock ********************************
//		BigDecimal stockCriteria = this.iProductoService.buscarPorCodigoCriteria("123");
//		System.out.println(stockCriteria);
	}

}
