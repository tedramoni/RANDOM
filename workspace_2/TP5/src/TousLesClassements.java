import java.util.*;


public class TousLesClassements implements Observable {
	
	ArrayList <TreeSet <Position>> classements = new ArrayList<TreeSet <Position>>();
	ArrayList<Observateur> listeObservateurs = new ArrayList<Observateur>() ;
	
	public void addClassement(TreeSet<Position> parClassement)
	{
		classements.add(parClassement);
	}
	
	public String toString()
	{
		/*String s = "";
		int i = 0;
		Iterator it = this.classements.iterator();
		while (it.hasNext())
		{
			s+= "Classement "+i+ ":";
			s+=it.next().toString();
		}
		return s;*/
		return classements.toString();
	}

	public void enregistrerObservateur(Observateur o) {
		listeObservateurs.add(o);
	}

	public void desenregistrerObservateur(Observateur o) {
		listeObservateurs.remove(o);
	}

	public void informeObservateurs() {
		Iterator it = listeObservateurs.iterator();
		while (it.hasNext())
		{
			((Observateur) it.next()).actualise(this);
		}
	}

}
