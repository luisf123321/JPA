package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Catalogo_Productos database table.
 * 
 */
@Entity
@Table(name="Catalogo_Productos")
@NamedQuery(name="Catalogo_Producto.findAll", query="SELECT ca FROM Catalogo_Producto ca")
public class Catalogo_Producto  implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private int idCatalogo_Productos;

	@Column(name="CantidadDisponible")
	private int cantidadDisponible;

	@Column(name="Precio")
	private int precio;

	//bi-directional many-to-one association to Catalogo
	@ManyToOne
	@JoinColumn(name="IdCatalogo")
	private Catalogo catalogo;

	//bi-directional many-to-one association to Descuento
	@ManyToOne
	@JoinColumn(name="IdDescuento")
	private Descuento descuento;

	//bi-directional many-to-one association to Producto
	@ManyToOne
	@JoinColumn(name="IdProducto")
	private Producto producto;

	//bi-directional many-to-one association to Detalle_Factura
	@OneToMany(mappedBy="catalogoProducto")
	private List<Detalle_Factura> detallefacturas;

	public Catalogo_Producto() {
	}

	public int getIdCatalogo_Productos() {
		return this.idCatalogo_Productos;
	}

	public void setIdCatalogo_Productos(int idCatalogo_Productos) {
		this.idCatalogo_Productos = idCatalogo_Productos;
	}

	public int getCantidadDisponible() {
		return this.cantidadDisponible;
	}

	public void setCantidadDisponible(int cantidadDisponible) {
		this.cantidadDisponible = cantidadDisponible;
	}

	public int getPrecio() {
		return this.precio;
	}

	public void setPrecio(int precio) {
		this.precio = precio;
	}

	public Catalogo getCatalogo() {
		return this.catalogo;
	}

	public void setCatalogo(Catalogo catalogo) {
		this.catalogo = catalogo;
	}

	public Descuento getDescuento() {
		return this.descuento;
	}

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

	public Producto getProducto() {
		return this.producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public List<Detalle_Factura> getDetallefacturas() {
		return this.detallefacturas;
	}

	public void setDetallefacturas(List<Detalle_Factura> detallefacturas) {
		this.detallefacturas = detallefacturas;
	}

	public Detalle_Factura addDetallefactura(Detalle_Factura detallefactura) {
		getDetallefacturas().add(detallefactura);
		detallefactura.setCatalogoProducto(this);

		return detallefactura;
	}

	public Detalle_Factura removeDetallefactura(Detalle_Factura detallefactura) {
		getDetallefacturas().remove(detallefactura);
		detallefactura.setCatalogoProducto(null);

		return detallefactura;
	}

}