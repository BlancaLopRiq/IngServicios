package pack;

import java.io.IOException;



import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class Practica1
 */
@WebServlet("/Practica1")
public class Practica1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Practica1() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url="/WEB-INF/Index.html";
		getServletContext().getRequestDispatcher(url).forward(request,response);
		// TODO Auto-generated method stub
		
		
		/*SESION 1
		 * out.println("Request Headers: ");
		Enumeration names = request.getHeaderNames();
		while (names.hasMoreElements()) {
			String name = (String) names.nextElement();
			Enumeration values = request.getHeaders(name);
			if(values != null) {
				while(values.hasMoreElements()) {
					String value = (String) values.nextElement();
					out.println(name + ": " + value);
				}
			}
		}*//*
		HttpSession sesion = request.getSession(true);
		response.setContentType("text/html");
		PrintWriter html = response.getWriter();
		html.println("<strong>");
		Date date = (Date)sesion.getAttribute("date");
		sesion.setMaxInactiveInterval(2000);
		if(date!= null) {
			html.print("�ltimo acceso de la sesi�n: " +date +"<br>");
			
		}else {
			html.print("Este es el primer acceso de la sesi�n <br>");
			
		}
		date = new Date(0);
		sesion.setAttribute("date", date);
		html.print("Fecha actual : " +date);
		html.print("</strong>");*/
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			/* IMPLEMENTACI�N DEL C�DIGO QUE LEE LA PETICI�N DE TIPO POST
			Y GENERA LA RESPUESTA */

		String usuario = request.getParameter("usuario");
		String passw = request.getParameter("clave");
		String url = "";
		UsuarioDTO db = new UsuarioDTO();
		if (db.checkAdmin(usuario, passw)) {
			url = "/WE-INF/ListaUsuarios.jsp";
		}
			else {
				url = "/WEB-INF/Error.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
			
		}
		/*Cookies permanentes*/
		/*
		String apellidos = request.getParameter("apellidos");
		String email = request.getParameter("email");
		String nombre = request.getParameter("nombre");
		Cookie c = new Cookie("nombreCookie", nombre);
		c.setMaxAge(60);
		response.addCookie(c);
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie: cookies) {
			cookie.setMaxAge(0);
			cookie.setPath("/");
			response.addCookie(cookie);
		}
			/*
		PrintWriter out = response.getWriter();
	    out.println(nombre + ": "+ c);*/
		
	}


