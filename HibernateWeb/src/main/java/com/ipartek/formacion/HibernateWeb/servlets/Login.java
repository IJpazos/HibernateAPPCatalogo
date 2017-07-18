package com.ipartek.formacion.HibernateWeb.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.ipartek.formacion.HibernateDAL.DALFactory;
import com.ipartek.formacion.HibernateDAL.UsuarioDAO;

/**
 * Servlet implementation class Login
 */
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		UsuarioDAO usuario = DALFactory.getUsuarioDAO();
		Logger log = Logger.getLogger(this.getClass());
		String nombre = request.getParameter("nombre");
		String pass = request.getParameter("pass");
		
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(1800);

		Cookie cookie = new Cookie("JSESSIONID", session.getId());
		cookie.setMaxAge(1800);
		response.addCookie(cookie);
	
		if(sesion.getAttribute("usuarioLogeado")!=null){
			log.info("usuario logeado previamente. Redireccionando al perfil...");
			request.getRequestDispatcher("---RELLENAR CON JSP DE PERFIL---");
		}else if (usuario.validar(nombre, pass)) {
			log.info("El usuario es valido.");
			request.getRequestDispatcher("---RELLENAR CON JSP DE BIENVENIDA---").forward(request,response);
		}
	}

}
