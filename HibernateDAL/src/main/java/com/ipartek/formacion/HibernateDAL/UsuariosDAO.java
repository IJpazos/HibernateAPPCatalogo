package com.ipartek.formacion.HibernateDAL;

import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.ipartek.formacion.HibernateTipos.Usuario;

public class UsuariosDAO extends ObjetoColeccionDAO<Usuario> {

	public UsuariosDAO() {
		emf = Persistence.createEntityManagerFactory("aplicacion");
		em = emf.createEntityManager();
		Logger log = Logger.getLogger(this.getClass());
	}

	public boolean validar(String nombre, String pass) {
		boolean esValido = false;
		Query query = em
				.createQuery("FROM Usuario where nombre=:nombre and pass=:pass");
		query.setParameter("nombre", nombre);
		query.setParameter("pass", pass);
		try {
			Usuario usuario = (Usuario) query.getSingleResult();
			esValido = true;
		} catch (NoResultException nre) {
			log.info("No se encontró ningun usuario");
		}
		return esValido;
	}
}
