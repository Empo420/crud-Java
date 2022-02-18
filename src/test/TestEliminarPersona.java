package test;

import controlador.*;

public class TestEliminarPersona {

	public static void main( String[] args ) {
		int id = 1001;
		
		
		ControladorPersona controlador = new ControladorPersona( );
		int resultado = controlador.eliminarPersona( id );

		// Otra forma de eliminar (sobrecarga)
		//Persona persona = new Persona( 1001, "", "" );
		//int resultado = controlador.eliminarPersona( persona );
		
		if( resultado == 1 )
			System.out.println( "Persona eliminada de la base de datos" );
		else
			System.out.println( "No se elimino de la base de datos" );

	}
	
}
