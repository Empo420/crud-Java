package test;

import modelo.*;
import controlador.*;

public class TestModificarPersona {

	public static void main(String[] args) 
	{
		// Objeto de la clase persona con los datos nuevos (para la modificacion)
		Persona modelo = new Persona( 1001, "Maria Ramirez", "32198765432" );
		
		ControladorPersona controlador = new ControladorPersona( );
		int resultado = controlador.modificarPersona( modelo );
		
		if( resultado == 1 )
			System.out.println( "Persona modificada en la base de datos" );
		else
			System.out.println( "No se modifico en la base de datos" );

	}

}
