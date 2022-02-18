package vista;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import modelo.*;

public class PanelDatosPersona extends JPanel 
{
	
	// ---------------------------------------------------------------
	// Atributos
	// ---------------------------------------------------------------

	private JLabel labId;
	private JLabel labNombre;
	private JLabel labTelefono;
	
	private JTextField txtId;
	private JTextField txtNombre;
	private JTextField txtTelefono;
	
	
	// ---------------------------------------------------------------
	// Constructores
	// ---------------------------------------------------------------
	
	public PanelDatosPersona( ) 
	{
		// Crear borde
		TitledBorder borde = BorderFactory.createTitledBorder( "Datos de la persona" );
		setBorder( borde );
		
		// Crear los componentes de interfaz gráfica
		labId = new JLabel( "Id:" );
		labNombre = new JLabel( "Nombre:" );
		labTelefono = new JLabel( "Telefono:" );
		
		txtId = new JTextField( );
		txtNombre = new JTextField( );
		txtTelefono = new JTextField( );
		
		// Distribuidor grafico
		setLayout( new GridLayout( 3, 2 ) );	// 3 filas, 2 columnas
		
		// Se agregan los objetos (de izq a der, y de arriba hacia abajo)
		add( labId );
		add( txtId );
		
		add( labNombre );
		add( txtNombre );
		
		add( labTelefono );
		add( txtTelefono );
	}
	
	
	// ---------------------------------------------------------------
	// Metodos
	// ---------------------------------------------------------------
	
	public String getId( ) 
	{
		return txtId.getText( );
	}
	
	public String getNombre( ) 
	{
		return txtNombre.getText( );
	}

	public String getTelefono( ) 
	{
		return txtTelefono.getText( );
	}

	public void limpiar( ) 
	{
		txtId.setText( "" );
		txtNombre.setText( "" );
		txtTelefono.setText( "" );
		txtId.setEnabled(true);
	}
	
	public void refrescarPanel( Persona persona ) 
	{
		txtId.setText( "" + persona.getId( ) );
		txtNombre.setText( persona.getNombre( ) );
		txtTelefono.setText( persona.getTelefono( ) );
		txtId.setEnabled(false);
	}
	
}
