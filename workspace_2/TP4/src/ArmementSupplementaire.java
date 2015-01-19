
public abstract class ArmementSupplementaire extends Voilier{
	
	protected Voilier voilier;
	
	public ArmementSupplementaire(Voilier parVoilier)
	{
		voilier = parVoilier;
	}
	public void setComportement (ChoisirRoute parChoixRoute)
	{
		voilier.setComportement(parChoixRoute);
	}
	
	public void appliqueChoixRoute()
	{
		voilier.appliqueChoixRoute();
	}
	
	
}
