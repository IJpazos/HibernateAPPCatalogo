package com.ipartek.formacion.HibernateDAL;

import java.lang.reflect.InvocationTargetException;

public class DALFactory {
	public static UsuariosDAO getUsuariosDAO() {
		return new UsuariosDAO();
	}

	public static TiendasDAO getTiendasDAO() {
		return new TiendasDAO();
	}

	public static ProductosDAO getProductosDAO() {
		return new ProductosDAO();
	}
	public static Object getObjetoDAO(String nombreClase) {
		//NO OLVIDARSE DEL CASTEO SI SE VA A USAR ESTA FUNCION
		Object obj = null;
		try {
			obj = Class.forName("com.ipartek.formacion.HibernateDAL.DALFactory").getMethod("get"+nombreClase, (Class<?>[])null).invoke((Object[])null,(Object[])null);
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
	}
}
