package com.ipartek.formacion.HibernateDAL;

import java.util.List;

public class ObjetoColeccionDAO<T> extends ObjetoDAO<T> {
	@SuppressWarnings("unchecked")
	public List<T> buscarTodos(String clase){
		Class<?> cls=null;
		try {
			cls = Class.forName("com.ipartek.formacion.HibernateTipos."+clase);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<T> lista = em.createQuery("FROM "+cls.getName()).getResultList();
		return lista;
	}
}