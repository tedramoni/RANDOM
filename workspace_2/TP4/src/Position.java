import java.util.Date;


public class Position implements Comparable <Position> {

	protected String nomSkipper;
	protected double distanceArrivee;
	protected Date dateEtHeureArrivee;
	protected boolean abandon;
	
	public Position(String parNomSkipper, double parDistanceArrivee, 
			Date parDateEtHeureArrivee, boolean parAbandon)
	{
		nomSkipper = parNomSkipper;
		distanceArrivee = parDistanceArrivee;
		dateEtHeureArrivee = parDateEtHeureArrivee;
		abandon = parAbandon;
	}

	public int compareTo(Position pos) {
		if (this.distanceArrivee<pos.distanceArrivee)
		{
			return -1;
		}
		else
		{
			return 1;
		}
	}
	
	public String toString()
	{
		return "Nom : "+nomSkipper+" | Distance à l'arrivee : "+distanceArrivee+
				" | Date et heure d'arrivée : "+dateEtHeureArrivee+" | Abandon : "+abandon;
	}
	
	public String getNom()
	{
		return nomSkipper;
	}
	
	
}
