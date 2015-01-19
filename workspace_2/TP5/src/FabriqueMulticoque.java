
public class FabriqueMulticoque implements FabriqueVoilier{

	public Voilier factoryMethod(String nom, String classeDuRhum) {
		
		switch (classeDuRhum)
       	{
		case "RHUM": return new RHUM_Multi(nom);
       	case "MULTI_50" : return new MULTI_50(nom);
       	case "ULTIME": return new ULTIME(nom);
       }
		return null;
	}

}
