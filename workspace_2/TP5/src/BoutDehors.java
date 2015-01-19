
public class BoutDehors extends ArmementSupplementaire {
	
	public BoutDehors(Voilier parVoilier) {
		super(parVoilier);
	}

	public String toString()
	{
		return voilier.toString()+", j'ai un Bout Dehors en plus";
	}
	

}
