
public class Velo extends ArmementSupplementaire {
	
	public Velo(Voilier parVoilier) {
		super(parVoilier);
	}

	public String toString()
	{
		return voilier.toString()+ ", j'ai un Vélo supplémentaire";
	}

}
