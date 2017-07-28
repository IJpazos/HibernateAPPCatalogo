package com.ipartek.formacion.HibernateTipos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@IdClass(ListaProductosId.class)
public class ListaProductos {
	@Id
	@ManyToOne
	@JoinColumn(name = "Tienda_id")
	private Tienda tienda;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "Producto_id")
	private Producto producto;
	
//	@Column
//	private double precio;
	
	@Column
	private int stock;
	
	public ListaProductos() {
		super();
	}

	public ListaProductos(Tienda tienda, Producto producto, int stock) {
		super();
		this.tienda = tienda;
		this.producto = producto;
		this.stock = stock;
	}

	public Tienda getTienda() {
		return tienda;
	}

	public void setTienda(Tienda tienda) {
		this.tienda = tienda;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((producto == null) ? 0 : producto.hashCode());
		result = prime * result + stock;
		result = prime * result + ((tienda == null) ? 0 : tienda.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ListaProductos other = (ListaProductos) obj;
		if (producto == null) {
			if (other.producto != null)
				return false;
		} else if (!producto.equals(other.producto))
			return false;
		if (stock != other.stock)
			return false;
		if (tienda == null) {
			if (other.tienda != null)
				return false;
		} else if (!tienda.equals(other.tienda))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ListaProductos [tienda=" + tienda.getNombre() + ", producto=" + producto.getNombre()
				+ ", stock=" + stock + "]";
	}
	
}
