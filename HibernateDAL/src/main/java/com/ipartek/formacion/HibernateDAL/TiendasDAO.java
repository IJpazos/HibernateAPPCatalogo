package com.ipartek.formacion.HibernateDAL;

import javax.persistence.Persistence;

import org.apache.log4j.Logger;

import com.ipartek.formacion.HibernateTipos.Tienda;

public class TiendasDAO extends ObjetoColeccionDAO<Tienda> {

	public TiendasDAO() {
		emf = Persistence.createEntityManagerFactory("aplicacion");
		em = emf.createEntityManager();
		Logger log = Logger.getLogger(this.getClass());
	}
}
