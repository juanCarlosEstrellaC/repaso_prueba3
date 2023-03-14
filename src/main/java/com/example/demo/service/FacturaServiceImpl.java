package com.example.demo.service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.modelo.Detalle;
import com.example.demo.modelo.Factura;
import com.example.demo.modelo.Producto;
import com.example.demo.modelo.dto.ProductoDTO;
import com.example.demo.repository.IFacturaRepository;

@Service
public class FacturaServiceImpl implements IFacturaService {

	@Autowired
	private IFacturaRepository iFacturaRepository;

	@Autowired
	private IProductoService iProductoService;

	@Override
	public void realizarFactura(Factura factura) {
		System.out.println("Sin implementación.");
	}

	@Override
	public Factura realizarFacturaLista(List<ProductoDTO> listaDto, String cedula, String numeroVenta) {

		Producto pro = null;
		Factura fac = new Factura();
		List<Detalle> listaDetalles = new ArrayList<>();
		BigDecimal total = new BigDecimal(0);
		
		for (ProductoDTO productoDTO : listaDto) {
			pro = this.iProductoService.buscarPorCodigo(productoDTO.getCodigo());
			
			if (pro.getStock().equals(new BigDecimal(0))) {
				System.out.println("No existe stock disponible del producto " + pro.getNombre());
				
			} else {
				
				Detalle det = new Detalle();
				det.setMiProducto(pro);
				det.setMiFactura(fac);
				det.setPrecioUnitario(pro.getPrecio());
				
				if (productoDTO.getCantidad().compareTo(pro.getStock()) == 1) {
					System.out.println("Se venderá todo el stock disponible del producto " + pro.getNombre());
					this.iProductoService.actualizarStock(productoDTO.getCodigo(), new BigDecimal(0));
					det.setCantidad(pro.getStock());
					det.setSubtotal(pro.getPrecio().multiply(pro.getStock()));

				} else {
					this.iProductoService.actualizarStock(productoDTO.getCodigo(),
							pro.getStock().subtract(productoDTO.getCantidad()));
					det.setCantidad(productoDTO.getCantidad());
					det.setSubtotal(pro.getPrecio().multiply(productoDTO.getCantidad()));
				}
				listaDetalles.add(det);
				total = total.add(det.getSubtotal());
			}

		}

		fac.setCedula(cedula);
		fac.setFecha(LocalDateTime.now());
		fac.setNumero(numeroVenta);
		fac.setMiListaDetalleFact(listaDetalles);
		fac.setTotal(total);
		
		this.iFacturaRepository.realizarFactura(fac);
		return fac;
		
	}

}
