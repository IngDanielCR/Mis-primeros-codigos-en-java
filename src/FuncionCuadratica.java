import javax.swing.JOptionPane;


public class FuncionCuadratica {


			/*************************************************************************************
			 * Universidad Jorge Tadeo Lozano                                                    *
			 * Departamento de Ingenier�a                                                        *
			 * Proyecto : Pensamiento Computacional aplicado al aprendizaje de las matem�ticas   *
			 * Autor : Nelson S�nchez S�nchez   2015                                             *
			 * Fecha : Octubre de 2015                                                                           *
			 *************************************************************************************/

			/***********************************************************************
			 *  Variables globales que se pueden usar dentro de CUALQUIER m�todo   *
			 ***********************************************************************/
			public static double a;
			public static double b;
			public static double c;

			public static boolean ingresoFuncion = false;

			/*********************************
			 * Tipos de mensajes a mostrar   *
			 *********************************/
			public static int tipoMensaje1 = JOptionPane.ERROR_MESSAGE;
			public static int tipoMensaje2 = JOptionPane.INFORMATION_MESSAGE;
			public static int tipoMensaje3 = JOptionPane.WARNING_MESSAGE;
			public static int tipoMensaje4 = JOptionPane.QUESTION_MESSAGE;
			public static int tipoMensaje5 = JOptionPane.PLAIN_MESSAGE;

			/********************************************** 
			 * Metodos                                    * 
			 **********************************************/ 

			public static void main(String[] args) {

				/****************************************
				 * Definir el t�tulo de la aplicaci�n   *
				 ****************************************/
				String tituloDelMenu="Pensamiento Matem�tico      -      Por Nelson S�nchez S�nchez";
				/*******************************************************************************************
				 * Definir e inicializar una variable donde se almacenar� la opci�n elegida por el usuario *
				 *******************************************************************************************/
				int opcionElegida = 0; // Inicializar con un valor CERO
				/************************************************************** 
				 * Crear una variable donde se coloquen las opciones del men� *
				 **************************************************************/
				String opcionesDelMenu="-----------------------------------------------------------------------------------------\n";
				opcionesDelMenu+="Funciones Cuadr�ticas\n";
				opcionesDelMenu+="-----------------------------------------------------------------------------------------\n";
				opcionesDelMenu+="  1. Ingresar coeficientes de la funci�n cuadr�tica\n";
				opcionesDelMenu+="  2. Determinar la concavidad de la funci�n cuadr�tica\n";
				opcionesDelMenu+="  3. Calcular el v�rtice de la funci�n cuadr�tica\n";
				opcionesDelMenu+="  4. Calcular el eje de simetr�a de la funci�n cuadr�tica\n";
				opcionesDelMenu+="  5. Calcular el m�nimo o el m�ximo de la funci�n cuadr�tica\n";
				opcionesDelMenu+="  6. Encontrar las raices de la funci�n cuadr�tica\n";
				opcionesDelMenu+=" 10. Salir del programa\n";
				opcionesDelMenu+="-----------------------------------------------------------------------------------------\n";
				opcionesDelMenu+=" � Digite la opci�n deseada ?\n";
				opcionesDelMenu+="-----------------------------------------------------------------------------------------\n";

				/******************************************************************
				 * Mostrar el menu de opciones mientras el usuario no elija salir *
				 ******************************************************************/
				while (opcionElegida!=10){
					/**********************************************************
					 * Solicitar el usuario la tarea a realizar               *
					 **********************************************************/
					opcionElegida = Integer.parseInt(JOptionPane.showInputDialog(null,opcionesDelMenu,tituloDelMenu,tipoMensaje4));

					/***********************************************
					 *  Determinar qu� opci�n elig�o el usuario    *
					 *  y realizar la tarea asociada con la opci�n *
					 ***********************************************/
					switch (opcionElegida){
					case 1:
						tarea1();
						break;
					case 2:
						tarea2();
						break;
					case 3:
						tarea3();
						break;
					case 4:
						tarea4();
						break;
					case 5:
						tarea5();
						break;
					case 6:
						tarea6();
						break;
					}// Cierra el switch

				}// Cierra el while

			}// Cierra el metodo main

