package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Descuento database table.
 * 
 */
@Entity
@Table(name="Descuento")
public class Descuento {

	@Id
	@Column(name="IdDescuento")
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int idDescuento;

	@Column(name="Descripcion")
	private String descripcion;

	@Column(name="Porcentaje")
	private int porcentaje;

	//bi-directional many-to-one association to Catalogo_Producto
	@OneToMany(mappedBy="descuento")
	private List<Catalogo_Producto> catalogoProductos;

	public Descuento() {
	}

	public int getIdDescuento() {
		return this.idDescuento;
	}

	public void setIdDescuento(int idDescuento) {
		this.idDescuento = idDescuento;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getPorcentaje() {
		return this.porcentaje;
	}

	public void setPorcentaje(int porcentaje) {
		this.porcentaje = porcentaje;
	}

	public List<Catalogo_Producto> getCatalogoProductos() {
		return this.catalogoProductos;
	}

	public void setCatalogoProductos(List<Catalogo_Producto> catalogoProductos) {
		this.catalogoProductos = catalogoProductos;
	}

	public Catalogo_Producto addCatalogoProducto(Catalogo_Producto catalogoProducto) {
		getCatalogoProductos().add(catalogoProducto);
		catalogoProducto.setDescuento(this);

		return catalogoProducto;
	}

	public Catalogo_Producto removeCatalogoProducto(Catalogo_Producto catalogoProducto) {
		getCatalogoProductos().remove(catalogoProducto);
		catalogoProducto.setDescuento(null);

		return catalogoProducto;
	}

}