import javax.swing.JOptionPane;

public class TablaSicrometria {

	public static int tipoMensaje1 = JOptionPane.ERROR_MESSAGE;// mensaje de
																// error
	public static int tipoMensaje2 = JOptionPane.INFORMATION_MESSAGE;
	public static int tipoMensaje3 = JOptionPane.WARNING_MESSAGE;
	public static int tipoMensaje4 = JOptionPane.QUESTION_MESSAGE;
	public static int tipoMensaje5 = JOptionPane.PLAIN_MESSAGE;
	/**
	 * Class Tabla Sicrometrica
	 * 
	 * @author Daniel Cuadrado
	 * @author Yesika Garcï¿½a Materia: Fundamentos de Programaciï¿½n Profesor:
	 *         Nelson Sanchez
	 */

	/**
	 * T: Temperatura en grados celsius TBh: Temperatura del Bulbo Humedo
	 * 
	 * @return A
	 */

	public double factorSicrometrico(double T, double TBh) {
		// solo aplica se la deshidratacion en en ambiente
		// el valor dado es adimencional
		double A = 0;
		if (T < 0) {
			A = 0.00058 * (1 + 0.00115 * TBh);
		} else if (T >= 0) {
			A = 0.00066 * (1 + 0.00115 * TBh);
		}
		return A;
	}

	/**
	 * Vaire: Velocidad del Aire T: Temperatura en grados celsius
	 * 
	 * @return A
	 */

	public double factorSicrometricoVelocidadDelAire(double Vaire, double T) {

		double A = 0;

		if (T < 0) {
			if ((Vaire >= 0) || (Vaire <= 0.5)) {
				A = 0.00106;

			} else if ((Vaire >= 1) || (Vaire <= 1.5)) {
				A = 0.00071;

			} else if ((Vaire >= 3.5) || (Vaire <= 4)) {
				A = 0.00058;

			} else if ((Vaire >= 4) || (Vaire <= 10)) {
				A = 0.00043;
			}

		} else if (T >= 0) {
			if ((Vaire >= 0) || (Vaire <= 0.5)) {
				A = 0.00120;

			} else if ((Vaire >= 1) || (Vaire <= 1.5)) {
				A = 0.00080;

			} else if ((Vaire >= 3.5) || (Vaire <= 4)) {
				A = 0.00066;

			} else if ((Vaire >= 4) || (Vaire <= 10)) {
				A = 0.00064;
			}
		}
		return A;
	}// cierre metodo factorSicrometricoVelocidadDelAire

	/**
	 * TBh: Temperatura de Bulbo Hï¿½medo PsBh: Presiï¿½n Saturada de Bulbo
	 * Huï¿½mdo
	 * 
	 * @return PsBh
	 */
	public double PresionSauradaTBh(double TBh) {
		// el valor es dato en Kpa

		double PsBh = 0;
		PsBh = Math.exp((16.461 * TBh - 114.86) / (TBh + 231.67));
		return PsBh;
	}

	/**
	 * 
	 * T: Temperatura en grados Celsius PsBs: Presiï¿½n Saturada
	 */

	public double PresionSauradaTBs(double T) {
		// el valor es dato en Kpa

		double PsBs = 0;
		PsBs = Math.exp((16.461 * T - 114.86) / (T + 231.67));
		return PsBs;
	}

	/**
	 * PsBh: Presiï¿½n Saturada de Bulbo Hï¿½medo del Alimento A: P: Presiï¿½n
	 * Ambiental en Kilopascales (Kpa) T: Temperatura en grados Celsius
	 * TBh:Temperatura de Bulbo Hï¿½medo Pv: Presiï¿½n de Vapor
	 * 
	 * @return Pv
	 */
	public double PresionDeVapor(double PsBh, double A, double P, double T, double TBh) {
		// el valor es dato en kpa

		double Pv = 0;
		Pv = PsBh - (A * P * (T - TBh));
		return Pv;
	}

	/**
	 * Pv: Presiï¿½n de Vapor PsBs: Presiï¿½n Saturada de Bulso Seco Hr: Humedad
	 * Relativa
	 * 
	 * @return Hr
	 */

	public double humedadRelativa(double Pv, double PsBs) {

		double Hr = 0;
		Hr = (Pv / PsBs) * 100; // el resultado se da en %
		return Hr;
	}

	/**
	 * Hr: Humedad Relativa T: Tempertura en grados Celsius Tr: Temperatura de
	 * Rcio
	 * 
	 * @return Tr
	 */

	public double temperaturaDeRocio(double Hr, double T) {

		double Tr = 0;
		Tr = T + 35 * Math.log10(Hr / 100);
		return Tr;

	}

