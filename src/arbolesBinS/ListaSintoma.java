package arbolesBinS;

public class ListaSintoma 
{
    NodoSintoma head;
	
	void insertar(Sintoma sintoma)
	{
		NodoSintoma nuevoNodo = new NodoSintoma();
		nuevoNodo.sintoma = sintoma;
		
		
		if(head == null) 
		{
			head = nuevoNodo;
		}
		else
		{ 
			NodoSintoma ultimo = head;
			
			while(ultimo.next != null) 
			{
				ultimo = ultimo.next;			
			}
			ultimo.next = nuevoNodo;
		}
	}

}
