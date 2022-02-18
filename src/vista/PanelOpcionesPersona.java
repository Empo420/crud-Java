package vista;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;


public class PanelOpcionesPersona extends JPanel implements ActionListener
{
	
	// ---------------------------------------------------------------
	// Constantes (Eventos)
	// ---------------------------------------------------------------

	public static final String GUARDAR 	= "Guardar";
	public static final String BUSCAR 	= "Buscar";
	public static final String ELIMINAR = "Eliminar";
	public static final String LIMPIAR 	= "Limpiar";
	public static final String SALIR 	= "Salir";
		

	// ---------------------------------------------------------------
	// Atributos
	// ---------------------------------------------------------------

	private JButton butGuardar;
	private JButton butBuscar;
	private JButton butEliminar;
	private JButton butLimpiar;
	private JButton butSalir;
	
	private GUIPersona principal;
	
	// ---------------------------------------------------------------
	// Constructores
	// ---------------------------------------------------------------

	public PanelOpcionesPersona( GUIPersona pPrincipal ) 
	{
		
		principal = pPrincipal;
		
		// Crear borde
		TitledBorder borde = BorderFactory.createTitledBorder( "Opciones" );
		setBorder( borde );
		
		
		// Creacion de componentes de interfaz grafica
		butGuardar = new JButton( "Guardar" );
		butGuardar.setActionCommand( GUARDAR );
		butGuardar.addActionListener( this );
		
		butBuscar = new JButton( "Buscar" );
		butBuscar.setActionCommand( BUSCAR );
		butBuscar.addActionListener( this );
		
		butEliminar = new JButton( "Eliminar" );
		butEliminar.setActionCommand( ELIMINAR );
		butEliminar.addActionListener( this );
		
		butLimpiar = new JButton( "Limpiar" );
		butLimpiar.setActionCommand( LIMPIAR );
		butLimpiar.addActionListener( this );
		
		
		butSalir = new JButton( "Salir" );
		butSalir.setActionCommand( SALIR );
		butSalir.addActionListener( this );
		
		// Distribuidor grafico
		setPreferredSize( new Dimension( 0, 100 ) );
		setLayout( new GridLayout( 2,  3 ) );
		
		
		// Se agregan los objetos (de izq a der, y de arriba hacia abajo)
		add( butGuardar );
		add( butBuscar );
		add( butEliminar );
		add( butLimpiar );
		add( butSalir );
		
	}
	
	// ---------------------------------------------------------------
	// Metodos
	// ---------------------------------------------------------------

	@Override
	public void actionPerformed( ActionEvent evento ) 
	{
		String comando = evento.getActionCommand( );
		
		switch( comando ) 
		{
			case GUARDAR:
				principal.guardar( );
				break;

			case BUSCAR:
				principal.buscar( );
				break;

			case ELIMINAR:
				principal.eliminar( );
				break;
		
			case SALIR:
				principal.salir( );
				break;
			
			case LIMPIAR:
				principal.limpiar();;
				break;
		}
		
	}

}