	/**
	 * Pv:Presiï¿½n de Vapor T:Tempertura en grados Celsius Ha: Humedad Absoluta
	 * 
	 * @return Ha
	 */

	public double humedadAbsoluta(double Pv, double T) {

		double Ha = 0;
		Ha = 216.9 * Pv / (T + 231.67);
		return Ha;
	}

	/**
	 * Pv:Presiï¿½n de Vapor P: Presiï¿½n Ambiental en Kilopascales (Kpa) He:
	 * Humedad Especifica
	 * 
	 * @return He
	 */
	public double humedadEspecifica(double Pv, double P) {

		double He = 0;
		He = 0.622 * Pv / (P - 0.378 * Pv)*100;
		return He;
	}

	/**
	 * Pv:Presiï¿½n de Vapor P:Presiï¿½n Ambiental en Kilopascales (Kpa) W:
	 * relacion de Mezcla
	 * 
	 * @returnW
	 */

	public double relacionDeMezcla(double Pv, double P) {

		double W = 0;
		W = (0.62198 * ((Pv) / ((P) - (Pv)))) * 1000;
		return W;
	}

	public void imprimirTablaDeSicrometrica(double P, double T, double TBh) {
		double PsBh = PresionSauradaTBh(TBh);
		double PsBs = PresionSauradaTBs(T);
		double A = factorSicrometrico(T, TBh);
		double Pv = PresionDeVapor(PsBh, A, P, T, TBh);
		double Hr = humedadRelativa(Pv, PsBs);

		String tituloApp = "tabla de psicrométrica";
		String resultado = "_____________________________________________________________________\n";
		resultado += "\nPresion atmosferica                                  : " + String.format("%.4f Kpa", P);
		resultado += "\nTemperatura de bulbo seco                      : " + String.format("%.4f °C", T);
		resultado += "\nTemperatura de bulbo humedo                : " + String.format("%.4f °C", TBh);
		resultado += "\n_____________________________________________________________________";
		resultado += "\nFactor de PSICROMETRIA                           : " + factorSicrometrico(T, TBh);
		resultado += "\n_____________________________________________________________________";
		resultado += "\nPresion de saturacion a bulbo humedo : " + PresionSauradaTBh(TBh) + " Kpa";
		resultado += "\n_____________________________________________________________________";
		resultado += "\nPresion de saturacion a bulbo seco        : " + PresionSauradaTBs(T) + " Kpa";
		resultado += "\n_____________________________________________________________________";
		resultado += "\nPresion de vapor                                          : " + PresionDeVapor(T, PsBh, A, P, TBh) + " Kpa";
		resultado += "\n_____________________________________________________________________";
		resultado += "\nHumedad relativa                                          : " + humedadRelativa(Pv, PsBs) + " %";
		resultado += "\n_____________________________________________________________________";
		resultado += "\nTemperatura De Rocio                                  : " + temperaturaDeRocio(Hr, T) + " °C";
		resultado += "\n_____________________________________________________________________";
		resultado += "\nHumedad especifica                                     : " + humedadEspecifica(Pv, P) + " m^3/Kg de aire";
		resultado += "\n_____________________________________________________________________";
		/*
		resultado += "\nhumedad Absoluta " + humedadAbsoluta(Pv, T) + " Kg / m^3";
		resultado += "\n_____________________________________________________________________";
		resultado += "\nrelacion De Mezcla de gases " + relacionDeMezcla(Pv, P);
		resultado += "\n_____________________________________________________________________";
*/
		JOptionPane.showMessageDialog(null, resultado, tituloApp, JOptionPane.INFORMATION_MESSAGE);

	}

