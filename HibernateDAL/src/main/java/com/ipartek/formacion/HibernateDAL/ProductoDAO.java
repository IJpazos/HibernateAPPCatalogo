package com.ipartek.formacion.HibernateDAL;

import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.ipartek.formacion.HibernateTipos.Producto;

public class ProductoDAO extends ObjetoDAO<Producto> {

	public ProductoDAO() {
		emf = Persistence.createEntityManagerFactory("aplicacion");
		em = emf.createEntityManager();
		Logger log = Logger.getLogger(this.getClass());
	}
}
