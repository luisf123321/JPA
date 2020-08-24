package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Impuesto database table.
 * 
 */
@Entity
@Table(name="Impuesto")
@NamedQuery(name="Impuesto.findAll", query="SELECT i FROM Impuesto i")
public class Impuesto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="IdImpuesto")
	private int idImpuesto;

	@Column(name="Descripcion")
	private String descripcion;

	@Column(name="Porcentaje")
	private String porcentaje;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="impuesto")
	private List<Factura> facturas;

	public Impuesto() {
	}

	public int getIdImpuesto() {
		return this.idImpuesto;
	}

	public void setIdImpuesto(int idImpuesto) {
		this.idImpuesto = idImpuesto;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(String porcentaje) {
		this.porcentaje = porcentaje;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setImpuesto(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setImpuesto(null);

		return factura;
	}

}