package arbolesBinS;

public class Pasciente 
{
	public String nombre;
	public int id;
	//SIntomas LISTA o ARRAY
	ListaSintoma sintomasList;
	
	
	public Pasciente(String nombre , int id ) 
	{
		this.nombre = nombre;
		this.id = id;
		sintomasList = new ListaSintoma();
	}
	
	public void agregarSintoma (Sintoma sintoma) 
	{		
		sintomasList.insertar(sintoma);
	}
	

	public void mostrarSintomas(ListaSintoma listaSintomas) 
	{
		NodoSintoma tmp = listaSintomas.head;
		while(tmp != null)
		{
			System.out.println(tmp.sintoma.descrp);
			tmp = tmp.next;
		}
	}
	
	public void calcularSintomas(ListaSintoma listaSintomas) 
	{
		int contador = 0;
		int resultado = 0;
		int pagoXSintoma = 100;
		NodoSintoma tmp = listaSintomas.head;
		while(tmp != null) 
		{
			resultado = contador * pagoXSintoma;
			tmp = tmp.next;
		}
	}
	
	

}
