package models;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the Factura database table.
 * 
 */
@Entity
@Table(name="Factura")
public class Factura implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.SEQUENCE)
	private int idVenta;

	@Column(name="Fecha")
	private String fecha;

	@Column(name="Hora")
	private String hora;

	@Column(name="Valor_Total")
	private String valor_Total;

	//bi-directional many-to-one association to Detalle_Factura
	@OneToMany(mappedBy="factura")
	private List<Detalle_Factura> detallefacturas;

	//bi-directional many-to-one association to Impuesto
	@ManyToOne
	@JoinColumn(name="IdImpuesto")
	private Impuesto impuesto;

	//bi-directional many-to-one association to Usuario
	@ManyToOne
	@JoinColumn(name="IdCajero")
	private Usuario usuario;

	//bi-directional many-to-one association to Cliente
	@ManyToOne
	@JoinColumn(name="IdCliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Tienda
	@ManyToOne
	@JoinColumn(name="IdTienda")
	private Tienda tienda;

	public Factura() {
	}

	public int getIdVenta() {
		return this.idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public String getFecha() {
		return this.fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return this.hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getValor_Total() {
		return this.valor_Total;
	}

	public void setValor_Total(String valor_Total) {
		this.valor_Total = valor_Total;
	}

	public List<Detalle_Factura> getDetallefacturas() {
		return this.detallefacturas;
	}

	public void setDetallefacturas(List<Detalle_Factura> detallefacturas) {
		this.detallefacturas = detallefacturas;
	}

	public Detalle_Factura addDetallefactura(Detalle_Factura detallefactura) {
		getDetallefacturas().add(detallefactura);
		detallefactura.setFactura(this);

		return detallefactura;
	}

	public Detalle_Factura removeDetallefactura(Detalle_Factura detallefactura) {
		getDetallefacturas().remove(detallefactura);
		detallefactura.setFactura(null);

		return detallefactura;
	}

	public Impuesto getImpuesto() {
		return this.impuesto;
	}

	public void setImpuesto(Impuesto impuesto) {
		this.impuesto = impuesto;
	}

	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Tienda getTienda() {
		return this.tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

}