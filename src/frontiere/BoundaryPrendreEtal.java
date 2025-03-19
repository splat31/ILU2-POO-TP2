package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (controlPrendreEtal.verifierIdentite(nomVendeur) == false) {
			System.out.println("Je suis d�sol�e " + nomVendeur
					+ " mais il faut etre un habitant de notre village pour commercer ici.\n");
		} else {
			System.out.println("Bonjour " + nomVendeur + " ,je vais regarder si je peux vous trouver un �tal.\n");
			if (controlPrendreEtal.resteEtals() == false) {
				System.out.println("D�sol�e " + nomVendeur + "je n'ai plus d'�tal qui ne soit pas occup�e.\n");
			} else {
				this.installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		System.out.println(
				"C'est parfait, il me reste un �tal pour vous !\n" + "Il me faudrait quelques renseignements :\n");
		String produit = Clavier.entrerChaine("Quel produit souhaitez-vous vendre ?\n");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez-vous vendre ?\n");
		int numero = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (numero != -1) {
			System.out.println("Le vendeur " + nomVendeur + " s'est install� � l'�tal n�" + (numero + 1) + ".\n;");
		}
	}
}
