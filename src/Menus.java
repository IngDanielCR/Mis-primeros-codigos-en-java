import java.util.Scanner;

import javax.swing.JOptionPane;

public class Menus {

	// Tipos de mensajes a mostrar

	public static int tipoMensaje1 = JOptionPane.ERROR_MESSAGE;// mensaje de
																// error
	public static int tipoMensaje2 = JOptionPane.INFORMATION_MESSAGE;
	public static int tipoMensaje3 = JOptionPane.WARNING_MESSAGE;
	public static int tipoMensaje4 = JOptionPane.QUESTION_MESSAGE;
	public static int tipoMensaje5 = JOptionPane.PLAIN_MESSAGE;

	public static Scanner entrada = new Scanner(System.in);

	public static void main(String[] args) {

		menu1();

	}

	public static void menu1() {

		// definir el titulo del menu
		String tituloDelMenu = "SELECCIONAR CÁLCULOS A REALIZAR";

		// definir la variable de seleccion
		int opcion = 0;

		// informacion del menu
		String opcionesDelMenu = "_____________________________________________________________________\n";
		opcionesDelMenu += "  1. Calcular las propiedades del aire o validar \n";
		opcionesDelMenu += "  2. Realizar calculos De Osmodeshidratacion\n";
		opcionesDelMenu += "_____________________________________________________________________\n";
		opcionesDelMenu += "  Digite la opcion deseada ?\n";
		opcionesDelMenu += "_____________________________________________________________________\n";

		opcion = Integer.parseInt(JOptionPane.showInputDialog(null, opcionesDelMenu, tituloDelMenu, tipoMensaje4));
		switch (opcion) {

		case 1:
			imprimirPropiedadesDelAire();
			break;
		case 2:
			menuDeOsmodeshidratacion();
			break;
		}

	}// cierre main

	public static void imprimirPropiedadesDelAire() {
		// solicitut de valores de las variables
		TablaSicrometria t1 = new TablaSicrometria();
		double P = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de la presion atmosferica"));
		double T = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de la temperatura de bulbo seco en °C"));
		double TBh = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el valor de la temperatura de bulbo humedo en °C"));

		// definir el titulo del menu
		String tituloDelMenu = "seleccion de procedimientos a realizar";

		// definir la variable de seleccion
		int opcion = 0;

		// informacion del menu
		String opcionesDelMenu = "propeidades del aire\n";
		opcionesDelMenu += "_____________________________________________________________________\n";
		opcionesDelMenu += "  1. Calcular propiedades Psicrometricas del aire\n";
		opcionesDelMenu += "  2. Calcular una varialble del aire unicamente\n";
		opcionesDelMenu += "  3. Validar el riesgo de almacenamiento.\n";
		opcionesDelMenu += "_____________________________________________________________________\n";
		opcionesDelMenu += "  Digite la opcion deseada ?\n";
		opcionesDelMenu += "_____________________________________________________________________\n";

		opcion = Integer.parseInt(JOptionPane.showInputDialog(null, opcionesDelMenu, tituloDelMenu, tipoMensaje4));

		switch (opcion) {

		case 1:

			t1.imprimirTablaDeSicrometrica(P, T, TBh);

			break;
		case 2:
			t1.imprimirSeleccionDePropiedades(P, T, TBh);
			break;
		case 3:
			t1.validadcionDelRiesgoDeCondensacion(P, T, TBh);
			break;
		}

	}

