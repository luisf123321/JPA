package models;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the `Detalle-Factura` database table.
 * 
 */
@Entity
@Table(name="`Detalle-Factura`")
public class Detalle_Factura {

	@Id
	@Column(name="Id")
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int id;

	@Column(name="CantidadCompra")
	private int cantidadCompra;

	//bi-directional many-to-one association to Catalogo_Producto
	@ManyToOne
	@JoinColumn(name="IdCatalogo_Productos")
	private Catalogo_Producto catalogoProducto;

	//bi-directional many-to-one association to Factura
	@ManyToOne
	@JoinColumn(name="IdVenta")
	private Factura factura;

	public Detalle_Factura() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCantidadCompra() {
		return this.cantidadCompra;
	}

	public void setCantidadCompra(int cantidadCompra) {
		this.cantidadCompra = cantidadCompra;
	}

	public Catalogo_Producto getCatalogoProducto() {
		return this.catalogoProducto;
	}

	public void setCatalogoProducto(Catalogo_Producto catalogoProducto) {
		this.catalogoProducto = catalogoProducto;
	}

	public Factura getFactura() {
		return this.factura;
	}

	public void setFactura(Factura factura) {
		this.factura = factura;
	}

}