package com.ipartek.formacion.HibernateDAL;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.apache.log4j.Logger;

public class ObjetoDAO<T> {
	protected EntityManagerFactory emf;
	protected EntityManager em;
	protected Logger log;

	public void alta(T objeto) {
		em.getTransaction().begin();
		em.persist(objeto);
		em.getTransaction().commit();
	}

	public void modificacion(T objeto) {
		em.getTransaction().begin();
		em.merge(objeto);
		em.getTransaction().commit();
	}

	public void baja(T objeto) {
		em.getTransaction().begin();
		em.remove(objeto);
		em.getTransaction().commit();
	}

	public T buscarPorId(String clase, long id){
		Class<?> cls = null;
		try {
			cls = Class.forName("com.ipartek.formacion.HibernateTipos."+clase);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (T) em.find(cls, id);
	}
}
