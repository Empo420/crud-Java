package vista;

import javax.swing.*;
import java.awt.*;
import modelo.*;
import controlador.*;
import java.util.*;

public class GUIPersona extends JFrame 
{

	// ---------------------------------------------------------------
	// Atributos
	// ---------------------------------------------------------------
	
	private PanelDatosPersona 		panelDatos;
	private PanelOpcionesPersona 	panelOpciones;
	
	
	// ---------------------------------------------------------------
	// Constructores
	// ---------------------------------------------------------------

	public GUIPersona( ) 
	{
		// Configuracion de la ventana principal de personas
		setTitle( "Gestion de Personas" );
		setResizable( false );
		setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		setSize( 300, 300 );
		
		// Distribuidor grafico
		setLayout( new BorderLayout() );
		
		
		// Creacion de los paneles
		panelDatos = new PanelDatosPersona( );
		panelOpciones = new PanelOpcionesPersona( this );
		
		add( panelDatos, BorderLayout.CENTER );
		add( panelOpciones, BorderLayout.SOUTH );
		
	}
	
	// ---------------------------------------------------------------
	// Metodos
	// ---------------------------------------------------------------

	public void guardar( )
	{
		int id;
		String nombre;
		String telefono;
	
		// Validaci贸n de datos ingresados por el usuario
		try {
			id = Integer.parseInt( panelDatos.getId( ) );
		}
		catch( NumberFormatException e ) {
			JOptionPane.showMessageDialog( this, "El ID debe ser numerico", 
											"Guardar Persona", JOptionPane.WARNING_MESSAGE );
			return;
		}
		
		nombre = panelDatos.getNombre( );
		if( nombre.trim( ).equals( "" ) ) {
			JOptionPane.showMessageDialog( this, "Debe ingresar el nombre de la persona", 
											"Guardar Persona", JOptionPane.WARNING_MESSAGE );
			return;
		}
		
		telefono = panelDatos.getTelefono( );
		if( telefono.trim( ).equals( "" ) ) {
			JOptionPane.showMessageDialog( this, "Debe ingresar el telefono de la persona", 
											"Guardar Persona", JOptionPane.WARNING_MESSAGE );
			return;
		}
		
		ControladorPersona control = new ControladorPersona( );
		ArrayList <Object> lista = control.consultarPersonaPorId( id );
		
		
		if( lista.size() != 0 ) {
			actualizar(id,nombre,telefono);
		}
		else {
			insertar(id,nombre,telefono);
		}
		
		
		
	}
	
	public void buscar( ) 
	{
		//String respuesta = JOptionPane.showInputDialog( "Ingrese el ID de la persona por buscar:" );
		String respuesta = panelDatos.getId();
		int id;
		
		if( respuesta.trim().equals( "" ) ) 
		{
			JOptionPane.showMessageDialog( this, "Debe ingresar el ID de la persona por buscar", 
					"Buscar Persona", JOptionPane.WARNING_MESSAGE );
			return;
		}
		
		// Se verifica que el ID sea numerico
		try {
			id = Integer.parseInt( respuesta );
		}
		catch( NumberFormatException e ) {
			JOptionPane.showMessageDialog( this, "El ID debe ser numerico", 
											"Buscar Persona", JOptionPane.WARNING_MESSAGE );
			return;
		}
		
		
		// Ingreso un ID valido, por tanto, se busca con este
		ControladorPersona controlador = new ControladorPersona( );
		ArrayList <Object> lista = controlador.consultarPersonaPorId( id );
		
		
		if( lista.size() != 0 ) {
			Object[] registro = (Object []) lista.get(0);
			id = Integer.parseInt( registro[0].toString() );
			String nombre = registro[1].toString();
			String telefono = registro[2].toString();
			Persona persona = new Persona(id, nombre, telefono);
			panelDatos.refrescarPanel( persona );
		}
		else 
		{
			JOptionPane.showMessageDialog( this, "No existe una persona con el ID ingresado", 
					"Buscar Persona", JOptionPane.WARNING_MESSAGE );	
		}		
	}
	
	
	public void eliminar( )
	{
		String respuesta = panelDatos.getId();
		
		
		if( !respuesta.trim().equals( "" ) ) 
		{
			buscar();
			int id = Integer.parseInt( respuesta );
		
		
			// Confirmaci贸n de la operaci贸n 0 = Yes, 1 = No
			int opcion = JOptionPane.showConfirmDialog( this, "緿esea Eliminar la persona?", 
																	"Eliminar Persona", JOptionPane.YES_NO_OPTION, 
																	JOptionPane.QUESTION_MESSAGE );
					
			if( opcion == JOptionPane.YES_OPTION ) 
			{
					
				// Se envia la informaci贸n para ser guardada en la base de datos
				ControladorPersona controlador = new ControladorPersona( );
				int x = controlador.eliminarPersona(id);
						
				if( x != 0 )
				{
					JOptionPane.showMessageDialog( this, "La persona fue Eliminada satisfactoriamente", 
					"Eliminar Persona", JOptionPane.INFORMATION_MESSAGE );
					panelDatos.limpiar( );
				}
				else {
					JOptionPane.showMessageDialog( this, "Error al Eliminar la persona", 
									"Eliminar Persona", JOptionPane.WARNING_MESSAGE );
				}		
			}
			else
			{
				JOptionPane.showMessageDialog( this, "Operacion de Eliminar Persona fue cancelada", 
						"Eliminar Persona", JOptionPane.WARNING_MESSAGE );
			}
		}
	}
	
