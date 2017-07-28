package com.ipartek.formacion.HibernateWeb.servlets;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ipartek.formacion.HibernateDAL.DALFactory;
import com.ipartek.formacion.HibernateDAL.ObjetoColeccionDAO;
import com.ipartek.formacion.HibernateTipos.Producto;
import com.ipartek.formacion.HibernateTipos.Tienda;
import com.ipartek.formacion.HibernateTipos.Usuario;


public class ControladorCRUD extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlRedireccion="";
		String clase = request.getParameter("tipo");
		
		ObjetoColeccionDAO<Producto> productoDAO;
		ObjetoColeccionDAO<Tienda> tiendaDAO;
		ObjetoColeccionDAO<Usuario> usuarioDAO;
		
		switch(clase){
		case "producto": 
			productoDAO = DALFactory.getProductosDAO();
			request.setAttribute("objeto", productoDAO.buscarPorId(Producto.class, Long.parseLong(request.getParameter("id"))));
			urlRedireccion = "WEB-INF/producto.jsp";
			break;
		case "tienda": 
			tiendaDAO = DALFactory.getTiendasDAO();
			request.setAttribute("objeto", tiendaDAO.buscarPorId(Tienda.class, Long.parseLong(request.getParameter("id"))));
			urlRedireccion = "WEB-INF/tienda.jsp";
			break;
		case "usuario": 
			usuarioDAO = DALFactory.getUsuariosDAO();
			request.setAttribute("objeto", usuarioDAO.buscarPorId(Usuario.class, Long.parseLong(request.getParameter("id"))));
			urlRedireccion = "WEB-INF/perfil.jsp";
			break;
		}
		request.getRequestDispatcher(urlRedireccion).forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlRedireccion="";
		String clase = request.getParameter("tipo");
		Map<String, String[]> parametros = request.getParameterMap();
		
		ObjetoColeccionDAO<Producto> productoDAO;
		ObjetoColeccionDAO<Tienda> tiendaDAO;
		ObjetoColeccionDAO<Usuario> usuarioDAO;
		
		switch(clase){
		case "producto": 
			Producto producto = new Producto();
			producto.setNombre(parametros.get("nombre")[0]);
			producto.setDescripcion(parametros.get("descripcion")[0]);
			producto.setPrecio(Double.parseDouble(parametros.get("precio")[0]));
			producto.addTag(parametros.get("tags")[0]);
			productoDAO = DALFactory.getProductosDAO();
			productoDAO.alta(producto);
			break;
		case "tienda":
			Tienda tienda = new Tienda();
			tienda.setNombre(parametros.get("nombre")[0]);
			tienda.setDescripcion(parametros.get("descripcion")[0]);
			tiendaDAO = DALFactory.getTiendasDAO();
			tiendaDAO.alta(tienda);
			break;
		case "usuario": 
			Usuario usuario = new Usuario();
			usuario.setNombre(parametros.get("nombre")[0]);
			usuario.setPass(parametros.get("pass")[0]);
			if(parametros.get("admin")==null){
				//hay que probarlo, por si acaso el request envia un array vacio y tonces no es nulo, es []
				usuario.setAdmin(false);
			}else{
				usuario.setAdmin(true);
			}
			usuarioDAO = DALFactory.getUsuariosDAO();
			usuarioDAO.alta(usuario);
			break;
		}
		urlRedireccion = "WEB-INF/tienda.jsp";
		request.getRequestDispatcher(urlRedireccion).forward(request, response);
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlRedireccion="";
		String clase = request.getParameter("tipo");
		Map<String, String[]> parametros = request.getParameterMap();
		
		ObjetoColeccionDAO<Producto> productoDAO;
		ObjetoColeccionDAO<Tienda> tiendaDAO;
		ObjetoColeccionDAO<Usuario> usuarioDAO;
		
		switch(clase){
		case "producto": 
			productoDAO = DALFactory.getProductosDAO();
			Producto producto = productoDAO.buscarPorId(Producto.class, Long.parseLong(parametros.get("id")[0]));
			producto.setNombre(parametros.get("nombre")[0]);
			producto.setDescripcion(parametros.get("descripcion")[0]);
			producto.setPrecio(Double.parseDouble(parametros.get("precio")[0]));
			producto.addTag(parametros.get("tags")[0]);
			productoDAO.modificacion(producto);
			break;
		case "tienda":
			tiendaDAO = DALFactory.getTiendasDAO();
			Tienda tienda = tiendaDAO.buscarPorId(Tienda.class, Long.parseLong(parametros.get("id")[0]));
			tienda.setNombre(parametros.get("nombre")[0]);
			tienda.setDescripcion(parametros.get("descripcion")[0]);
			tiendaDAO.modificacion(tienda);
			break;
		case "usuario":
			usuarioDAO = DALFactory.getUsuariosDAO();
			Usuario usuario = usuarioDAO.buscarPorId(Usuario.class, Long.parseLong(parametros.get("id")[0]));
			usuario.setNombre(parametros.get("nombre")[0]);
			usuario.setPass(parametros.get("pass")[0]);
			if(parametros.get("admin")==null){
				//hay que probarlo, por si acaso el request envia un array vacio y tonces no es nulo, es []
				usuario.setAdmin(false);
			}else{
				usuario.setAdmin(true);
			}
			usuarioDAO.modificacion(usuario);
			break;
		}
		urlRedireccion = "WEB-INF/tienda.jsp";
		request.getRequestDispatcher(urlRedireccion).forward(request, response);
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String urlRedireccion="";
		String clase = request.getParameter("tipo");
		Map<String, String[]> parametros = request.getParameterMap();
		
		ObjetoColeccionDAO<Producto> productoDAO;
		ObjetoColeccionDAO<Tienda> tiendaDAO;
		ObjetoColeccionDAO<Usuario> usuarioDAO;
		
		switch(clase){
		case "producto": 
			productoDAO = DALFactory.getProductosDAO();
			Producto producto = productoDAO.buscarPorId(Producto.class, Long.parseLong(parametros.get("id")[0]));
			producto.setNombre(parametros.get("nombre")[0]);
			producto.setDescripcion(parametros.get("descripcion")[0]);
			producto.setPrecio(Double.parseDouble(parametros.get("precio")[0]));
			producto.addTag(parametros.get("tags")[0]);
			productoDAO.baja(producto);
			break;
		case "tienda":
			tiendaDAO = DALFactory.getTiendasDAO();
			Tienda tienda = tiendaDAO.buscarPorId(Tienda.class, Long.parseLong(parametros.get("id")[0]));
			tienda.setNombre(parametros.get("nombre")[0]);
			tienda.setDescripcion(parametros.get("descripcion")[0]);
			tiendaDAO.baja(tienda);
			break;
		case "usuario":
			usuarioDAO = DALFactory.getUsuariosDAO();
			Usuario usuario = usuarioDAO.buscarPorId(Usuario.class, Long.parseLong(parametros.get("id")[0]));
			usuario.setNombre(parametros.get("nombre")[0]);
			usuario.setPass(parametros.get("pass")[0]);
			if(parametros.get("admin")==null){
				//hay que probarlo, por si acaso el request envia un array vacio y tonces no es nulo, es []
				usuario.setAdmin(false);
			}else{
				usuario.setAdmin(true);
			}
			usuarioDAO.baja(usuario);
			break;
		}
		urlRedireccion = "WEB-INF/tienda.jsp";
		request.getRequestDispatcher(urlRedireccion).forward(request, response);
	}

}
