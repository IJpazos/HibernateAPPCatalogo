package com.ipartek.formacion.HibernateDAL;

public interface InterfaceCRUDDAL<T> {
	public void alta(T objeto);
	public void baja(T objeto);
	public void modificacion(T objeto);
	public T buscarPorId(Class clase, long id);
}
