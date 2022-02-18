package test;

import controlador.*;
import modelo.*;
import java.util.*;


public class TestConsultarPersona {

	public static void main(String[] args) 
	{
		ControladorPersona controlador = new ControladorPersona( );
		ArrayList <Object> lista = controlador.consultarPersonas( );

		for (int i = 0; i < lista.size(); i++) {
			Object[] p = (Object[]) lista.get( i );
			System.out.println( p[0] + " - " + p[1] + " - " + p[2] );
		}
		
	
		// Consultar una persona por id
		System.out.println( "\nConsulta por persona: " );
		int id = 1;
		lista = controlador.consultarPersonaPorId( id );

		if( lista.size() != 0  ) {
			Object[] p = (Object[]) lista.get( 0 );
			System.out.println( p[0] + " - " + p[1] + " - " + p[2] );
		}
		else {
			System.out.println( "No existe una persona con este codigo" );
		}
	}
	
}
