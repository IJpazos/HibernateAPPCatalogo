package com.ipartek.formacion.HibernateDAL;

public class DALFactory {
	public static UsuarioDAO getUsuarioDAO() {
		return new UsuarioDAO();
	}

	public static TiendasDAO getTiendaDAO() {
		return new TiendasDAO();
	}

	public static ProductoDAO getProductoDAO() {
		return new ProductoDAO();
	}
}
