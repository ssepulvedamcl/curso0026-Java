package cl.personaDao.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PersonaDaoImpl implements PersonaDao {


	Connection conn = null;
	
	public PersonaDaoImpl() {
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (Exception ex) {
			System.out.println("Driver no instalado, revisar CLASSPATH");
		}

		try {
			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/personasBD?" + 
					"user=curso0026&password=curso0026*");
		} catch (SQLException ex) {
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
	}
	//Aquí finaliza la simulación de base de datos
	
	@Override
	public List<Persona> getTodasLasPersonas() {

		List<Persona> personas = new ArrayList<Persona>();
		Statement stmt = null;
		ResultSet rs = null;
		String sqlQuery = "SELECT id,nombre,edad,email "
						+ "FROM persona order by nombre";
		try {
			stmt = conn.createStatement();
			//rs = stmt.executeQuery(sqlQuery);
			
			if (stmt.execute(sqlQuery)) {
				rs = stmt.getResultSet();
				while(rs.next()) {
					Persona persona = new Persona(
							rs.getInt("id"),
							rs.getString("nombre"),
							rs.getInt("edad"),
							rs.getString("email"));
					personas.add(persona);
				}
			}

		}catch(SQLException ex){
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally{
		    // it is a good idea to release
		    // resources in a finally{} block
		    // in reverse-order of their creation
		    // if they are no-longer needed

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }
		}
		return personas;
	}

	@Override
	public Persona getPersona(int id) {
		Persona persona = null;
		Statement stmt = null;
		ResultSet rs = null;
		String sqlQuery = "SELECT id,nombre,edad,email "
						+ "FROM persona WHERE id=" + id + "";
		try {
			stmt = conn.createStatement();
			//rs = stmt.executeQuery(sqlQuery);
			
			if (stmt.execute(sqlQuery)) {
				rs = stmt.getResultSet();
				while(rs.next()) {
					persona = new Persona(
						rs.getInt("id"),
						rs.getString("nombre"),
						rs.getInt("edad"),
						rs.getString("email"));
				}
			}

		}catch(SQLException ex){
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally{
		    // it is a good idea to release
		    // resources in a finally{} block
		    // in reverse-order of their creation
		    // if they are no-longer needed

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }
		}
		if(persona!=null) {
			return persona;
		}
		return null;
	}

	@Override
	public void updatePersona(Persona persona) {
		Statement stmt = null;
		ResultSet rs = null;
		String sqlQuery = "UPDATE persona "
				+ "SET nombre ='" + persona.getNombre() +  "', edad = " + persona.getEdad() + ","
				+ " email = '" + persona.getEmail() + "'"
				+ "WHERE id = " + persona.getId();
		try {
			stmt = conn.createStatement();
			stmt.execute(sqlQuery);
		}catch(SQLException ex){
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally{
		    // it is a good idea to release
		    // resources in a finally{} block
		    // in reverse-order of their creation
		    // if they are no-longer needed

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }
		}

	}

	@Override
	public void deletePersona(Persona persona) {
		Statement stmt = null;
		ResultSet rs = null;
		String sqlQuery = "DELETE FROM persona "
				+ "WHERE id = " + persona.getId();
		System.out.println(sqlQuery);
		try {
			stmt = conn.createStatement();
			stmt.execute(sqlQuery);
		}catch(SQLException ex){
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally{
		    // it is a good idea to release
		    // resources in a finally{} block
		    // in reverse-order of their creation
		    // if they are no-longer needed

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }
		}
	}

	@Override
	public void insertPersona(Persona persona) {
		Statement stmt = null;
		ResultSet rs = null;
		String sqlQuery = "INSERT persona "
				+ "VALUES (" + persona.getId() + ", '" + persona.getNombre() +  "', " + persona.getEdad() + ","
				+ " '" + persona.getEmail() + "')";
		System.out.println(sqlQuery);
		try {
			stmt = conn.createStatement();
			stmt.execute(sqlQuery);
		}catch(SQLException ex){
			// handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());
		}
		finally{
		    // it is a good idea to release
		    // resources in a finally{} block
		    // in reverse-order of their creation
		    // if they are no-longer needed

		    if (rs != null) {
		        try {
		            rs.close();
		        } catch (SQLException sqlEx) { } // ignore

		        rs = null;
		    }

		    if (stmt != null) {
		        try {
		            stmt.close();
		        } catch (SQLException sqlEx) { } // ignore

		        stmt = null;
		    }
		}

	}

}