	public void salir( )
	{
		int respuesta = JOptionPane.showConfirmDialog( this, "緿esea salir del modulo de personas?", 
				"Gestionar Persona", JOptionPane.YES_NO_OPTION, 
				JOptionPane.QUESTION_MESSAGE );

		if( respuesta == JOptionPane.YES_OPTION ) {
			// dispose( );
			System.exit( 0 );
		}
	}
	
	
	public void limpiar( ) 
	{
		panelDatos.limpiar();
	}
	
	private void insertar(int id, String nombre, String telefono)
	{
		// Confirmaci贸n de la operaci贸n 0 = Yes, 1 = No
		int respuesta = JOptionPane.showConfirmDialog( this, "緿esea agregar la persona?", 
																"Guardar Persona", JOptionPane.YES_NO_OPTION, 
																JOptionPane.QUESTION_MESSAGE );
				
		if( respuesta == JOptionPane.YES_OPTION ) {
					// Se crea un objeto de la clase persona
			Persona persona = new Persona( id, nombre, telefono );
					
					// Se envia la informaci贸n para ser guardada en la base de datos
			ControladorPersona controlador = new ControladorPersona( );
			int resultado = controlador.agregarPersona( persona );
					
				if( resultado != 0 )
				{
					JOptionPane.showMessageDialog( this, "La persona fue agregada satisfactoriamente", 
								"Agregar Persona", JOptionPane.INFORMATION_MESSAGE );
						panelDatos.limpiar( );
				}
				else {
					JOptionPane.showMessageDialog( this, "Error al Agregar la persona", 
								"Agregar Persona", JOptionPane.WARNING_MESSAGE );
				}
				}
				else
				{
					JOptionPane.showMessageDialog( this, "Operacion de agregar Persona fue cancelada", 
							"Agregar Persona", JOptionPane.WARNING_MESSAGE );
				}
	}
	
	private void actualizar(int id, String nombre, String telefono)
	{
		// Confirmaci贸n de la operaci贸n 0 = Yes, 1 = No
		int respuesta = JOptionPane.showConfirmDialog( this, "緿esea modificarlos datos de la persona?", 
														"Modificar Persona", JOptionPane.YES_NO_OPTION, 
														JOptionPane.QUESTION_MESSAGE );
		
		if( respuesta == JOptionPane.YES_OPTION ) {
			// Se crea un objeto de la clase persona
			Persona persona = new Persona( id, nombre, telefono );
			
			// Se envia la informaci贸n para ser guardada en la base de datos
			ControladorPersona controlador = new ControladorPersona( );
			int resultado = controlador.modificarPersona(persona);
			
			if( resultado != 0 )
			{
				JOptionPane.showMessageDialog( this, "La persona fue Modificada satisfactoriamente", 
						"Modificar Persona", JOptionPane.INFORMATION_MESSAGE );
				panelDatos.limpiar( );
			}
			else {
				JOptionPane.showMessageDialog( this, "Error al Modificar la persona", 
						"Modificar Persona", JOptionPane.WARNING_MESSAGE );
			}
		}
		else
		{
			JOptionPane.showMessageDialog( this, "Operacion de Modificar Persona fue cancelada", 
					"Modificar Persona", JOptionPane.WARNING_MESSAGE );
		}
	}
	
}
