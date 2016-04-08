package Ventanas;

import Juego.Jugador;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Juego extends JFrame {

	private JPanel contentPane;
	private JLabel labelJuego;
	private JButton botonSuma;
	private JButton botonResta;
	private JTextField cajaNumeros;
	private JButton botonMathdice;
	private JTextField cajaResultado;
	private JTextField cajaMensaje;
	private JButton botonRepetir;
	
	private JLabel dado1,dado2;
	private JLabel[] dadoNum3=new JLabel[2];

	private JLabel dado3,dado4,dado5;
	
	private JLabel dado6;
	
	//CREO ARRAYS DE IMAGENES. Defino los arrays del objeto ImageIcon (los arrays, de momento, están vacios):
	
	private ImageIcon[] dados3=new ImageIcon[3];   //Array para almacenar los posibles valores de los dos dados del 1 al 3
	private ImageIcon[] dados6=new ImageIcon[6];   //Array para almacenar los posibles valores de los tres dados del 1 al 6
	private ImageIcon[] dados12=new ImageIcon[12]; //Array para almacenar los posibles valores del dado del 1 al 12
	
	

	//Creo un generador de imágenes aleatorias con la Clase Random:
	
	private Random dadosGenerador=new Random();
	
	//Defino una serie de variables para almacenar el valor de los dados que posteriormente se generarán aleatoriamente a partir de la Clase Random:
	
	int numDados3; //almacenará valores del 1 al 3
	int numDados6; //almacenará valores del 1 al 6
	int numDados12; //almacenará valores del 1 al 12
	
	//Defino una serie de variables para almacenar el valor numérico de los dados, generado aleatoriamente, en un String y poder 
	//insertarlo previamente en la JTextField cajaNumeros:
	
	String aleatorio1Txt;
	String aleatorio2Txt;
	String aleatorio3Txt;
	String aleatorio4Txt;
	String aleatorio5Txt;
	String [] aleatorioTxt  = new String [5];
	
	//Variables para almacenar los números aleatorios anteriores en forma numérica:
	
	int numAleatorioDado1;
	int numAleatorioDado2;
	int numAleatorioDado3;
	int numAleatorioDado4;
	int numAleatorioDado5;

	
	String cajaNumerosTxt="";
	
	String signoSuma="+";
	String signoResta="-";
	
	ImageIcon imagenAnimada = new ImageIcon(getClass().getResource("img/Chuck_Norris_animado.gif"));

	//Diferentes variables que nos permiten el control de la app:
	
	private boolean existeNumero=true;
	private int operacion=0;
	private int numerosIntroducidos=0;
	private boolean esSuma=true;
	
	/* **************ESTO NO ME FUNCIONA ¿PORQUÉ?***************************
	String [] aleatorioTxt  = new String [4];
	aleatorioTxt [0] = "aleatorioTxt1";
	aleatorioTxt [1] = "aleatorioTxt2";
	aleatorioTxt [2] = "aleatorioTxt3";
	aleatorioTxt [3] = "aleatorioTxt4";
	**************************************************************************/
	
	//String [] aleatorioTxt  = {"aleatorioTxt1","aleatorioTxt2","aleatorioTxt3","aleatorioTxt4"};
	


	
	/**
	 * Creo una referencia directa al jugador para que esta segunda ventana (Juego)pueda acceder directamente a 
	 * los datos del jugador que se se encuentran en la Clase Jugador.
	 */
	private Jugador playerOne; //Esto no es un objeto, es simplemente, una referencia a la clase Jugador. 

	                           //Así, playerOne es la etiqueta que hace referencia al objeto Jugador que he creado
	                           //previamente en la primera ventana (Login) para obtener los datos de la Clase Jugador.
	                           //Hay que decir que a la etiqueta puedo llamarle como yo quiera. En este caso le he llamado 
	                           //igual que al objeto playerOne creado en la ventana Login, pero le podría haber llamado de
	                           //otra forma.
	
	public Juego(Jugador player) {
		
		
		setTitle("JUEGO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1239, 1092);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		labelJuego = new JLabel("Bienvenido");
		labelJuego.setFont(new Font("Tahoma", Font.BOLD, 18));
		labelJuego.setHorizontalAlignment(SwingConstants.CENTER);
		labelJuego.setBounds(873, 35, 336, 44);
		contentPane.add(labelJuego);
		/**
		 * Ahora accedo al nombre del jugador desde DENTRO DE LA CONSTRUCTOR de la clase Juego.
		 * 
		 */
		this.playerOne = player;
		labelJuego.setText("Bienvenido al juego "+playerOne.getNombre());
		
		//CARGAMOS TODAS LAS IMÁGENES EN CADA UNO DE LOS TRES ARRAYS (es decir, los arrays que antes estaban vacíos ahora los lleno de contenido):
		
		//Array dados3 con 3 elementos:
		for(int i=0;i<dados3.length;i++){
			dados3[i]=new ImageIcon(getClass().getResource("img/Dados3_"+String.valueOf(i+1)+".png"));
			System.out.println("img/Dados3_"+String.valueOf(i+1)+".png");//con esto, listo los arrays para comprobar su contenido
		}
		
		//Array dados6 con 6 elementos:
		for(int i=0;i<dados6.length;i++){
			dados6[i]=new ImageIcon(getClass().getResource("img/Dados6_"+String.valueOf(i+1)+".png"));
			System.out.println("img/Dados6_"+String.valueOf(i+1)+".png");//con esto, listo los arrays para comprobar su contenido
		}
		
		//Array dados12 con 12 elementos:
		for(int i=0;i<dados12.length;i++){
			dados12[i]=new ImageIcon(getClass().getResource("img/Dados12_"+String.valueOf(i+1)+".png"));
			System.out.println("img/Dados12_"+String.valueOf(i+1)+".png");//con esto, listo los arrays para comprobar su contenido
		}

		
		//CAJAS PARA INSERTAR LAS IMÁGENES DE LOS DADOS
		
		//Caja para el primer dado del 1 al 3
		dadoNum3[0] = new JLabel();
		dadoNum3[0].setBounds(12, 48, 256, 256);
		contentPane.add(dadoNum3[0]);
		
		//Caja para el segundo dado del 1 al 3
		dadoNum3[1] = new JLabel();
		dadoNum3[1].setBounds(292, 48, 256, 256);
		contentPane.add(dadoNum3[1]);
		
		
		//Caja para el primer dado del 1 al 6
		dado3 = new JLabel();
		dado3.setBounds(12, 332, 256, 256);
		contentPane.add(dado3);
		
		//Caja para el segundo dado del 1 al 6
		dado4 = new JLabel();
		dado4.setBounds(292, 332, 256, 256);
		contentPane.add(dado4);
		
		//Caja para el tercer dado del 1 al 6
		dado5 = new JLabel();
		dado5.setBounds(578, 332, 256, 256);
		contentPane.add(dado5);
		
		//Caja para el dado del 1 al 12
		dado6 = new JLabel();
		dado6.setBounds(12, 611, 256, 256);
		contentPane.add(dado6);
		
		/*
		 * CAJAS Y BOTONES PARA PODER JUGAR
		 */
		
		//Botón para poder sumar
		botonSuma = new JButton("+");
		botonSuma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(!existeNumero){
					if(cajaNumeros.getText().length()<9){
						cajaNumeros.setText(cajaNumeros.getText()+"+");	
					}
					existeNumero=true;
					esSuma=true;
				}

			}
		});
		botonSuma.setFont(new Font("Tahoma", Font.PLAIN, 36));
		botonSuma.setBounds(904, 107, 122, 44);
		contentPane.add(botonSuma);
		
		//Botón para poder restar
		botonResta = new JButton("-");
		botonResta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!existeNumero){
					if(cajaNumeros.getText().length()<9){
						cajaNumeros.setText(cajaNumeros.getText()+"-");
					}
					existeNumero=true;
					esSuma=false;
				}

			}
		});
		botonResta.setFont(new Font("Tahoma", Font.PLAIN, 36));
		botonResta.setBounds(1063, 107, 122, 44);
		contentPane.add(botonResta);
		
		//Caja para poder insertar los números de los dados y las opciones de suma y resta
		cajaNumeros = new JTextField();
		cajaNumeros.setFont(new Font("Tahoma", Font.PLAIN, 30));
		cajaNumeros.setBounds(873, 200, 336, 52);
		contentPane.add(cajaNumeros);
		cajaNumeros.setColumns(10);
		
		//Botón para jugar
		botonMathdice = new JButton("MATHDICE");
		botonMathdice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(numerosIntroducidos>1){
					cajaResultado.setText("Tu operación es " + String.valueOf(operacion));
					//botonRepetir.setEnabled(true);
					if(numDados12==operacion){
						cajaMensaje.setText("CORRECTO!");
					}else{
						cajaMensaje.setText("INTÉNTALO DE NUEVO!");	
					}
				}

			}
		});
		botonMathdice.setFont(new Font("Tahoma", Font.PLAIN, 36));
		botonMathdice.setBounds(882, 305, 327, 44);
		contentPane.add(botonMathdice);
		
		//Caja para mostrar el total obtenido
		cajaResultado = new JTextField();
		cajaResultado.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		cajaResultado.setBounds(882, 386, 327, 52);
		contentPane.add(cajaResultado);
		cajaResultado.setColumns(10);
		
		//Caja para mostrar el mensaje de acierto o fallo
		cajaMensaje = new JTextField();
		cajaMensaje.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		cajaMensaje.setBounds(882, 465, 327, 52);
		contentPane.add(cajaMensaje);
		cajaMensaje.setColumns(10);
		
		
		//Botón para poder repetir el juego
		botonRepetir = new JButton("REPETIR JUEGO");
		botonRepetir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inicializarBotones();
				//botonRepetir.setEnabled(false);
			}
		});
		botonRepetir.setFont(new Font("Tahoma", Font.PLAIN, 36));
		botonRepetir.setBounds(882, 548, 327, 52);
		contentPane.add(botonRepetir);
		
		



		
		inicializarBotones();
	}
	

	private void inicializarBotones(){
		
	//***********************************************************************************************************************************************
		//CARGAMOS TODAS LAS IMÁGENES EN CADA UNO DE LOS TRES ARRAYS (es decir, los arrays que antes estaban vacíos ahora los lleno de contenido):
		
		//Array dados3 con 3 elementos:
		for(int i=0;i<dados3.length;i++){
			dados3[i]=new ImageIcon(getClass().getResource("img/Dados3_"+String.valueOf(i+1)+".png"));
			System.out.println("img/Dados3_"+String.valueOf(i+1)+".png");//con esto, listo los arrays para comprobar su contenido
			try{
				numDados3=dadosGenerador.nextInt(3)+1; //la variable numDados3 almacenará un valor aleatorio entre 1 y 3
				aleatorioTxt[i]=String.valueOf(numDados3);                                  //String para que pueda introducirse dentro del JTextLabel cajaNumeros

				ImageIcon imagenAleatoria1=dados3[numDados3-1];//ImageIcon imagenAleatoria1=dados3[dadosGenerador.nextInt(3)];
				dadoNum3[i].setIcon(imagenAleatoria1);
				dadoNum3[i].setName(String.valueOf(i));
				System.out.println(numDados3);//Comprobación de que el valor del dado coincide con el número aleatorio generado
				
				//AÑADO UN AddMouseListener al JLabel dado1
				

				dadoNum3[i].addMouseListener(new miBotonImagen());
				
			}catch(Exception e){
				System.out.println("No se encuentra la imagen");
				e.printStackTrace(); //Método que hace que se muestre el error (si se produce) y que, además, el programa siga ejecutándose.
			}
		}
				
		//Array dados6 con 6 elementos:
		for(int i=0;i<dados6.length;i++){
			dados6[i]=new ImageIcon(getClass().getResource("img/Dados6_"+String.valueOf(i+1)+".png"));
			System.out.println("img/Dados6_"+String.valueOf(i+1)+".png");//con esto, listo los arrays para comprobar su contenido
			}
				
		//Array dados12 con 12 elementos:
		for(int i=0;i<dados12.length;i++){
			dados12[i]=new ImageIcon(getClass().getResource("img/Dados12_"+String.valueOf(i+1)+".png"));
			System.out.println("img/Dados12_"+String.valueOf(i+1)+".png");//con esto, listo los arrays para comprobar su contenido
			}
				
			
	//*************************************************************************************************************************************************
		//CAJAS PARA INSERTAR LAS IMÁGENES DE LOS DADOS
		
				//Caja para el primer dado del 1 al 3


				
				//Caja para el primer dado del 1 al 6
				try{
					numDados6=dadosGenerador.nextInt(6)+1;
					aleatorio3Txt=String.valueOf(numDados6); //la variable aleatorio3Txt recoge el valor numérico de la variable numDados6 y la transforma en un
		                                                     //String para que pueda introducirse dentro del JTextLabel cajaNumeros
					//transformo en un número la cadena de texto aleatorio3Txt
					numAleatorioDado3=Integer.valueOf(aleatorio3Txt);
					ImageIcon imagenAleatoria4=dados6[numDados6-1];//ImageIcon imagenAleatoria4=dados6[dadosGenerador.nextInt(6)];
					dado3.setIcon(imagenAleatoria4);
					
					//AÑADO UN AddMouseListener al JLabel dado3
					
					dado3.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent arg0) {
									//cajaNumerosTxt=cajaNumerosTxt+aleatorio3Txt;
									//cajaNumeros.setText(cajaNumerosTxt);
									if(existeNumero){
									dado3.setIcon(imagenAnimada);
									cajaNumeros.setText(cajaNumeros.getText()+aleatorio3Txt);
									dado3.removeMouseListener(this); //método para eliminar el MouseListener y que el JLabel no haga nada la segunda vez que
		                                                             //se haga click sobre el
									//dado3.setEnabled(false); **este método es otra opción al removeMouseListener
									existeNumero=false;
									System.out.println(existeNumero);
									setOperacion(numAleatorioDado3);
									}
								}
							}
					);

				
					}catch(Exception e){
						System.out.println("No se encuentra la imagen");
						e.printStackTrace();//Método que hace que se muestre el error (si se produce) y que, además, el programa siga ejecutándose.
					}
				
				//Caja para el segundo dado del 1 al 6
				try{
					numDados6=dadosGenerador.nextInt(6)+1;
					aleatorio4Txt=String.valueOf(numDados6); //la variable aleatorio4Txt recoge el valor numérico de la variable numDados6 y la transforma en un
		                                                     //String para que pueda introducirse dentro del JTextLabel cajaNumeros
					//transformo en un número la cadena de texto aleatorio4Txt
					numAleatorioDado4=Integer.valueOf(aleatorio4Txt);
					ImageIcon imagenAleatoria5=dados6[numDados6-1];//ImageIcon imagenAleatoria5=dados6[dadosGenerador.nextInt(6)];
					dado4.setIcon(imagenAleatoria5);
					
					//AÑADO UN AddMouseListener al JLabel dado4
					
					dado4.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent arg0) {
									//cajaNumerosTxt=cajaNumerosTxt+aleatorio4Txt;
									//cajaNumeros.setText(cajaNumerosTxt);
									if(existeNumero){
									dado4.setIcon(imagenAnimada);
									cajaNumeros.setText(cajaNumeros.getText()+aleatorio4Txt);
									dado4.removeMouseListener(this); //método para eliminar el MouseListener y que el JLabel no haga nada la segunda vez que
		                                                             //se haga click sobre el
									//dado4.setEnabled(false); **este método es otra opción al removeMouseListener
									existeNumero=false;
									System.out.println(existeNumero);
									setOperacion(numAleatorioDado4);
									}
								}
							}
					);

					
					}catch(Exception e){
						System.out.println("No se encuentra la imagen");
						e.printStackTrace();//Método que hace que se muestre el error (si se produce) y que, además, el programa siga ejecutándose.
					}
				
				//Caja para el tercer dado del 1 al 6
				try{
					numDados6=dadosGenerador.nextInt(6)+1;
					aleatorio5Txt=String.valueOf(numDados6); //la variable aleatorio5Txt recoge el valor numérico de la variable numDados6 y la transforma en un
		                                                     //String para que pueda introducirse dentro del JTextLabel cajaNumeros
					//transformo en un número la cadena de texto aleatorio5Txt
					numAleatorioDado5=Integer.valueOf(aleatorio5Txt);
					ImageIcon imagenAleatoria3=dados6[numDados6-1];//ImageIcon imagenAleatoria3=dados6[dadosGenerador.nextInt(6)];
					dado5.setIcon(imagenAleatoria3);
					
					//AÑADO UN AddMouseListener al JLabel dado4
					
					dado5.addMouseListener(new MouseAdapter() {
								@Override
								public void mouseClicked(MouseEvent arg0) {
									//cajaNumerosTxt=cajaNumerosTxt+aleatorio5Txt;
									//cajaNumeros.setText(cajaNumerosTxt);
									if(existeNumero){
									dado5.setIcon(imagenAnimada);
									cajaNumeros.setText(cajaNumeros.getText()+aleatorio5Txt);
									dado5.removeMouseListener(this); //método para eliminar el MouseListener y que el JLabel no haga nada la segunda vez que
									                                 //se haga click sobre el
									//dado5.setEnabled(false); **este método es otra opción al removeMouseListener
									existeNumero=false;
									System.out.println(existeNumero);
									setOperacion(numAleatorioDado5);
									}
								}
							}
					);
					
					
				}catch(Exception e){
					System.out.println("No se encuentra la imagen");
					e.printStackTrace();//Método que hace que se muestre el error (si se produce) y que, además, el programa siga ejecutándose.
				}
				
				//Caja para el dado del 1 al 12
				try{
					numDados12=dadosGenerador.nextInt(12)+1;
					ImageIcon imagenAleatoria6=dados12[numDados12-1];//ImageIcon imagenAleatoria6=dados12[dadosGenerador.nextInt(12)];
					dado6.setIcon(imagenAleatoria6);
					//ImageIcon dados12=new ImageIcon(getClass().getResource("img/Dados12_14.png"));//********COMPROBACIÓN MÉTODO e.printStackTrace()
					//dado6.setIcon(dados12);	//************************************************************COMPROBACIÓN MÉTODO e.printStackTrace()
					
					
					
					}catch(Exception e){
						System.out.println("No se encuentra la imagen");
						e.printStackTrace();//Método que hace que se muestre el error (si se produce) y que, además, el programa siga ejecutándose.
					}

		//**********************************************************************************************************************************************		
		
			//RESETEO DE CAJAS:
				
			cajaNumeros.setText("");
			cajaResultado.setText("");
			cajaMensaje.setText("");
			
		//**********************************************************************************************************************************************
			
			//RESETEO DE SEMÁFOROS Y VALORES:
			
			existeNumero=true;
			operacion=0;
			numerosIntroducidos=0;
			esSuma=true;
			
			
	}
	
	private void setOperacion(int num){
		numerosIntroducidos++;
		if (numerosIntroducidos>1){
			if(esSuma)operacion=operacion+num;
			else operacion=operacion-num;
		}else{
			operacion=num;
		}
	}

	
	/**
	 * Creamos un método Setter al que llamamos setJugador.
	 * Se trata de un método Setter de todo un objeto: 
	 */
	// público: porque es accesible desde fuera de la clase
	// void: porque no saca nada
	//setJugador: el nombre que le damos al método
	//(Jugador player): el tipo de datos que le van a entrar al método, es decir, en este caso todos las variables definidas en la Clase Jugador
	//this.playerOne=player: lo que se va a modificar. En este caso, las variables del objeto Jugador playerOne
	/**
	 * Una vez he creado el método para acceder al objeto playerOne de la clase Jugador, tengo 2 opciones:
	 * Opción 1. Acceder al jugador desde fuera del constructor de la clase Juego
	 * Opción 2. Acceder al jugador desde dentro del constructor de la clase Juego
	 */
	
	public void setJugador (Jugador player){
		this.playerOne = player;
		/**
		 * Ahora accedo al nombre del jugador desde FUERA DE LA CONSTRUCTOR de la clase Juego.
		 */
		labelJuego.setText("Bienvenido al juego "+playerOne.getNombre());
	}
	
	
	
	

private class miBotonImagen implements MouseListener {

			public void mousePressed(MouseEvent evt) {}
			public void mouseClicked(MouseEvent evt) { 
				JLabel botonReferencia=(JLabel)evt.getSource();
				if(existeNumero){
					String numeroDadoTxt=botonReferencia.getName();
					int numeroDado=Integer.valueOf(numeroDadoTxt);
					botonReferencia.setIcon(imagenAnimada);
					cajaNumeros.setText(cajaNumeros.getText()+aleatorioTxt[numeroDado]);
					botonReferencia.removeMouseListener(this); //método para eliminar el MouseListener y que el JLabel no haga nada la segunda vez que
                                                     //se haga click sobre el. También podría utilizarse: dado1.setEnabled(false);
					existeNumero=false;
					System.out.println(existeNumero);
					setOperacion(numAleatorioDado1);
				}
			}
			public void mouseReleased(MouseEvent evt) { }
			public void mouseEntered(MouseEvent evt) { }
			public void mouseExited(MouseEvent evt) { }

}


	
}