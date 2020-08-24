package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Cliente database table.
 * 
 */
@Entity
@Table(name="Cliente")
public class Cliente{

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int idCliente;

	@Column(name="Apellido")
	private String apellido;

	@Column(name="Celular")
	private int celular;

	@Column(name="Direcion")
	private String direcion;

	@Column(name="Nombre")
	private String nombre;

	@Column(name="Numero_Identificacion")
	private int numero_Identificacion;

	//bi-directional many-to-one association to TipoIdentificacion
	@ManyToOne
	@JoinColumn(name="IdTipo_Identificacion")
	private TipoIdentificacion tipoIdentificacion;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="cliente")
	private List<Factura> facturas;

	public Cliente() {
	}

	public int getIdCliente() {
		return this.idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getCelular() {
		return this.celular;
	}

	public void setCelular(int celular) {
		this.celular = celular;
	}

	public String getDirecion() {
		return this.direcion;
	}

	public void setDirecion(String direcion) {
		this.direcion = direcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getNumero_Identificacion() {
		return this.numero_Identificacion;
	}

	public void setNumero_Identificacion(int numero_Identificacion) {
		this.numero_Identificacion = numero_Identificacion;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return this.tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setCliente(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setCliente(null);

		return factura;
	}

}