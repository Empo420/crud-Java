package conexion;

import java.sql.*;
import java.util.*;
import modelo.*;

public class ConexionBD 
{
	
	// ----------------------------------------------------------
	// Atributos
	// ----------------------------------------------------------	

	private Connection conexion;
	
	
	// ----------------------------------------------------------
	// Constructor
	// ----------------------------------------------------------	

	public ConexionBD( ) 
	{
		conexion = null;
		conectar( );
	}
	
	
	public ConexionBD( String url, String user, String passwd ) 
	{
		conexion = null;
		conectar( url, user, passwd );
	}
	
	
	// ----------------------------------------------------------
	// Metodos
	// ----------------------------------------------------------	

	private void conectar( ) 
	{
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			conexion = DriverManager.getConnection( "jdbc:mysql://localhost/desarrollo", "root", "" ); 
		}
		catch( ClassNotFoundException e )
		{
			System.out.println( e.getMessage( ) );
		}
		catch( SQLException e ) {
			System.out.println( e.getMessage( ) );
		}
		
	}
	
	
	private void conectar( String url, String user, String passwd ) 
	{
		try {
			Class.forName( "com.mysql.jdbc.Driver" );
			conexion = DriverManager.getConnection( url, user, passwd ); 
		}
		catch( ClassNotFoundException e )
		{
			System.out.println( e.getMessage( ) );
		}
		catch( SQLException e ) {
			System.out.println( e.getMessage( ) );
		}
		
	}

	// INSERT, DELETE, UPDATE
	public int executeUpdate( String sql ) {
		int resultado = 0;
		
		try {
			Statement s = conexion.createStatement( );
			resultado = s.executeUpdate( sql );
		}
		catch( SQLException e ) {
			System.out.println( e.getMessage( ) );
		}

		return resultado;
	}
	
	// SELECT
	public ArrayList <Object> executeQuery( String sql ) {
		ResultSet rs = null;
		ArrayList <Object> lista = null;
		
		try {
			Statement s = conexion.createStatement( );
			rs = s.executeQuery( sql );
			lista = darRegistro( rs );
			
		}
		catch( SQLException e ) {
			System.out.println( e.getMessage( ) );
		}
		
		return lista;
	}
	
	
	public void cerrarConexion( ) 
	{
		try {
			if( conexion != null )
				conexion.close( );
		}
		catch( SQLException e ) {
			System.out.println( e.getMessage( ) );
		}
	}
	
	/*
	private ArrayList <Persona> darPersonas( ResultSet rs ) 
	{
		ArrayList <Persona> personas = new ArrayList<Persona>( );
		
		try {
			while( rs.next() ) 
			{
				int id = rs.getInt( 1 );
				String nombre = rs.getString( 2 );
				String telefono = rs.getString( 3 );
				
				Persona persona = new Persona( id, nombre, telefono );
				personas.add( persona );			
			}
		} 
		catch (SQLException e) {
			System.out.println( e.getMessage( ) );
		}
		
		return personas;
	}
	*/
	
	private ArrayList darRegistro( ResultSet rs )
	{
		ArrayList<Object> lista = new ArrayList<>();
		
		try {
			
			ResultSetMetaData md = rs.getMetaData();
			int columnas = md.getColumnCount();
			
			while( rs.next() ) 
			{
				Object[] fila = new Object[columnas];
				for (int i = 1; i <= columnas; i++) 
				{
					
					fila[i - 1] = rs.getObject(i);
				}
				lista.add(fila);
			}
			
		} 
		catch (SQLException e) 
		{
			System.out.println( e.getMessage( ) );
		}
		
		return lista;
	}
	
	
	
	
	
	
	
	
	
	
	
}
