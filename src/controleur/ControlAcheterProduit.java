package controleur;

import personnages.Gaulois;
import villagegaulois.Village;
import villagegaulois.Etal;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}

	public String[] TrouverProduit(String nomAcheteur,String produit) {
		if (controlVerifierIdentite.verifierIdentite(nomAcheteur)) {
			Gaulois[] tab =village.rechercherVendeursProduit( produit);
			if (tab==null) {
				
				String[] tabretour= new String[1];
				tabretour[0]="pas de vendeur";
				return tabretour;
			} else {
				
				String[] tabretour=new String[tab.length];
				for (int i=0;i<tab.length;i++) {
					tabretour[i]=tab[i].getNom();
					
				}
				return tabretour;
			}
		} else {
			String[] tabretour= new String[1];
			tabretour[0]="pas dans le village";
			return tabretour;
		}
	}
	
	public int AcheterProduit(String nomVendeur, String Produit, int demande) {
		Gaulois gaulois = village.trouverHabitant(nomVendeur);
		Etal etal = recherche(gaulois);
		int vendu=etal.acheterProduit(demande);
		return vendu;
	}
	
	public Etal recherche(Gaulois vendeur) {
		Etal etal = village.rechercherEtal(vendeur);
		return etal;
	}
	
	
}
