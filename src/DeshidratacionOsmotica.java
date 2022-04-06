
public class DeshidratacionOsmotica {

	/**
	 * @author Daniel Cuadrado
	 * @author Yesika Garcia Class Deshidratación Osmotica Método Variables del
	 *         usuario
	 */

	/**
	 * Perdida De Agua del Alimento MO:masa inicial de la muestra en g MF:masa
	 * final de la muestra en % HO:Humedad inicial de la muestra en % HF:Humedad
	 * fianal de la muestra en %
	 * 
	 * @return WL
	 */
	public double perdidaDeAgua(double MO, double MF, double HO, double HF) {

		double WL = 0;
		WL = ((MO * HO / 100) - (MF * HF / 100)) / MO * 100;
		return WL;
	}

	/**
	 * Método Perdida de Peso del Alimento MO: MF:
	 * 
	 * @return WR
	 */
	public double perdidaDePeso(double MO, double MF) {

		double WR = 0;
		WR = ((MO - MF) / MO) * 100;
		return WR;

	}

	/**
	 * Ganancia de Solidos del Alimento MO: MF: SF: SO:
	 * 
	 * @return GS
	 */

	public double gananciaDeSolidos(double MO, double MF, double SF, double SO) {

		double GS = 0;
		GS = (((MF * SF / 100) - (MO * SO / 100)) / MO) * 100;
		return GS;

	}

}// cierre programa
