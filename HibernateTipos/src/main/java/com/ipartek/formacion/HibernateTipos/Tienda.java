package com.ipartek.formacion.HibernateTipos;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Tiendas")
public class Tienda {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	@Column
	private String nombre;
	@Column
	private String descripcion;

	@OneToMany(mappedBy = "producto")
	private List<ListaProductos> tiendasProductos;

	public Tienda(String nombre, String descripcion) {
		this.nombre = nombre;
		this.descripcion = descripcion;
	}

	public List<ListaProductos> getProductos() {
		return tiendasProductos;
	}

	public void setProductos(List<ListaProductos> productos) {
		this.tiendasProductos = productos;
	}

	public Tienda() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descripcion == null) ? 0 : descripcion.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result
				+ ((tiendasProductos == null) ? 0 : tiendasProductos.hashCode());
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
		Tienda other = (Tienda) obj;
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
		if (tiendasProductos == null) {
			if (other.tiendasProductos != null)
				return false;
		} else if (!tiendasProductos.equals(other.tiendasProductos))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Tienda [id=" + id + ", nombre=" + nombre + ", descripcion="
				+ descripcion + ", productos=" + tiendasProductos + "]";
	}

}
