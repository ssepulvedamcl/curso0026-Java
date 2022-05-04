package cl.personaDao.dao;

import java.util.ArrayList;
import java.util.List;

public class PersonaDaoImpl implements PersonaDao {

	//Representa una tabla en base de datos
	List<Persona> personas;
	
	public PersonaDaoImpl() {
		personas = new ArrayList<Persona>();
		//Persona persona1 = new Persona(1,"Juan", 18, "juan@juanes.cl");
		//Persona persona2 = new Persona(2,"Pedro", 21, "pedro@chile.cl");
		//personas.add(persona1);
		//personas.add(persona2);
	}
	//Aquí finaliza la simulación de base de datos
	
	@Override
	public List<Persona> getTodasLasPersonas() {
		return personas;
	}

	@Override
	public Persona getPersona(int id) {
		return personas.get(id);
	}

	@Override
	public void updatePersona(Persona persona) {
		personas.get(persona.getId()).setNombre(persona.getNombre());;
		personas.get(persona.getId()).setEmail(persona.getEmail());;
		personas.get(persona.getId()).setEdad(persona.getEdad());;
	}

	@Override
	public void deletePersona(Persona persona) {
		personas.remove(persona);
	}

	@Override
	public void insertPersona(Persona persona) {
		personas.add(persona);
	}

}
