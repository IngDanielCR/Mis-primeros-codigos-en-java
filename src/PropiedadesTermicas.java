import java.util.Scanner;

public class PropiedadesTermicas {

	public static Scanner entrada = new Scanner(System.in);

	public static void variablesUsuario() {
		// todos lo valores se piden sin ser multiplicados por 100

		/**
		 * @author Daniel Cuadrado
		 * @author Yesika García Class Propiedades Térmicas
		 */

		AGUA = entrada.nextDouble();
		CARBOHIDRATOS = entrada.nextDouble();
		PROTEINAS = entrada.nextDouble();
		GRASAS = entrada.nextDouble();
		CENIZAS = entrada.nextDouble();
		T = entrada.nextDouble();
	}

	public static double AGUA = 0;
	public static double CARBOHIDRATOS = 0;
	public static double PROTEINAS = 0;
	public static double GRASAS = 0;
	public static double CENIZAS = 0;
	public static double T = 0;

	/**
	 * xagua:Fracción Másica de Agua del Alimento
	 * 
	 * @param AGUA
	 * @return xagua
	 */
	public double fraccionMasicaAgua(double AGUA) {

		double xagua = 0;
		xagua = AGUA / 100;
		return xagua;
	}

	/**
	 * xcarbohidratos: Fracción Másica de Carbohidratos del Alimento
	 * CARBOHIDRATOS
	 * 
	 * @return xcarbohidratos
	 */

	public double fraccionMasicaCarbohidratos(double CARBOHIDRATOS) {
		double xcarbohidratos = 0;
		xcarbohidratos = CARBOHIDRATOS / 100;
		return xcarbohidratos;
	}

	/**
	 * xproteinas: Fracción Másica de Proteinas del Alimento PROTEINAS
	 * 
	 * @return xproteinas
	 */

	public double fraccionMasicaProteinas(double PROTEINAS) {
		double xproteinas = 0;
		xproteinas = PROTEINAS / 100;
		return xproteinas;
	}

	/**
	 * Xgrasas: Fracción Másica de Grasa del Alimento GRASAS
	 * 
	 * @return xgrasas
	 */
	public double fraccionMasicaGrasas(double GRASAS) {
		double xgrasas = 0;
		xgrasas = GRASAS / 100;
		return xgrasas;
	}

	/**
	 * xcenizas: Fracción Másica de Cenizas del Alimento CENIZAS
	 * 
	 * @return xcenizas
	 */
	public double fraccionMasicaCenizas(double CENIZAS) {
		double xcenizas = 0;
		xcenizas = CENIZAS / 100;
		return xcenizas;

	}

	// **************************************************
	// el resultado de los Cp se obtien en (J / Kg Â°C)
	// **************************************************

	/**
	 * CpAgua: Calor Especifico de Agua del Alimento
	 * 
	 * @return CpAgua
	 */
	public double CpDeAgua() {
		double CpAgua = 0;
		CpAgua = 4176.2 - 0.0909 * (T) + 0.0054731 * (T * T);
		return CpAgua;
	}

	/**
	 * CpProteinas: Calor Especifico de Carbohidratos del Alimento
	 * 
	 * @return CpCarbohidratos
	 */

	public double CpDeCarbohidratos() {
		double CpCarbohidratos = 0;
		CpCarbohidratos = 1548.8 + 1.9625 * (T) + 0.0059399 * (T * T);
		return CpCarbohidratos;
	}

	/**
	 * CpProteinas: Calor Especifico de Proteinas del Alimento
	 * 
	 * @return CpProteinas
	 */

	public double CpDeProteinas() {
		double CpProteinas = 0;
		CpProteinas = 2008.2 + 1.2089 * (T) - 0.0013129 * (T * T);
		return CpProteinas;
	}

	/**
	 * CpGrasas: Calor Especifico de Grasas del Alimento
	 * 
	 * @return CpGrasas
	 */

	public double CpDeGrasas() {
		double CpGrasas = 0;
		CpGrasas = 1984.2 + 1.4373 * (T) - 0.0048008 * (T * T);
		return CpGrasas;
	}

	/**
	 * CpCenizas: Calor Especifico de Cenizas del Alimento
	 * 
	 * @return CpCenizas
	 */
	public double CpDeCenizas() {
		double CpCenizas = 0;
		CpCenizas = 1092.6 + 1.8896 * (T) - 0.0036817 * (T * T);
		return CpCenizas;
	}

