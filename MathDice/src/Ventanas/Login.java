
package Ventanas;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Juego.Jugador;

public class Login extends JFrame {

	
	private JPanel contentPane;
	private JTextField textFieldNombre;
	private JTextField textFieldApellidos;
	private JTextField textFieldEdad;
	private JTextField textFieldMensaje;
	private JButton btnComprobacion; //añado la propiedad botón para que quede definida a nivel superior
	private Jugador playerOne; //defino un objeto de tipo jugador que luego crearé para utilizarlo
	private Login referenciaLogin; //creo una referencia a la Clase login para que sea accesible por todos los elementos 
	                               //de dentro del constructor de la clase. Así, desde dentro del ActionListener puede
	                               //accederse y cerrarse la ventana login utilizando el método dispose.
	private Juego ventanajuego; //creo una referencia al objeto Juego para que sea accesible por todos los elementos 
                                //de dentro del constructor de la clase
	private Juego v2;
	
	
	//Constructor de la ventana:
	public Login() { //referencia a la ventanajuego dentro del constructor del objeto Login
		                     //es decir, creo una referencia a la segunda ventana dentro de primera ventana
		//Propiedades de la ventana
setTitle("LOGIN");
		
		//Propiedades-Configuración de nuestra ventana:
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 505, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		referenciaLogin = this; //ligo la etiqueta this a la referencia al objeto, para que la etiqueta 
		                        //referenciaLogin haga la función de la clase Login. Así, con this podré cerrar 
		                        //la primera ventana desde dentro del botón
		//ventanajuego = vJ; //ligo la etiqueta ventanajuego a la referencia al objeto
		
		//Etiqueta datos del jugador:
		JLabel etiquetaDatosJugador = new JLabel("DATOS DEL JUGADOR");
		etiquetaDatosJugador.setFont(new Font("Tahoma", Font.BOLD, 13));
		etiquetaDatosJugador.setBounds(12, 13, 135, 16);
		contentPane.add(etiquetaDatosJugador);
	
		//Etiqueta nombre:
		JLabel etiquetaNombre = new JLabel("Nombre");
		etiquetaNombre.setBounds(12, 59, 111, 16);
		contentPane.add(etiquetaNombre);
		
		//Etiqueta apellidos:
		JLabel etiquetaApellidos = new JLabel("Apellidos");
		etiquetaApellidos.setBounds(12, 114, 111, 16);
		contentPane.add(etiquetaApellidos);
		
		//Etiqueta edad:
		JLabel etiquetaEdad = new JLabel("Edad");
		etiquetaEdad.setBounds(12, 165, 111, 16);
		contentPane.add(etiquetaEdad);
		
		//Caja de texto para introducir el nombre:
		textFieldNombre = new JTextField();
		textFieldNombre.setBounds(120, 59, 335, 22);
		contentPane.add(textFieldNombre);
		textFieldNombre.setColumns(10);
		
		//Caja de texto para introducir los apellidos:
		textFieldApellidos = new JTextField();
		textFieldApellidos.setColumns(10);
		textFieldApellidos.setBounds(120, 111, 335, 22);
		contentPane.add(textFieldApellidos);
		
		//Caja de texto para introducir la edad:
		textFieldEdad = new JTextField();
		textFieldEdad.setColumns(10);
		textFieldEdad.setBounds(120, 162, 335, 22);
		contentPane.add(textFieldEdad);
		
		//Boton de comrobación de campos del jugador:
		btnComprobacion = new JButton("A JUGAR");
		//Evento AddActionListener:
		btnComprobacion.addActionListener(new ActionListener() {
			//lo que hacemos cuando llega un evento:
			public void actionPerformed(ActionEvent arg0) {
				//Condición si para controlar que todos los campos sean completados:
				if(textFieldNombre.getText().length()==0){
					textFieldMensaje.setText("FALTAN CAMPOS POR RELLENAR");
				}else if(textFieldApellidos.getText().length()==0){
					textFieldMensaje.setText("FALTAN CAMPOS POR RELLENAR");
				}else if(textFieldEdad.getText().length()==0){
					textFieldMensaje.setText("FALTAN CAMPOS POR RELLENAR");
				}else{
					//textFieldMensaje.setText("FORMULARIO COMPLETADO RELLENAR");
					playerOne.setNombre(textFieldNombre.getText());
					playerOne.setApellidos(textFieldApellidos.getText());
					String edadString=textFieldEdad.getText();//creamos la variable edadString que se encargará de recoger 
					                                          //el string que entrará en la caja de texto edad
					int edad=Integer.valueOf(edadString);//luego, con el método Integer.valueOf (recoge un String y lo convierte en un integer), 
					                                     //transformamos el String edad en un valor numérico que será
					                                     // el que se almacenará como edad del jugador
					playerOne.setEdad(edad);//así, transformamos el string que entra en el campo de texto edad a un integer 
					
					//Mostrar por ventana el mensaje con los datos del jugador:
					System.out.println("Player "+playerOne.getNombre()+ " "+playerOne.getApellidos()+" edad "+playerOne.getEdad()+" ha sido generado");
					textFieldMensaje.setText("Player "+playerOne.getNombre()+ " "+playerOne.getApellidos()+" edad "+playerOne.getEdad()+" ha sido generado");
					referenciaLogin.dispose(); //con el método dispose cierro la ventana al pulsar el botón
					//ventanajuego.setVisible(true);
					//ventanajuego.labelJuego.setText("Bienvenido al juego "+playerOne.getNombre());
					v2 = new Juego(playerOne);
					//v2.setJugador(playerOne);
					v2.setVisible(true);//creo una referencia a la segunda ventana con la etiqueta v2
					                    //para poder hacerla visible desde esta primera ventana
				}
			}
		});
		btnComprobacion.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnComprobacion.setBounds(12, 251, 443, 25);
		contentPane.add(btnComprobacion);
		
		textFieldMensaje = new JTextField();
		textFieldMensaje.setBounds(12, 318, 443, 127);
		contentPane.add(textFieldMensaje);
		textFieldMensaje.setColumns(10);
		
		/*
		 *Comienzo del código
		 *---------------------------
		 */
		//tipo nombreVariable= new tipo ();
		
		//Identificación del jugador número 1
		Jugador jugador1=new Jugador();
		jugador1.setNombre("José Vicente");
		/*jugador1.nombre="José Vicente";****************************Este código ha sido sustituido por el 
		                                                              setNombre cuando hemos hecho que la propiedad
                                                                      nombre de la clase Jugador pase de pública a privada.
        ******************************************************************************************************/     
		jugador1.setApellidos("Pérez Girona");
		/*jugador1.apellidos="Pérez Girona";*************************Este código ha sido sustituido por el 
        															   setApellidos cuando hemos hecho que la propiedad
        															   apellidos de la clase Jugador pase de pública a privada.
        ******************************************************************************************************/
		jugador1.setEdad(39);
		/*jugador1.edad=39;******************************************Este código ha sido sustituido por el 
		                                                              setEdad cuando hemos hecho que la propiedad
		                                                              edad de la clase Jugador pase de pública a privada.
        ******************************************************************************************************/
		jugador1.setPuntos(0);
		/*jugador1.puntos=0;******************************************Este código ha sido sustituido por el 
                                                                       setPuntos cuando hemos hecho que la propiedad
                                                                       puntos de la clase Jugador pase de pública a privada.
        ******************************************************************************************************/
		
		
		//System.out.println("El jugador "+jugador1.getNombre()+" "+jugador1.getApellidos()+" tiene "+""+jugador1.getEdad()+" años y hasta ahora a conseguido "+jugador1.getPuntos()+" puntos");
				
		//System.out.println("El jugador "+textFieldNombre.getText()+" "+textFieldApellidos.getText()+" tiene "+""+jugador1.getEdad()+" años y hasta ahora a conseguido "+jugador1.getPuntos()+" puntos");
		
		//Creamos un nuevo jugador:
		playerOne=new Jugador();
		

		
		
	}
}