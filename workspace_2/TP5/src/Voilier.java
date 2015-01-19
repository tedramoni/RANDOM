
public abstract class Voilier {
	protected String nom;
	protected ChoisirRoute choixRoute;
	
	public String toString()
	{
		return "Mon nom est "+nom;
	}
	
	public void setComportement (ChoisirRoute parChoixRoute)
	{
		choixRoute = parChoixRoute;
	}
	
	public void appliqueChoixRoute()
	{
		choixRoute.choixRoute();
	}

}
