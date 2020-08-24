package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Tienda database table.
 * 
 */
@Entity
@Table(name="Tienda")
@NamedQuery(name="Tienda.findAll", query="SELECT t FROM Tienda t")
public class Tienda implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idTienda;

	@Column(name="Contacto")
	private int contacto;

	@Column(name="Direccion")
	private String direccion;

	@Column(name="NIT")
	private int nit;

	@Column(name="Nombre")
	private String nombre;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="tienda")
	private List<Factura> facturas;

	public Tienda() {
	}

	public int getIdTienda() {
		return this.idTienda;
	}

	public void setIdTienda(int idTienda) {
		this.idTienda = idTienda;
	}

	public int getContacto() {
		return this.contacto;
	}

	public void setContacto(int contacto) {
		this.contacto = contacto;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getNit() {
		return this.nit;
	}

	public void setNit(int nit) {
		this.nit = nit;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setTienda(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setTienda(null);

		return factura;
	}

}