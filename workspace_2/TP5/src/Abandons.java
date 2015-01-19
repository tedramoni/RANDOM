import java.util.*;

public class Abandons implements Observateur{
	
	protected ArrayList<String> listeAbandons = new ArrayList<String>();
	
	public void actualise(Observable parObservable)
	{
		TousLesClassements sujet = (TousLesClassements) parObservable;
		TreeSet<Position> dernierClassement = sujet.classements.get(sujet.classements.size()-1);
		Iterator it = dernierClassement.iterator();
		while(it.hasNext())
		{
			Position pos = (Position)it.next();
			if (pos.abandon == true)
			{
				if(!listeAbandons.contains(pos.getNom()))
				{
					listeAbandons.add(pos.getNom());
				}
			}
		}
	}
	
	public String toString()
	{
		return "Liste des abandons : "+listeAbandons.toString();
	}

}
