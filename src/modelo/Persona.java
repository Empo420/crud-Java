package modelo;

public class Persona 
{
	
	// ----------------------------------------------------------
	// Atributos
	// ----------------------------------------------------------	
	
	private int 	id;
	private String 	nombre;
	private String 	telefono;
	
	
	// ----------------------------------------------------------
	// Constructor
	// ----------------------------------------------------------	

	public Persona(int id, String nombre, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.telefono = telefono;
	}


	// ----------------------------------------------------------
	// Metodos
	// ----------------------------------------------------------	

	public int getId() {
		return id;
	}


	public String getNombre() {
		return nombre;
	}


	public String getTelefono() {
		return telefono;
	}	
	
}
