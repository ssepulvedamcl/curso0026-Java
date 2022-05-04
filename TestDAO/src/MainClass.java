import cl.personaDao.dao.Persona;
import cl.personaDao.dao.PersonaDao;
import cl.personaDao.dao.PersonaDaoImpl;

public class MainClass {

	public static void main(String[] args) {
		PersonaDao personaDao = new PersonaDaoImpl();
		//Listar todas las personas
		for(Persona persona : personaDao.getTodasLasPersonas()) {
			System.out.println("Persona: nombre: " + persona.getNombre()
								+ " id: " + persona.getId());
		}

		//Actualizacion de persona
		Persona persona = personaDao.getTodasLasPersonas().get(0);
		persona.setNombre("Camila");
		personaDao.updatePersona(persona);
		
		//Recuperar un persona
	    persona = personaDao.getPersona(0);
	    System.out.println("Persona: nombre: " + persona.getNombre() 
	    					+ " id: " + persona.getId());
		
	}

}
