package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.Enumeration;

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
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><head><title>Formulario Cookies</title></head>");
		out.println("<body ><center><h1> Únase a nuestra lista de correo </h1>");
		out.println("<p> Introduzca sus datos: </p>");
		out.println("<form action='Practica1'method='post'> Email:<br><input type='email' name='email' required><br>"
				+ "Nombre:<br><input type='text' name='nombre' required><br>"
				+ "Apellidos:<br><input type='text' name='apellidos' required<br><input type='submit' value='Registrarse'></form>");
		out.println("</center></body></html>");
		out.close();
		out.println("Request Headers: ");
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
		}
		HttpSession sesion = request.getSession(true);
		response.setContentType("text/html");
		PrintWriter html = response.getWriter();
		html.println("<strong>");
		Date date = (Date)sesion.getAttribute("date");
		sesion.setMaxInactiveInterval(2000);
		if(date!= null) {
			html.print("Último acceso de la sesión: " +date +"<br>");
			
		}else {
			html.print("Este es el primer acceso de la sesión <br>");
			
		}
		date = new Date(0);
		sesion.setAttribute("date", date);
		html.print("Fecha actual : " +date);
		html.print("</strong>");
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			/* IMPLEMENTACIÓN DEL CÓDIGO QUE LEE LA PETICIÓN DE TIPO POST
			Y GENERA LA RESPUESTA */
		/*Cookies permanentes*/
		String nombre = request.getParameter("nombre");
		String apellidos = request.getParameter("apellidos");
		String email = request.getParameter("email");
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

}
