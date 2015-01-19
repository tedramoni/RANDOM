import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;


public class Arrivees implements Observateur{

	protected ArrayList<String> listeArrivees = new ArrayList<String>();
	
	public void actualise(Observable parObservable)
	{
		TousLesClassements sujet = (TousLesClassements) parObservable;
		TreeSet<Position> dernierClassement = sujet.classements.get(sujet.classements.size()-1);
		Iterator it = dernierClassement.iterator();
		while(it.hasNext())
		{
			Position pos = (Position)it.next();
			if (pos.dateEtHeureArrivee != null)
			{
				if(!listeArrivees.contains(pos.getNom()))
				{
					listeArrivees.add(pos.getNom());
				}
			}
		}
	}
	
	public String toString()
	{
		return "Liste des arrivées : "+listeArrivees.toString();
	}

}