	public static void menuDeOsmodeshidratacion() {

		DeshidratacionOsmotica t2 = new DeshidratacionOsmotica();

		// definir el titulo del menu
		String tituloDelMenu = "selecccione el calculo que desea realizar de osmodeshidratacion";
		// definir la variable de seleccion
		int opcion = 0;

		// informacion del menu
		String opcionesDelMenu = "\n_____________________________________________________________________\n";
		opcionesDelMenu += "con un modelo fenomenologico\n";
		opcionesDelMenu += "_____________________________________________________________________\n";
		opcionesDelMenu += "1. Perdida de Agua\n";
		opcionesDelMenu += "2. Perdida de Peso\n";
		opcionesDelMenu += "3. Ganancia de Solidos\n";
		opcionesDelMenu += "_____________________________________________________________________\n";
		opcionesDelMenu += "  Digite la opcion deseada ?\n";
		opcionesDelMenu += "_____________________________________________________________________\n";

		opcion = Integer.parseInt(JOptionPane.showInputDialog(null, opcionesDelMenu, tituloDelMenu, tipoMensaje4));

		switch (opcion) {

		case 1:

			double MO = Double.parseDouble(JOptionPane.showInputDialog("Masa inicial de la muestra en g"));
			double MF = Double.parseDouble(JOptionPane.showInputDialog("Masa final de la muestra en g"));
			double HO = Double.parseDouble(JOptionPane.showInputDialog("Humedad inicial de la muestra en %"));
			double HF = Double.parseDouble(JOptionPane.showInputDialog("Humedad final de la muestra en %"));

			String tituloApp = "perdida De Agua";
			String resultado = "_____________________________________________________________________\n";
			resultado +=  t2.perdidaDeAgua(MO, MF, HO, HF) + "%" + "\n";
			resultado += "_____________________________________________________________________\n";

			JOptionPane.showMessageDialog(null, resultado, tituloApp, JOptionPane.INFORMATION_MESSAGE);

			if (HF > 35) {
				tituloApp = "ADVERTENCIA";
				resultado ="El producto presenta condiciones favorables para el desarrollo de microorganismos.\n";
				resultado += "Se recomienda refrigerar o disminuir el pH según parámetros de calidad.\n";
				resultado +="_____________________________________________________________________\n";

				JOptionPane.showMessageDialog(null, resultado, tituloApp, JOptionPane.WARNING_MESSAGE);
				
			}
			
			
			break;
		case 2:

			MO = Double.parseDouble(JOptionPane.showInputDialog("masa inicial de la muestra en g"));
			MF = Double.parseDouble(JOptionPane.showInputDialog("masa final de la muestra en g"));

			tituloApp = "Perdida de Peso";
			resultado = "_____________________________________________________________________\n";
			resultado += "\n" + "el % de perdidad de peso es" + t2.perdidaDePeso(MO, MF) + "%";
			resultado += "\n_____________________________________________________________________";
			JOptionPane.showMessageDialog(null, resultado, tituloApp, JOptionPane.INFORMATION_MESSAGE);

			break;
		case 3:

			MO = Double.parseDouble(JOptionPane.showInputDialog("Masa inicial de la muestra en g"));
			MF = Double.parseDouble(JOptionPane.showInputDialog("Masa final de la muestra en g"));
			double SO = Double.parseDouble(JOptionPane.showInputDialog("ºBrix iniciales de la muestra"));
			double SF = Double.parseDouble(JOptionPane.showInputDialog("ºBrix finales de la muestra"));

			tituloApp = "Ganancia de Solidos";
			resultado = "_____________________________________________________________________\n";
			resultado += "\n" + "el % de ganancia de solidos es" + t2.gananciaDeSolidos(MO, MF, SF, SO) + "%";
			resultado += "\n_____________________________________________________________________";
			JOptionPane.showMessageDialog(null, resultado, tituloApp, JOptionPane.INFORMATION_MESSAGE);
			if (SF > 75) {
				tituloApp = "ADVERTENCIA";
				resultado ="El producto presenta condiciones favorables para el desarrollo de microorganismos.\n";
				resultado += "Se recomienda refrigerar o disminuir el pH según parámetros de calidad.\n";
				resultado +="_____________________________________________________________________\n";

				JOptionPane.showMessageDialog(null, resultado, tituloApp, JOptionPane.WARNING_MESSAGE);
				
			}
			break;

		}
	}

}// cierre programa
