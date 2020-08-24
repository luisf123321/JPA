package models;

import java.util.ArrayList;



public class Item {
	
	int id;
	String Nombre;
	double Precio;
	double quantity;
	int cantidad;
	double valor;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public double getPrecio() {
		return Precio;
	}
	public void setPrecio(double precio) {
		Precio = precio;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	
	
	
	

}
