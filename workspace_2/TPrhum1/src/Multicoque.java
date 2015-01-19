
public class Multicoque extends Voilier{
	
	public Multicoque(String parNom, ChoisirRoute parChoixRoute)
	{
		nom = parNom;
		choixRoute = parChoixRoute;
	}
	
	public String toString()
	{
		return "Je suis un multicoque, "+super.toString();
	}

}
