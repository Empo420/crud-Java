package controlador;

import java.util.ArrayList;

import conexion.*;
import modelo.*;

public class ControladorPersona 
{
	
	// ----------------------------------------------------------
	// Atributos
	// ----------------------------------------------------------	

	private ConexionBD conexionBd;

	
	// ----------------------------------------------------------
	// Constructor
	// ----------------------------------------------------------
	
	public ControladorPersona( ) 
	{
		conexionBd = new ConexionBD( );
	}
	
	
	// ----------------------------------------------------------
	// Metodos
	// ----------------------------------------------------------	

	public int agregarPersona( Persona persona ) {
		String sql = "INSERT INTO persona ( id, nombre, telefono ) " + 
					 "VALUES ( " +  persona.getId( ) + ", '" + 
					 				persona.getNombre( ) + "', '" +
					 				persona.getTelefono( ) + "' ); "; 
		
		// Ejecucion de la consulta
		int resultado = conexionBd.executeUpdate( sql );
		return resultado;
	}
	
	public int modificarPersona( Persona persona ) {
		String sql = "UPDATE persona " + 
					 "SET    nombre = '" +  persona.getNombre( ) + "', " + 
				     "       telefono = '" + persona.getTelefono( ) + "' " + 
					 "WHERE  id = " + persona.getId() + "; ";
		
		
		// Ejecucion de la consulta
		int resultado = conexionBd.executeUpdate( sql );
		return resultado;
	}
	
	
	public int eliminarPersona( Persona persona ) {
		String sql = "DELETE FROM persona " +
				     "WHERE  id = " + persona.getId( ) + "; ";
		
		// Ejecucion de la consulta
		int resultado = conexionBd.executeUpdate( sql );
		return resultado;		
	}
	
	
	public int eliminarPersona( int idPersona ) {
		String sql = "DELETE FROM persona " +
				     "WHERE  id = " + idPersona + "; ";
		
		// Ejecucion de la consulta
		int resultado = conexionBd.executeUpdate( sql );
		return resultado;		
	}

	
	public ArrayList <Object> consultarPersonaPorId( int id ) {
		String sql = "SELECT * " +
				 	 "FROM   persona " + 
				     "WHERE  id = " + id + ";";
		
		// Ejecucion de la consulta
		ArrayList <Object> resultado = conexionBd.executeQuery( sql );
		return resultado;		
	}
	
	
	public ArrayList <Object> consultarPersonas( ) {
		String sql = "SELECT * " + 
					 "FROM   persona;";
		
		// Ejecucion de la consulta
		ArrayList <Object> resultado = conexionBd.executeQuery( sql );
		return resultado;		
	}
}
