package Juego;
/*
 * Definición de la clase mediante la palabra reservada Jugador
 **/
public class Jugador {

	//Datos del jugador:
	
	private String nombre; //variable para almacenar el nombre del jugador
	private String apellidos; //variable para almacenar los apellidos del jugador
	private int edad; //variable para almacenar la edad del jugador
	private int puntos; //variable para almacenar los puntos del jugador
	private String correo; //variable para almacenar el e-mail del jugador
	
	
	
	
	//Constructor: sirve de punto de entrada que se ejecutará al crear un objeto de tipo Jugador 
	//Es como el método main de cada clase:
	
	public Jugador() {
		
		
	}
	
	//Función o Método para la variable nombre
	public void setNombre(String nombre){
		this.nombre=nombre;
		}
	
	public String getNombre(){
		return nombre;
		}
	
	//Función o Método para la variable apellidos
	public void setApellidos(String apellidos){
		this.apellidos=apellidos;
		}
	
	public String getApellidos(){
		return apellidos;
		}
	
	//Función o Método para la variable edad
	public void setEdad(int edad){
		//Condicional if para comprobar que la edad no pueda ser menor que 0:
		if(edad<0){
			this.edad=0;
		}else{
			this.edad=edad;
		}
		}
	
	public int getEdad(){
		return edad;
		}
	
	//Función o Método para la variable puntos
	public void setPuntos(int puntos){
		this.puntos=puntos;
		}
	
	public int getPuntos(){
		return puntos;
		}
	
	
	
	
}
