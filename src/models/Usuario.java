package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Usuario database table.
 * 
 */
@Entity
@Table(name="Usuario")
@NamedQuery(name="Usuario.findAll", query="SELECT u FROM Usuario u")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int idusuarios;

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

	@Column(name="Password")
	private String password;

	@Column(name="User")
	private String user;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="usuario")
	private List<Factura> facturas;

	//bi-directional many-to-one association to TipoIdentificacion
	@ManyToOne
	@JoinColumn(name="IdTipo_Identificacion")
	private TipoIdentificacion tipoIdentificacion;

	public Usuario() {
	}

	public int getIdusuarios() {
		return this.idusuarios;
	}

	public void setIdusuarios(int idusuarios) {
		this.idusuarios = idusuarios;
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

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUser() {
		return this.user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setUsuario(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setUsuario(null);

		return factura;
	}

	public TipoIdentificacion getTipoIdentificacion() {
		return this.tipoIdentificacion;
	}

	public void setTipoIdentificacion(TipoIdentificacion tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

}