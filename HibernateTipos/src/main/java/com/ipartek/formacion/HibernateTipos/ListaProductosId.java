package com.ipartek.formacion.HibernateTipos;

import java.io.Serializable;

public class ListaProductosId implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private int producto;
	private int tienda;
	
	public int getProducto() {
		return producto;
	}
	public void setProducto(int producto) {
		this.producto = producto;
	}
	public int getTienda() {
		return tienda;
	}
	public void setTienda(int tienda) {
		this.tienda = tienda;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + producto;
		result = prime * result + tienda;
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
		ListaProductosId other = (ListaProductosId) obj;
		if (producto != other.producto)
			return false;
		if (tienda != other.tienda)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ListaProductosId [producto=" + producto + ", tienda=" + tienda
				+ "]";
	}
	
}
