package com.ipartek.formacion.HibernateWeb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.HibernateDAL.DALFactory;
import com.ipartek.formacion.HibernateDAL.ObjetoColeccionDAO;


public class ControladorCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlRedireccion;
		ObjetoColeccionDAO<?> objeto = (ObjetoColeccionDAO<?>)DALFactory.getObjetoDAO(request.getParameter("tipo"));
		String clase = request.getParameter("tipo");
		if(request.getParameter("id")==null){
			objeto.buscarTodos(clase);
			urlRedireccion="WEB-INF/principal.jsp";
		}else{
			objeto.buscarPorId(clase,Long.parseLong(request.getParameter("id")));
			urlRedireccion="WEB-INF/producto.jsp";
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
