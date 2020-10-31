package arbolesBinS;

public class ArbolBinBusc 
{
 NodoPasciente root;
	
	public void addPasciente(Pasciente newPasciente) 
	{
		if(root == null) 
		{
			root =  new NodoPasciente(newPasciente);
			return;
		}
		if(obtenerRepetido(newPasciente) == true) 
		{
			System.out.println("El paciente " + newPasciente.nombre + " esta duplicado");
		}
		else 
		{
			addPasciente(root ,newPasciente);
		}
	}
	
	private void addPasciente(NodoPasciente root, Pasciente newPasciente) 
	{
		
		if(root == null) 
		{
			return;
		}
		
		if(newPasciente.id > root.pasciente.id) 
		{
			if(root.rigth == null) 
			{
				root.rigth = new NodoPasciente(newPasciente);
			}
			else {
				addPasciente(root.rigth, newPasciente);
			}
		}
		else {
			if(root.left == null) {
				root.left = new NodoPasciente(newPasciente);
			}
			else {
				addPasciente(root.left, newPasciente);
			}
		}		
	}
	
	public Pasciente buscar(int id) 
	{
		return buscar(root, id);
	}
	
	private Pasciente buscar(NodoPasciente node, int id) 
	{
		
		if(node == null) 
		{
			return null;
		}
		
		if(node.pasciente.id == id)
		{
			return node.pasciente;
		}
		
		if(node.pasciente.id < id) 
		{
			return buscar(node.rigth, id);
		}
		
		return buscar(node.left, id);
	}
	
	public boolean obtenerRepetido (Pasciente pasciente) 
    {
		Pasciente repetido = buscar(pasciente.id);
		if(repetido != null) 
		{
			return true ;
		}
		else 
		{
			return false;
		}
			
    }
	
	public int obtenerCantidadSintomas(ListaSintoma sintomasList) 
	{
		int contador = 0;
		NodoSintoma tmp = sintomasList.head;
		while(tmp != null) 
		{
			contador++;
			tmp = tmp.next;
		}
		return contador;
	}
	
	int promedio;
	int conto;
	public int calcularValorxSintoma(Pasciente pasciente) 
	{
		Pasciente sintomas = buscar(root.pasciente.id);
		int cantSintomas = obtenerCantidadSintomas(root.pasciente.sintomasList);
		int costoTratamiento = 0;
		if(root != null) 
		{
			costoTratamiento = cantSintomas * 100;
		}
		promedio += costoTratamiento;
		conto ++ ;
		return costoTratamiento;
	}
	
	public int obtenerSintomaFiebre(ListaSintoma sintomasList) 
	{
		int contador = 0;
		NodoSintoma tmp = sintomasList.head;
		while(tmp != null) 
		{
			if(tmp.sintoma.descrp == "fiebre") 
			{
				contador++;
				tmp = tmp.next;
			}
			else 
			{
				contador = 0;
			}
			
		}
		return contador;
	}
	
	public int calcularPersonasFiebre(Pasciente pasciente)  
	{
		int suma = 0;
		if(root != null) 
		{
			return 0;
		}
		else 
		{
			int fiebre = obtenerSintomaFiebre(root.pasciente.sintomasList);
			suma++;
			if(root.rigth != null) 
			{
				obtenerSintomaFiebre(root.pasciente.sintomasList);
				suma++;
			}
			if(root.left != null) 
			{
				obtenerSintomaFiebre(root.pasciente.sintomasList);
				suma++;
			}
			return suma;
		}
	}
	public Pasciente calcularPersonasMasSintomas(Pasciente pasciente)  
	{
		int contard = obtenerCantidadSintomas(pasciente.sintomasList);
		int suma = 0;
		if(root == null) 
		{
			return root.pasciente;
		}
		else 
		{
			if(root.pasciente.id >= contard) 
			{
				return root.pasciente;
			}
			if(contard <= root.rigth.pasciente.id) 
			{
				return root.pasciente;
			}
			if(contard <= root.left.pasciente.id) 
			{
				return root.pasciente;
			}
		}
		return root.pasciente;
	}

}
