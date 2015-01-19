
public class Monocoque extends Voilier{
	
	public Monocoque(String parNom, ChoisirRoute parChoixRoute)
	{
		nom = parNom;
		choixRoute = parChoixRoute;
	}
	
	public Monocoque(String parNom)
	{
		nom = parNom;
	}
	
	public String toString()
	{
		return "Je suis un monocoque, "+super.toString();
	}

}
