
public class Test {

	public static void main(String[] args) {
			// 2 voiliers crées avec leur comportement par défaut
		Voilier voilier1 = new Monocoque ("Jean-Monocoque", new ChoixRouteDirecte());
		Voilier voilier2 = new Multicoque ("Jean-Multicoque", new ChoixRouteAlize());
		
			// On affiche les 2.
		System.out.println(voilier1.toString());
		System.out.println(voilier2.toString());
		
			// On applique leur comportement
		voilier1.appliqueChoixRoute();
		voilier2.appliqueChoixRoute();
		
			// Il y a du vent, le monocoque choisit la route des alizés
		voilier1.setComportement(new ChoixRouteAlize());
		
			// Et il aplique ce choix
		voilier1.appliqueChoixRoute();
		
			// On affiche les 2 à nouveau pour voir.
		System.out.println(voilier1.toString());
		System.out.println(voilier2.toString());

	}

}
