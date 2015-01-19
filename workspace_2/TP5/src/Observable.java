
public interface Observable {
	
	public void enregistrerObservateur(Observateur o);
	public void desenregistrerObservateur(Observateur o);
	public void informeObservateurs();
	

}
