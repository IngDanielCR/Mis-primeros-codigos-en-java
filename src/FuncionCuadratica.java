import javax.swing.JOptionPane;


public class FuncionCuadratica {


			/*************************************************************************************
			 * Universidad Jorge Tadeo Lozano                                                    *
			 * Departamento de Ingeniería                                                        *
			 * Proyecto : Pensamiento Computacional aplicado al aprendizaje de las matemáticas   *
			 * Autor : Nelson Sánchez Sánchez   2015                                             *
			 * Fecha : Octubre de 2015                                                                           *
			 *************************************************************************************/

			/***********************************************************************
			 *  Variables globales que se pueden usar dentro de CUALQUIER método   *
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
				 * Definir el título de la aplicación   *
				 ****************************************/
				String tituloDelMenu="Pensamiento Matemático      -      Por Nelson Sánchez Sánchez";
				/*******************************************************************************************
				 * Definir e inicializar una variable donde se almacenará la opción elegida por el usuario *
				 *******************************************************************************************/
				int opcionElegida = 0; // Inicializar con un valor CERO
				/************************************************************** 
				 * Crear una variable donde se coloquen las opciones del menú *
				 **************************************************************/
				String opcionesDelMenu="-----------------------------------------------------------------------------------------\n";
				opcionesDelMenu+="Funciones Cuadráticas\n";
				opcionesDelMenu+="-----------------------------------------------------------------------------------------\n";
				opcionesDelMenu+="  1. Ingresar coeficientes de la función cuadrática\n";
				opcionesDelMenu+="  2. Determinar la concavidad de la función cuadrática\n";
				opcionesDelMenu+="  3. Calcular el vértice de la función cuadrática\n";
				opcionesDelMenu+="  4. Calcular el eje de simetría de la función cuadrática\n";
				opcionesDelMenu+="  5. Calcular el mínimo o el máximo de la función cuadrática\n";
				opcionesDelMenu+="  6. Encontrar las raices de la función cuadrática\n";
				opcionesDelMenu+=" 10. Salir del programa\n";
				opcionesDelMenu+="-----------------------------------------------------------------------------------------\n";
				opcionesDelMenu+=" ¿ Digite la opción deseada ?\n";
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
					 *  Determinar qué opción eligío el usuario    *
					 *  y realizar la tarea asociada con la opción *
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
				a = Double.parseDouble(JOptionPane.showInputDialog("¿Ingrese el valor de a ?")); // Se convierte el valor de a a double
				b = Double.parseDouble(JOptionPane.showInputDialog("¿Ingrese el valor de b ?")); // Se convierte el valor de b  a double
				c = Double.parseDouble(JOptionPane.showInputDialog("¿Ingrese el valor de c ?")); // Se convierte el dato ingresado a double
				String tituloVentana="Función cuadrática ingresada";
				String mensaje=a+" x² + "+ b + " x + "+ c;
				JOptionPane.showMessageDialog(null,mensaje,tituloVentana,tipoMensaje2);
				ingresoFuncion=true;
			}
			public static void tarea2(){
				if (!ingresoFuncion){
					JOptionPane.showMessageDialog(null,"Aún no ha ingresado los valores de la función cuadrática");
				}
				else {
					if (a>0){
						JOptionPane.showMessageDialog(null,"La función es cóncava hacia arríba");
					}
					else {
						JOptionPane.showMessageDialog(null,"La función es cóncava hacia abajo");
					}
				}
			}
			public static void tarea3(){
				double h = -b/(2*a);
				double k = (4*a*c-b*b)/(4*a);
				String mensaje = "El vertice de la función cuadratica "+a+" x² + "+ b + " x + "+ c+" se encuentra en el punto V( "+h+" , "+k+" )";
				JOptionPane.showMessageDialog(null, mensaje, "Vertice de la Función Cuadrática ", tipoMensaje2);
			}

			public static void tarea4(){
				double rectaX = -b / (2*a);
				String mensaje = "El eje de simetría de la función cuadratica "+a+" x² + "+ b + " x + "+ c+" es la recta x = "+rectaX;
				JOptionPane.showMessageDialog(null, mensaje, "Eje de Simetría de la Función Cuadrática ", tipoMensaje2);
			}
			public static void tarea5(){
				double h = -b/(2*a);
				double k = (4*a*c-b*b)/(4*a);
				String mensaje="";
				if (a>0){
					mensaje = "La función cuadratica "+a+" x² + "+ b + " x + "+ c+" tiene un mínimo en el punto V( "+h+" , "+k+" )";
					JOptionPane.showMessageDialog(null,mensaje, "Máximo y mínimo de la función cuadrática",tipoMensaje2);
				}
				else {
					mensaje = "La función cuadratica "+a+" x² + "+ b + " x + "+ c+" tiene un máximo en el punto V( "+h+" , "+k+" )";
					JOptionPane.showMessageDialog(null,mensaje, "Máximo y mínimo de la función cuadrática",tipoMensaje2);
				}
			}
			public static void tarea6(){
				// Definir variables 
				double x1; // Almacena la primera raíz
				double x2; // Almacena la segunda raíz
				String mensaje = "";
				double discriminante = b*b-4*a*c;
				if (discriminante<0){
					// La solución está en los números complejos
					mensaje = "La función cuadrática NO tiene solución en los números reales";
					JOptionPane.showMessageDialog(null, mensaje);
				} else if (discriminante==0){
					// La función tiene una sola raíz
					x1= -b/(2*a);
					mensaje = "La función cuadrática tiene una sola raíz en x="+x1;
					JOptionPane.showMessageDialog(null,mensaje,"Raices de la función cuadrática",tipoMensaje2);
				} else {
					// La función tiene dos raices
					x1 = (-b+Math.sqrt(discriminante))/(2*a);
					x2 = (-b-Math.sqrt(discriminante))/(2*a);
					mensaje = "La función cuadrática tiene dos raices: una en x1="+x1+" y otra en x2="+x2;
					JOptionPane.showMessageDialog(null,mensaje,"Raices de la función cuadrática",tipoMensaje2);
				}
			}

		
		
		
}
