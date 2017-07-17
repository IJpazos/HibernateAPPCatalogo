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

	public T buscarPorId(Class<T> t, long id) {
		return (T) em.find(t, id);
	}
}
