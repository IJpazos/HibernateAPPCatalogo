package com.ipartek.formacion.HibernateWeb.listeners;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

import com.ipartek.formacion.HibernateDAL.DALFactory;
import com.ipartek.formacion.HibernateDAL.ProductosDAO;
import com.ipartek.formacion.HibernateDAL.TiendasDAO;
import com.ipartek.formacion.HibernateDAL.UsuariosDAO;
import com.ipartek.formacion.HibernateTipos.Producto;
import com.ipartek.formacion.HibernateTipos.Tienda;
import com.ipartek.formacion.HibernateTipos.Usuario;

/**
 * Application Lifecycle Listener implementation class Inicializacion
 *
 */
public class Inicializacion implements ServletContextListener,
		HttpSessionListener {

	public void sessionCreated(HttpSessionEvent se) {

	}

	public void sessionDestroyed(HttpSessionEvent se) {
		// TODO Auto-generated method stub
	}

	public void contextDestroyed(ServletContextEvent sce) {

	}

	public void contextInitialized(ServletContextEvent sce) {

		Logger log = Logger.getLogger(this.getClass());
		log.info("----------HEMOS ENTRADO EN LA INICIALIZACION DEL CONTEXTO--------------");
		ServletContext aplicacion = sce.getServletContext();
		// ////////////////////---INICIALIZACION TIENDAS---//////////////////////
		TiendasDAO tiendasDAO = DALFactory.getTiendasDAO();
		//Este de abajo es para probar con la clase generica
//		TiendasDAO tiendasDAO = (TiendasDAO) DALFactory.getObjetoDAO("TiendasDAO");
		
		List<Tienda> tiendas = tiendasDAO.buscarTodos(Tienda.class);
		if (tiendas.isEmpty()) {
			log.info("La tienda no existe, se creará");
			tiendasDAO.alta(new Tienda("Casa Pepe",
					"POH AQUI.....EH....VENDEMOH COSAH"));
			tiendas = tiendasDAO.buscarTodos(Tienda.class);
		} else {
			log.info("la tienda 1 se ha encontrado");
		}
		// ////////////////////---INICIALIZACION USUARIOS---//////////////////////
		UsuariosDAO usuarioDAO = DALFactory.getUsuariosDAO();
//		UsuariosDAO usuarioDAO = (UsuariosDAO) DALFactory.getObjetoDAO("UsuariosDAO");
		log.info("vamos a checkear si existen usuarios o no");
		if(usuarioDAO.buscarPorId(Usuario.class, 1)==null){
			log.info("No existe ningun usuario aun");
			usuarioDAO.alta(new Usuario("admin", "admin", true));
		}
		// ////////////////////---INICIALIZACION PRODUCTOS---//////////////////////
		ProductosDAO productoDAO = DALFactory.getProductosDAO();
		log.info("ahora miremos si existe algun producto");
		if(productoDAO.buscarPorId(Producto.class, 1)==null){
			log.info("no existe ningun producto aun");
//			String[] arrTags ={"cocina","Electrodomesticos","hogar"};
			productoDAO.alta(new Producto("lavadora", "La nueva lavadora del futuro", 349.99,"cocina","Electrodomestico","Hogar"));
//			productoDAO.alta(new Producto("lavadora", "La nueva lavadora del futuro", 349.99,arrTags));
//			Este segundo es para versiones menores de java 1.5
		}
		
		// ////////////////////---PUESTA PARAMETROS---//////////////////////

		aplicacion.setAttribute("tiendas", tiendas);
	}

}
