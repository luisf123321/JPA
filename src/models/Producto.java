package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Producto database table.
 * 
 */
@Entity
@Table(name="Producto")
@NamedQuery(name="Producto.findAll", query="SELECT p FROM Producto p")

public class Producto implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	
	
	@Id
	@Column(name="IdProducto")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int idProducto;

	@Column(name="CodigoBarra")
	private String codigoBarra;

	@Column(name="Descripcion")
	private String descripcion;

	@Column(name="Nombre")
	private String nombre;

	//bi-directional many-to-one association to Catalogo_Producto
	@OneToMany(mappedBy="producto")
	private List<Catalogo_Producto> catalogoProductos;

	public Producto() {
	}




	public int getIdProducto() {
		return this.idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getCodigoBarra() {
		return this.codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Catalogo_Producto> getCatalogoProductos() {
		return this.catalogoProductos;
	}

	public void setCatalogoProductos(List<Catalogo_Producto> catalogoProductos) {
		this.catalogoProductos = catalogoProductos;
	}

	public Catalogo_Producto addCatalogoProducto(Catalogo_Producto catalogoProducto) {
		getCatalogoProductos().add(catalogoProducto);
		catalogoProducto.setProducto(this);

		return catalogoProducto;
	}

	public Catalogo_Producto removeCatalogoProducto(Catalogo_Producto catalogoProducto) {
		getCatalogoProductos().remove(catalogoProducto);
		catalogoProducto.setProducto(null);

		return catalogoProducto;
	}

}