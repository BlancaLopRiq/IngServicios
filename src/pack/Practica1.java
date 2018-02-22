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
		out.println("<html><head><title>Servlet Test</title></head>");
		out.println("<body ><center><h1> THIS IS A SERVLET TEST </h1>");
		String answer = request.getParameter("username");
		out.println("<h2> The username is: " + answer + "</h2>");
		/*Date date = new Date();
		out.println("<h3>The time at the server is " + date.toString() +"</h3>");
		out.println("</center></body></html>");
		out.close();*/
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
			}

}
