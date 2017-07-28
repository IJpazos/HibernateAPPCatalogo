package com.ipartek.formacion.HibernateTipos;

import java.util.HashSet;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Productos")
public class Producto {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	@Column
	private String nombre;
	@Column
	private String descripcion;
	@Column
	private double precio;
	@OneToMany(mappedBy = "tienda")
	private List<ListaProductos> tiendasProductos;
	@Column
	private HashSet<String> tags;

	public Producto(String nombre, String descripcion, double precio, String... tags) {
		//En versiones de java menores de 1.5, ha de ser String[] y usar un array
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.tags = new HashSet<String>();
		for (String string : tags) {
			this.tags.add(string);
		}
	}

	public Producto() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<ListaProductos> getTienda() {
		return tiendasProductos;
	}

	public void setTienda(List<ListaProductos> tienda) {
		this.tiendasProductos = tienda;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		long temp;
		temp = Double.doubleToLongBits(precio);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((tags == null) ? 0 : tags.hashCode());
		result = prime * result + ((tiendasProductos == null) ? 0 : tiendasProductos.hashCode());
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
		Producto other = (Producto) obj;
		if (descripcion == null) {
			if (other.descripcion != null)
				return false;
		} else if (!descripcion.equals(other.descripcion))
			return false;
		if (id != other.id)
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (Double.doubleToLongBits(precio) != Double
				.doubleToLongBits(other.precio))
			return false;
		if (tags == null) {
			if (other.tags != null)
				return false;
		} else if (!tags.equals(other.tags))
			return false;
		if (tiendasProductos == null) {
			if (other.tiendasProductos != null)
				return false;
		} else if (!tiendasProductos.equals(other.tiendasProductos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", precio=" + precio + ", tienda=" + tiendasProductos
				+ ", tags=" + tags + "]";
	}
	public void addTag(String tag){
		tags.add(tag);
	}
	public void removeTag(String tag){
		tags.remove(tag);
		
	}
	public HashSet<String> getTags() {
		return tags;
	}

	public void setTags(HashSet<String> tags) {
		this.tags = tags;
	}
	
}
