package test;

import modelo.*;
import controlador.*;

public class TestAgregarPersona {

	public static void main(String[] args) 
	{
		Persona modelo = new Persona( 1001, "Juan Perez", "3001234567" );
		
		ControladorPersona controlador = new ControladorPersona( );
		int resultado = controlador.agregarPersona( modelo );
		
		if( resultado == 1 )
			System.out.println( "Persona agregada a la base de datos" );
		else
			System.out.println( "No se agrego a la base de datos" );
		
	}

}
