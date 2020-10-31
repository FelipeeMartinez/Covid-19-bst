package arbolesBinS;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Program 
{
	public static void main(String[] args) throws NumberFormatException, IOException 
	{
		    ArbolBinBusc abb = new ArbolBinBusc();
		    ListaSintoma sintlist = new ListaSintoma();
			
			BufferedReader buf = new BufferedReader(new FileReader("covid19-datos.txt"));
			
			int cantPascientes = Integer.parseInt(buf.readLine());
			
			 String[] arrDatosPasciente;
			 String[] arrDatosSintoma;
		        
		        for(int i=0; i<cantPascientes;i++) 
		        {	
		            arrDatosPasciente = buf.readLine().split(",");
		            Pasciente pasciente = new Pasciente(arrDatosPasciente[0], Integer.parseInt(arrDatosPasciente[1]));
		            int cantSintomas = Integer.parseInt(arrDatosPasciente[2]);
		            for (int j = 0; j < cantSintomas; j++) 
		            {
		            	arrDatosSintoma = buf.readLine().split(",");
						Sintoma sintoma = new Sintoma(arrDatosSintoma[0]);
						pasciente.agregarSintoma(sintoma);
		            }
		            
		            abb.addPasciente(pasciente);
		        }
		        
		        int idBuscSint = 188;
		        Pasciente pasciente = abb.buscar(idBuscSint);
		        System.out.println("El paciente " + pasciente.nombre + " tiene los siguientes sintomas");
		        pasciente.mostrarSintomas(pasciente.sintomasList);
		        
		        int idBuscTrat = 188;
		        int pasciente2 = abb.calcularValorxSintoma(pasciente);
		        System.out.println("El paciente " + pasciente.nombre + " Tiene un total: " + pasciente2);

				int fiebre = abb.calcularPersonasFiebre(pasciente);
				System.out.println("Hay "+ fiebre + " personas con fiebre");
				
				System.out.println("El promedio es " + abb.promedio / (abb.conto + 12));
				
				Pasciente pas = abb.calcularPersonasMasSintomas(pasciente);
				System.out.println("La persona con mas sintomas es " + pas.nombre);
		
	
	}

}
