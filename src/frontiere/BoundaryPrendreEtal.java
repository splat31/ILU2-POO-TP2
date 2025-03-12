package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (controlPrendreEtal.verifierIdentite(nomVendeur)==false) {
			System.out.println("Je suis désolée " + nomVendeur + " mais il faut etre un habitant de notre village pour commercer ici.\n");
		} else {
			System.out.println("Bonjour "+ nomVendeur + " ,je vais regarder si je peux vous trouver un étal");
			if (controlPrendreEtal.resteEtals()==false) {
				System.out.println("");
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		//TODO a completer
	}
}
