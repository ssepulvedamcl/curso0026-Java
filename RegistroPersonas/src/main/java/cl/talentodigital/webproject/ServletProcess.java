package cl.talentodigital.webproject;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cl.personaDao.dao.Persona;
import cl.personaDao.dao.PersonaDao;
import cl.personaDao.dao.PersonaDaoImpl;

/**
 * Servlet implementation class ServletProcess
 */
@WebServlet(
		description = "Este servlet es para procesar la manipulacion de datos de personas", 
		urlPatterns = { "/process" })
public class ServletProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PersonaDao personaDao = new PersonaDaoImpl();
	int id = 0;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletProcess() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("comando").equalsIgnoreCase("crear")) {
			Persona persona = new Persona(++id, 
					request.getParameter("nombre"), 
					Integer.parseInt(request.getParameter("edad")), 
					request.getParameter("email"));
			
			personaDao.insertPersona(persona);
			System.out.println("La persona se ha creado");
			System.out.println(personaDao.getTodasLasPersonas().get(0).getNombre());
		}
	}

}
