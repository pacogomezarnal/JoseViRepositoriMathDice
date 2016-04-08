import Ventanas.Juego;
import Ventanas.Login;

public class Principal {
	
	/**
	 *Entrada a el programa de juego porque es el método main principal
	 **----------------------------------------------------------------
	 */
	public static void main(String[] args) {

		
		//ESTAS SON LAS VENTANAS DEL PROGRAMA:
		
		//Genero un objeto de tipo Juego, o sea, de tipo ventana (segunda ventana):
		//Juego ventanaJuego = new Juego();
		
		//Genero un objeto de tipo Login, o sea, de tipo ventana (primera ventana):
		
		Login ventanaLogin = new Login();//le paso a la primera ventana, por el constructor,
		                                             //una referencia a la seguna ventana.
		ventanaLogin.setVisible(true); //hago que la ventana primera sea visible
		
	
	}
	
}