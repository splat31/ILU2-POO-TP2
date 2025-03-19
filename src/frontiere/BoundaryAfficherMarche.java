package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if (infosMarche.length == 0) {
			System.out.println("Le march� est vide, revenez plus tard\n");
		} else {
			System.out.println(nomAcheteur + ", vous trouverez au march� :\n");
			for (int i = 0; i < infosMarche.length; i = i + 3) {
				System.out
						.println("- " + infosMarche[i] + " qui vend " + infosMarche[i + 1] + " " + infosMarche[i + 2]);
			}
		}
	}
}
