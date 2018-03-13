package pack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Sesion3
 */
@WebServlet("/Sesion3")
public class Sesion3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sesion3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());

		HttpSession sesion = request.getSession(true);
		response.setContentType("text/html");
		PrintWriter html = response.getWriter();
		html.println("<strong>");
		Date date = (Date)sesion.getAttribute("date");
		sesion.setMaxInactiveInterval(0);
		if(date!= null) {
			String url = "/WEB-INF/Error.jsp";
			getServletContext().getRequestDispatcher(url).forward(request,response);
			
		}else {
			html.print("La sesión ha sido finalizada <br>");
			
		}
		date = new Date(0);
		sesion.setAttribute("date", date);
		html.print("Fecha actual : " +date);
		html.print("</strong>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String url = "/WEB-INF/ListaInformacion.jsp";
		String  email = request.getParameter("email");
		String telefono = request.getParameter("telefono");
		String cpostal = request.getParameter("cpostal");
		
		request.setAttribute("email", email);
		request.setAttribute("telefono", telefono);
		request.setAttribute("cpostal", cpostal);
		getServletContext().getRequestDispatcher(url).forward(request,response);
		
		
	}

}
