package com.ipartek.formacion.HibernateDAL;

import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.ipartek.formacion.HibernateTipos.ListaProductos;

public class ListaProductosDAO extends ObjetoColeccionDAO<ListaProductos>{

	public ListaProductosDAO(){
		emf = Persistence.createEntityManagerFactory("aplicacion");
		em = emf.createEntityManager();
		Logger log = Logger.getLogger(this.getClass());
	}
}
