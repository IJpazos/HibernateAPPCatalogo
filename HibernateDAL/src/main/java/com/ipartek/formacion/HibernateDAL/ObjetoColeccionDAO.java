package com.ipartek.formacion.HibernateDAL;

import java.util.List;

public class ObjetoColeccionDAO<T> extends ObjetoDAO<T>{
	@SuppressWarnings("unchecked")
	public List<T> buscarTodos(Class<?> clase){

		List<T> lista = em.createQuery("FROM "+clase.getName()).getResultList();
		return lista;
	}
}