			public static void tarea1(){
				a = Double.parseDouble(JOptionPane.showInputDialog("�Ingrese el valor de a ?")); // Se convierte el valor de a a double
				b = Double.parseDouble(JOptionPane.showInputDialog("�Ingrese el valor de b ?")); // Se convierte el valor de b  a double
				c = Double.parseDouble(JOptionPane.showInputDialog("�Ingrese el valor de c ?")); // Se convierte el dato ingresado a double
				String tituloVentana="Funci�n cuadr�tica ingresada";
				String mensaje=a+" x� + "+ b + " x + "+ c;
				JOptionPane.showMessageDialog(null,mensaje,tituloVentana,tipoMensaje2);
				ingresoFuncion=true;
			}
			public static void tarea2(){
				if (!ingresoFuncion){
					JOptionPane.showMessageDialog(null,"A�n no ha ingresado los valores de la funci�n cuadr�tica");
				}
				else {
					if (a>0){
						JOptionPane.showMessageDialog(null,"La funci�n es c�ncava hacia arr�ba");
					}
					else {
						JOptionPane.showMessageDialog(null,"La funci�n es c�ncava hacia abajo");
					}
				}
			}
			public static void tarea3(){
				double h = -b/(2*a);
				double k = (4*a*c-b*b)/(4*a);
				String mensaje = "El vertice de la funci�n cuadratica "+a+" x� + "+ b + " x + "+ c+" se encuentra en el punto V( "+h+" , "+k+" )";
				JOptionPane.showMessageDialog(null, mensaje, "Vertice de la Funci�n Cuadr�tica ", tipoMensaje2);
			}

			public static void tarea4(){
				double rectaX = -b / (2*a);
				String mensaje = "El eje de simetr�a de la funci�n cuadratica "+a+" x� + "+ b + " x + "+ c+" es la recta x = "+rectaX;
				JOptionPane.showMessageDialog(null, mensaje, "Eje de Simetr�a de la Funci�n Cuadr�tica ", tipoMensaje2);
			}
			public static void tarea5(){
				double h = -b/(2*a);
				double k = (4*a*c-b*b)/(4*a);
				String mensaje="";
				if (a>0){
					mensaje = "La funci�n cuadratica "+a+" x� + "+ b + " x + "+ c+" tiene un m�nimo en el punto V( "+h+" , "+k+" )";
					JOptionPane.showMessageDialog(null,mensaje, "M�ximo y m�nimo de la funci�n cuadr�tica",tipoMensaje2);
				}
				else {
					mensaje = "La funci�n cuadratica "+a+" x� + "+ b + " x + "+ c+" tiene un m�ximo en el punto V( "+h+" , "+k+" )";
					JOptionPane.showMessageDialog(null,mensaje, "M�ximo y m�nimo de la funci�n cuadr�tica",tipoMensaje2);
				}
			}
			public static void tarea6(){
				// Definir variables 
				double x1; // Almacena la primera ra�z
				double x2; // Almacena la segunda ra�z
				String mensaje = "";
				double discriminante = b*b-4*a*c;
				if (discriminante<0){
					// La soluci�n est� en los n�meros complejos
					mensaje = "La funci�n cuadr�tica NO tiene soluci�n en los n�meros reales";
					JOptionPane.showMessageDialog(null, mensaje);
				} else if (discriminante==0){
					// La funci�n tiene una sola ra�z
					x1= -b/(2*a);
					mensaje = "La funci�n cuadr�tica tiene una sola ra�z en x="+x1;
					JOptionPane.showMessageDialog(null,mensaje,"Raices de la funci�n cuadr�tica",tipoMensaje2);
				} else {
					// La funci�n tiene dos raices
					x1 = (-b+Math.sqrt(discriminante))/(2*a);
					x2 = (-b-Math.sqrt(discriminante))/(2*a);
					mensaje = "La funci�n cuadr�tica tiene dos raices: una en x1="+x1+" y otra en x2="+x2;
					JOptionPane.showMessageDialog(null,mensaje,"Raices de la funci�n cuadr�tica",tipoMensaje2);
				}
			}

		
		
		
}
