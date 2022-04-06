import java.util.Scanner;

public class Menus1 {
	
public static Scanner entrada = new Scanner(System.in);
	
	
	/**
	 * Class Balance De Deshidratacion de Alimentos 
	 * @author Daniel Cuadrado
	 * @author Yesika García 
	 * Fundamentos de Programación 
	 * Profesor: Nelson Sanchez
	 */
  
	public static void main(String[] args) {
		
		System.out.println("ingrese la opcion que desea realizar");
		System.out.println("******************************************");
		System.out.println("1. Imprimir propiedades del aire");
	    System.out.println("2. Realizar calculos De Osmodeshidratacion");
		System.out.println("******************************************");

		int opcion = entrada.nextInt();
       
        
        switch (opcion){
        
        case 1:
            System.out.println("Imprimir propiedades del aire");
            menuDePropiedadesDelAire();
            break;
        case 2:
            System.out.println("Realizar calculos De Osmodeshidratacion");
            menuDeOsmodeshidratacion();
            break;
        }
		
		
		
	}// cierre main


	/**
	 * Propiedades del Aire 
	 * P: Presión Ambiental en Kilopascales (Kpa) 
	 * T:Temperatura en grados Celsius 
	 * TBh:Temperatura de Bulbo Húmedo en grados Celsius 
	 */
	
	 
	public static void menuDePropiedadesDelAire() {
		System.out.println("******************************************");

		System.out.println("Ingre la presion abmosferica de su zona de trabajo en kpa");
		double P=entrada.nextDouble();// presion ambiente a Kpa
			
		System.out.println("Ingre la temperatura de bulso seco en Â°C");
		double T=entrada.nextDouble(); // la temperatura se trabaja en °C
			
		System.out.println("Ingre la temperatura de bulso humedo en Â°C");
		double TBh = entrada.nextDouble();// temperatura de bulbo humedo en °C
		System.out.println("******************************************");

		
		TablaSicrometria t1 = new TablaSicrometria();

		double A = t1.factorSicrometrico(T, TBh);
		double PsBh = t1.PresionSauradaTBh(TBh);
		double PsBs = t1.PresionSauradaTBs(T);
		double Pv = t1.PresionDeVapor(PsBh, A, PsBs, T, TBh);
		double Hr = t1.humedadRelativa(Pv, PsBs);
		double Tr = t1.temperaturaDeRocio(Hr, TBh);
		double Ha = t1.humedadAbsoluta(Pv, Tr);
		double He = t1.humedadEspecifica(Pv, Pv);
		double W = t1.relacionDeMezcla(Pv, P);
			
		System.out.println("******************************************");
		System.out.println("seleccione la propiedad que nesecita determinar");
		System.out.println("******************************************");
		opcionesDelMenu"1. calcular propiedades Psicrometricas del aire");
		opcionesDelMenu"2. calcular factor Sicrometrico");
		opcionesDelMenu"3. calcular Presion De Vapor");
		opcionesDelMenu"4. calcular humedad Relativa");
		opcionesDelMenu"5. calcular temperatura De Rocio");
		opcionesDelMenu"6. calcular humedad Absoluta");
		opcionesDelMenu"7. calcular humedad Especifica");
		opcionesDelMenu"8. calcular relacion De Mezcla de gases");	
		opcionesDelMenu"******************************************");

		int opcion = entrada.nextInt();
       
        
        switch (opcion){
        
        case 1:
            System.out.println("calcular propiedades Psicrometricas del aire");
    		t1.imprimirTablaDeSicrometrica( P,  T,  TBh);	
            break;
        case 2:
            System.out.println(" factor Sicrometrico");
    		System.out.println(A);

            break;
        case 3:
            System.out.println("Presion De Vapor");
    		System.out.println(Pv+"Kpa");

            break;
        case 4:
            System.out.println("humedad Relativa"); 
            System.out.println(Hr+"%");

            break;
        case 5:
            System.out.println("temperatura De Rocio");
    		System.out.println(Tr);

            break;
        case 6:
            System.out.println("humedad Absoluta");
    		System.out.println(Ha);

            break;
        case 7:
            System.out.println("humedad Especifica");
    		System.out.println(He);

            break;
        case 8:
            System.out.println("relacion De Mezcla de gases");
    		System.out.println(W);

            break;
        }
		
		
		
		
		
	}
	

	 
	  //Imprimir Cálculos De Osmodeshidratación  

	public static void menuDeOsmodeshidratacion() {
		
		DeshidratacionOsmotica t2 = new DeshidratacionOsmotica();
		
		System.out.println("******************************************");

		System.out.println("selecccione el calculo que desea realizar de osmodeshidratacion");
		System.out.println("con un modelo fenomenológico");
		System.out.println("******************************************");
        System.out.println("1. perdida De Agua");
        System.out.println("2. perdida De Peso");
        System.out.println("3. ganancia De Solidos");
		System.out.println("******************************************");
		System.out.println(" seleccione la opcion que desea realizar");

        int opcion = entrada.nextInt();
        switch (opcion){
        
        
        case 1:
    		System.out.println("******************************************");
            System.out.println("perdida De Agua");
    		System.out.println("******************************************");
    		System.out.println("peso inicial de la muestra en g");

            double MO = entrada.nextDouble();
    		System.out.println("peso final de la muestra en g");

    		double MF = entrada.nextDouble();
    		System.out.println("humedad inicial de la muestra en %");

    		double HO = entrada.nextDouble();
    		System.out.println("humedad final de la muestra en %");

    		double HF = entrada.nextDouble();
    		
            System.out.println( "el % de perdidad de agua es"+t2.perdidaDeAgua(MO, MF, HO, HF)+"%" );
            break;
        case 2:
    		System.out.println("******************************************");
        	System.out.println("perdida De Peso");
    		System.out.println("******************************************");
    		  MO = entrada.nextDouble();
     		System.out.println("peso final de la muestra en g");

     		 MF = entrada.nextDouble();
     		System.out.println("humedad inicial de la muestra en %");
            System.out.println( "el % de perdidad de peso es"+t2.perdidaDePeso(MO, MF)+"%" );

            break;
        case 3:
            System.out.println("ganancia De Solidos");
             MO = entrada.nextDouble();
    		System.out.println("peso final de la muestra en g");
    		 MF = entrada.nextDouble();
    		System.out.println("humedad inicial de la muestra en %");
    		 HO = entrada.nextDouble();
    		System.out.println("humedad final de la muestra en %");
    		 HF = entrada.nextDouble();
     		System.out.println("ºBrix iniciales de la muestra");
    		double SO = 0;
    		System.out.println("ºBrix finales de la muestra");
    		double SF = 0;
    		
            System.out.println( "el % de ganancia de solidos es"+t2.gananciaDeSolidos(MO, MF, SF, SO)+"%");

    		
            break;
            
            
        }
		
	}


}
