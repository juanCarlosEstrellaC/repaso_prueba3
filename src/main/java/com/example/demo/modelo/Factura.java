package com.example.demo.modelo;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "factura")
public class Factura {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fact_seq")
	@SequenceGenerator(name = "fact_seq", sequenceName = "fact_seq", allocationSize = 1)
	@Column(name = "fact_id")
	private Integer id;
	@Column(name = "fact_numero")
	private String numero;
	@Column(name = "fact_fecha")
	private LocalDateTime fecha;
	@Column(name = "fact_cedula")
	private String cedula;
	@Column(name = "fact_total")
	private BigDecimal total;

	// RELACIONES:
	@OneToMany(mappedBy = "miFactura", cascade = CascadeType.ALL)
//	@OneToMany(mappedBy = "miFactura")
	private List<Detalle> miListaDetalleFact;

	// TOSTRING:
	@Override
	public String toString() {
		return "Factura [id=" + id + ", numero=" + numero + ", fecha=" + fecha + ", cedula=" + cedula + ", total="
				+ total + "]";
	}

	// GET Y SET:
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<Detalle> getMiListaDetalleFact() {
		return miListaDetalleFact;
	}

	public void setMiListaDetalleFact(List<Detalle> miListaDetalleFact) {
		this.miListaDetalleFact = miListaDetalleFact;
	}

}