	public static double CpGlobal(double CpAgua, double CpCarbohidratos, double CpProteinas, double CpGrasas,
			double CpCenizas, double xagua, double xcarbohidratos, double xproteinas, double xgrasas, double xcenizas) {

		double Cpx = 0;

		Cpx = (xagua * CpAgua) + (xcarbohidratos * CpCarbohidratos) + (xproteinas * CpProteinas) + (xgrasas * CpGrasas)
				+ (xcenizas * CpCenizas);

		return Cpx;
	}

	/**
	 * DAgua: Densidad de Agua del Alimento
	 * 
	 * @return DAgua
	 */
	public double densidadAgua() {

		double DAgua = 0;
		DAgua = 997.18 + 0.0031439 * (T) - 0.0037574 * (T * T);
		return DAgua;
	}

	/**
	 * DCarbohidtatos: Densidad de Carbohidratos del Alimento
	 * 
	 * @return DCarbohidratos
	 */
	public double densidadCarbohidratos() {

		double DCarbohidratos = 0;
		DCarbohidratos = 1599.1 - 0.31046 * (T);
		return DCarbohidratos;

	}

	/**
	 * DProteinas: Densidad de Proteinas del Alimento
	 * 
	 * @return Dproteinas
	 */
	public double densidadProteinas() {

		double DProteinas = 0;
		DProteinas = 1330 - 0.5184 * (T);
		return DProteinas;
	}

	/**
	 * DGrasas: Densidad de Grasa del Alimento
	 * 
	 * @return DGrasas
	 */
	public double densidadGrasas() {

		double DGrasas = 0;
		DGrasas = 925.59 - 0.41757 * (T);
		return DGrasas;

	}

	/**
	 * DCenizas: Densidad de Cenizas del Alimento
	 * 
	 * @return DCenizas
	 */
	public double densidadCenizas() {

		double DCenizas = 0;
		DCenizas = 2423.8 - 0.1307 * (T);
		return DCenizas;
	}

	/**
	 * xagua: Fracción Másica Volumen Especifico de Agua del Alimento DAgua:
	 * Densidad de Agua del Alimento
	 * 
	 * @return VeAgua
	 */
	public double volumenEspecificoAgua(double XAgua, double DAgua) {
		double VeAgua = 0;
		VeAgua = XAgua / DAgua;
		return VeAgua;
	}

	/**
	 * xcarbohidratos: Fracción Másica Volumen Especifico de Carbohidratos del
	 * Alimento Dcarbohidratos: Densidad volumen Especifico de Carbohidratos del
	 * Alimento
	 * 
	 * @return VeCarbohidratos
	 */

	public double volumenEspecificoCarbohidratos(double XCarbohidratos, double DCarbohidratos) {
		double VeCarbohidratos = 0;
		VeCarbohidratos = XCarbohidratos / DCarbohidratos;
		return VeCarbohidratos;
	}

	/**
	 * xproteinas: Fracción Másica Volumen Especifico de Proteinas del Alimento
	 * DProteinas: Densidad volumen Especifico de Proteinas del Alimento
	 * 
	 * @return VeProteinas
	 */
	public double volumenEspecificoProteinas(double xproteinas, double DProteinas) {
		double VeProteinas = 0;
		VeProteinas = xproteinas / DProteinas;
		return VeProteinas;
	}

	/**
	 * xgrasas: Fracción Másica de Volumen Especifico de grasas del Alimento
	 * DGrasas: Densidad volumen Especifico de Grasas del Alimento
	 * 
	 * @return VeGrasas
	 */

	public double volumenEspecificoGrasas(double xgrasas, double DGrasas) {

		double VeGrasas = 0;
		VeGrasas = xgrasas / DGrasas;
		return VeGrasas;
	}

	/**
	 * xcenizas:Fracción Másica de Volumen Especifico de Cenias del Alimento
	 * DCenizas: Densidad volumen Especifico de Cenizas del Alimento
	 * 
	 * @return VeCenizas
	 */

	public double volumenEspecificoCenizas(double xcenizas, double DCenizas) {

		double VeCenizas = 0;
		VeCenizas = xcenizas / DCenizas;
		return VeCenizas;
	}

	/**
	 * 
	 * @param VeAgua
	 * @param VeCarbohidratos
	 * @param VeProteinas
	 * @param VeGrasas
	 * @param VeCenizas
	 * @return
	 */
	public double sumatoriaVolumenEspecifico(double VeAgua, double VeCarbohidratos, double VeProteinas, double VeGrasas,
			double VeCenizas) {

		double SumaVe = 0;
		SumaVe = VeAgua + VeCarbohidratos + VeProteinas + VeGrasas + VeCenizas;
		return SumaVe;
	}

