package cl.personaDao.dao;

import java.util.List;
/***
 * 
 * @author ssm
 * 
 */
public interface PersonaDao {
	public List<Persona> getTodasLasPersonas();
	public Persona getPersona(int id);
	public void updatePersona(Persona persona);
	public void deletePersona(Persona persona);
	public void insertPersona(Persona persona);
	}