	public void imprimirSeleccionDePropiedades(double P, double T, double TBh) {

		// definir el titulo del menu

		String tituloDelMenu = "Seleccione la propiedad que desea";

		// definir la variable de seleccion
		int opcion = 0;

		// informacion del menu
		String opcionesDelMenu = "_____________________________________________________________________\n";
		opcionesDelMenu += "1. calcular factor Sicrometrico\n";
		opcionesDelMenu += "2. calcular Presion De Vapor\n";
		opcionesDelMenu += "3. calcular humedad Relativa\n";
		opcionesDelMenu += "4. calcular temperatura De Rocio\n";
		opcionesDelMenu += "5. calcular humedad Absoluta\n";
		opcionesDelMenu += "6. calcular humedad Especifica\n";
		opcionesDelMenu += "7. calcular relacion De Mezcla de gases\n";
		opcionesDelMenu += "_____________________________________________________________________\n";
		opcionesDelMenu += "Digite la opcion deseada ?\n";
		opcionesDelMenu += "_____________________________________________________________________\n";

		opcion = Integer.parseInt(JOptionPane.showInputDialog(null, opcionesDelMenu, tituloDelMenu, tipoMensaje4));

		
		
		double A = factorSicrometrico(T, TBh);
		double PsBh = PresionSauradaTBh(TBh);
		double PsBs = PresionSauradaTBs(T);
		double Pv = PresionDeVapor(PsBh, A, P, T, TBh);
		double Hr = humedadRelativa(Pv, PsBs);


		switch (opcion) {

		case 1:
			String tituloApp = "factor Sicrometric";
			String resultado = "\n" + A;
			JOptionPane.showMessageDialog(null, resultado, tituloApp, JOptionPane.INFORMATION_MESSAGE);
			break;

		case 2:
			tituloApp = "Presion De Vapor";
			resultado = "\n" + Pv + " Kpa";
			JOptionPane.showMessageDialog(null, resultado, tituloApp, JOptionPane.INFORMATION_MESSAGE);

			break;
		case 3:
			tituloApp = "humedad Relativa";
			resultado = "\n" + Hr + " %";
			JOptionPane.showMessageDialog(null, resultado, tituloApp, JOptionPane.INFORMATION_MESSAGE);
			break;
		case 4:
			tituloApp = "temperatura De Rocio";
			resultado = "\n" + temperaturaDeRocio(Hr, T) + " °C";
			JOptionPane.showMessageDialog(null, resultado, tituloApp, JOptionPane.INFORMATION_MESSAGE);

			break;
		case 5:
			tituloApp = "humedad Absoluta";
			resultado = "\n" + humedadAbsoluta(Pv, T) + " Kg / m^3";
			JOptionPane.showMessageDialog(null, resultado, tituloApp, JOptionPane.INFORMATION_MESSAGE);
			break;
		case 6:
			tituloApp = "humedad Especifica";
			resultado = "\n" + humedadEspecifica(Pv, P) + " Kg de H2O/Kg de aire";
			JOptionPane.showMessageDialog(null, resultado, tituloApp, JOptionPane.INFORMATION_MESSAGE);
			break;
		case 7:
			tituloApp = "relacion De Mezcla de gases";
			resultado = "\n" + relacionDeMezcla(Pv, P) + " Kg de H2O/Kg de aire";
			JOptionPane.showMessageDialog(null, resultado, tituloApp, JOptionPane.INFORMATION_MESSAGE);

		}
	}

	public void validadcionDelRiesgoDeCondensacion (double P, double T, double TBh) {
		double A = factorSicrometrico(T, TBh);
		double PsBh = PresionSauradaTBh(TBh);
		double PsBs = PresionSauradaTBs(T);
		double Pv = PresionDeVapor(PsBh, A, P, T, TBh);
		double Hr = humedadRelativa(Pv, PsBs);
		double Tr = temperaturaDeRocio(Hr, T);
		

			if (Hr > 70) {
				String tituloApp = "ALERTA";
				String resultado ="Para la conservación de alimentos de baja humedad y de alto riesgo microbiológico\n";
				resultado +="_____________________________________________________________________\n";
				resultado += "temperatura de rocio: " +Tr +" °C\n";
				resultado +=  "Humedad relativa "+ Hr +" % \n";
				resultado +="_____________________________________________________________________\n";
				resultado += "Hay un alto riesgo de condensación del agua en la zona.\n";
				resultado += "Se recomienda: La extracción del aire húmedo según parámetros de calidad.\n";
				resultado +="_____________________________________________________________________\n";

				JOptionPane.showMessageDialog(null, resultado, tituloApp, JOptionPane.WARNING_MESSAGE);
				
			
			} else if (Hr < 70)  {
				String tituloApp = "ALERTA";
				String resultado ="Para la conservación de alimentos de alta humedad (Humedad del 80%) \n";
				resultado +="_____________________________________________________________________\n";
				resultado += "temperatura de rocio: " +Tr +" °C\n";
				resultado +=  "Humedad relativa "+ Hr +" % \n";
				resultado +="_____________________________________________________________________\n";
				resultado += "Hay un alto riesgo de deshidratación o daño superficial en el producto.\n";
				resultado += "Se recomienda humidificar la zona según parámetros de calidad.\n";
				resultado += "O humidificar el ambiente hasta estar cercano a la humedad del producto-\n";

				resultado +="_____________________________________________________________________\n";

				JOptionPane.showMessageDialog(null, resultado, tituloApp, JOptionPane.WARNING_MESSAGE);

				
			}
	}
	
	
}// cierre programa
