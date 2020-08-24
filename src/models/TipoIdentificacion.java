package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_identificacion database table.
 * 
 */
@Entity
@Table(name="tipo_identificacion")
@NamedQuery(name="TipoIdentificacion.findAll", query="SELECT t FROM TipoIdentificacion t")
public class TipoIdentificacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="idtipo_identificacion")
	private int idtipoIdentificacion;

	@Column(name="tipo_identificacion")
	private String tipoIdentificacion;

	//bi-directional many-to-one association to Cliente
	@OneToMany(mappedBy="tipoIdentificacion")
	private List<Cliente> clientes;

	//bi-directional many-to-one association to Usuario
	@OneToMany(mappedBy="tipoIdentificacion")
	private List<Usuario> usuarios;

	public TipoIdentificacion() {
	}

	public int getIdtipoIdentificacion() {
		return this.idtipoIdentificacion;
	}

	public void setIdtipoIdentificacion(int idtipoIdentificacion) {
		this.idtipoIdentificacion = idtipoIdentificacion;
	}

	public String getTipoIdentificacion() {
		return this.tipoIdentificacion;
	}

	public void setTipoIdentificacion(String tipoIdentificacion) {
		this.tipoIdentificacion = tipoIdentificacion;
	}

	public List<Cliente> getClientes() {
		return this.clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public Cliente addCliente(Cliente cliente) {
		getClientes().add(cliente);
		cliente.setTipoIdentificacion(this);

		return cliente;
	}

	public Cliente removeCliente(Cliente cliente) {
		getClientes().remove(cliente);
		cliente.setTipoIdentificacion(null);

		return cliente;
	}

	public List<Usuario> getUsuarios() {
		return this.usuarios;
	}

	public void setUsuarios(List<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

	public Usuario addUsuario(Usuario usuario) {
		getUsuarios().add(usuario);
		usuario.setTipoIdentificacion(this);

		return usuario;
	}

	public Usuario removeUsuario(Usuario usuario) {
		getUsuarios().remove(usuario);
		usuario.setTipoIdentificacion(null);

		return usuario;
	}

}