	/**
	 * VeAgua: Fracción Volumen Especifico de Agua del Alimento SumaVe:
	 * Sumatoria de Volumen Especifico de Agua del Alimento
	 * 
	 * @return XVAgua
	 */
	public double fraccionVolumenAgua(double VeAgua, double SumaVe) {

		double XVAgua = 0;
		XVAgua = VeAgua / SumaVe;
		return XVAgua;
	}

	/**
	 * VeCarbohidratos:Fracción Volumen Especifico de Carbohidratos del Alimento
	 * Sumave: Sumatoria de Volumen Especifico de Carbohidratos del Alimento
	 * 
	 * @return XVCarbohidratos
	 */
	public double fraccionVolumenCarbohidratos(double VeCarbohidratos, double SumaVe) {

		double XVCarbohidratos = 0;
		XVCarbohidratos = VeCarbohidratos / SumaVe;
		return XVCarbohidratos;
	}

	/**
	 * VeProteinas:Fracción Volumen Especifico de Proteinas del Alimento Sumave:
	 * Sumatoria de Volumen Especifico de Proteinas del Alimento
	 * 
	 * @return XVProteinas
	 */
	public double fraccionVolumenProteinas(double VeProteinas, double SumaVe) {

		double XVProteinas = 0;
		XVProteinas = VeProteinas / SumaVe;
		return XVProteinas;
	}

	/**
	 * VeGrasas:Fracción Volumen Especifico de Grasas del Alimento
	 * Sumave:Sumatoria de Volumen Especifico de Grasas del Alimento
	 * 
	 * @return XVGrasas
	 */

	public double fraccionVolumenGrasas(double VeGrasas, double SumaVe) {

		double XVGrasas = 0;
		XVGrasas = VeGrasas / SumaVe;
		return XVGrasas;
	}

	/**
	 * VeCenizas:Fracción Volumen Especifico de Cenizas del Alimento
	 * Sumave:Sumatoria de Volumen Especifico de Cenizas del Alimento
	 * 
	 * @return XVCenizas
	 */
	public double fraccionVolumenCenizas(double VeCenizas, double SumaVe) {

		double XVCenizas = 0;
		XVCenizas = VeCenizas / SumaVe;
		return XVCenizas;
	}

	/**
	 * KAgua: Conductividad de Agua del Alimento
	 * 
	 * @return KAgua
	 */

	// la conductividad calculada se da en (w/mÂ°C)

	public double conductividadDeAgua() {

		double KAgua = 0;
		KAgua = 0.57109 + 0.0017625 * (T) - 0.0000067036 * (T * T);
		return KAgua;
	}

	/**
	 * KCarbohidratos: Conductividad de Carbohidratos del Alimento
	 * 
	 * @return KCarbohidratos
	 */

	public double conductividadDeCarbohidratos() {

		double KCarbohidratos = 0;
		KCarbohidratos = 0.20141 + 0.0013874 * (T) - 0.0000043312 * (T * T);
		return KCarbohidratos;
	}

	/**
	 * KProteinas: Conductividad de Proteinas del Alimento
	 * 
	 * @return KProteinas
	 */
	public double conductividadDeProteinas() {

		double KProteinas = 0;
		KProteinas = 0.17881 + 0.0011958 * (T) - 0.0000027178 * (T * T);
		return KProteinas;
	}

	/**
	 * KGrasas: Conductividad de Grasas del Alimento
	 * 
	 * @return KGrasas
	 */

	public double conductividadDeGrasas() {

		double KGrasas = 0;
		KGrasas = 0.18071 - 0.0027604 * (T) - 0.00000017749 * (T * T);
		return KGrasas;
	}

	/**
	 * KCenizas: Conductividad de Cenizas del Alimento
	 * 
	 * @returnKCenizas
	 */
	public double conductividadDeCenizas() {

		double KCenizas = 0;
		KCenizas = 0.32961 - 0.0014011 * (T) - 0.0000029069 * (T * T);
		return KCenizas;
	}

	public double conductividadGlobal(double XVAgua, double XVCarbohidratos, double XVProteinas, double XVGrasas,
			double XVCenizas, double KAgua, double KCarbohidratos, double KProteinas, double KGrasas, double KCenizas) {

		double KGlobal = 0;
		KGlobal = (XVAgua * KAgua) + (XVCarbohidratos * KCarbohidratos) + (XVProteinas * KProteinas)
				+ (XVGrasas * KGrasas) + (XVCenizas * KCenizas);
		return KGlobal;
	}
	public void imprimirPropiedadesTermicas(double P, double T, double TBh) {
		
		
		
	}

}// cierre programa
