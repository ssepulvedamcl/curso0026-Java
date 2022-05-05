import cl.personaDao.dao.Persona;
import cl.personaDao.dao.PersonaDao;
import cl.personaDao.dao.PersonaDaoImpl;

public class MainClass {

	public static void main(String[] args) {
		PersonaDao personaDao = new PersonaDaoImpl();
		//Listar todas las personas
		
		
		personaDao.insertPersona(new Persona(1,"Pedro",30,"pedro@lospedros.com"));
		
		for(Persona persona : personaDao.getTodasLasPersonas()) {
			System.out.println("Persona: nombre: " + persona.getNombre()
								+ " id: " + persona.getId());
		}

		//Actualizacion de persona
		Persona persona = personaDao.getTodasLasPersonas().get(0);
		persona.setNombre("Camila");
		personaDao.updatePersona(persona);
		
		//Recuperar un persona
	    persona = personaDao.getPersona(1);
	    if(persona!=null) {
	    	System.out.println("Persona: nombre: " + persona.getNombre() 
			+ " id: " + persona.getId());
	    	personaDao.deletePersona(persona);
	    }
	    
	    	
	
	}

}
