package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="Catalogo")
@NamedQuery(name="Catalogo.findAll", query="SELECT c FROM Catalogo c")
public class Catalogo  implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int idCatalogo;

	@Column(name="Nombre")
	private String nombre;

	//bi-directional many-to-one association to Catalogo_Producto
	@OneToMany(mappedBy="catalogo")
	private List<Catalogo_Producto> catalogoProductos;

	public Catalogo() {
	}

	public int getIdCatalogo() {
		return this.idCatalogo;
	}

	public void setIdCatalogo(int idCatalogo) {
		this.idCatalogo = idCatalogo;
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
		catalogoProducto.setCatalogo(this);

		return catalogoProducto;
	}

	public Catalogo_Producto removeCatalogoProducto(Catalogo_Producto catalogoProducto) {
		getCatalogoProductos().remove(catalogoProducto);
		catalogoProducto.setCatalogo(null);

		return catalogoProducto;
	}

}