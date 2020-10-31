package arbolesBinS;

public class NodoPasciente 
{

	public NodoPasciente(Pasciente newPasciente) 
	{
		this.pasciente = newPasciente;
	}
	
	Pasciente pasciente;
	NodoPasciente left;
	NodoPasciente rigth;

}
