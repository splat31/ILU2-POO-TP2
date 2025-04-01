package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		String produit=getProduit(nomAcheteur);
		String[] tab = controlAcheterProduit.TrouverProduit(nomAcheteur,produit);
		if (tab.length==1&&tab[0]=="pas dans le village") {
			System.out.println("Je suis désolée " + nomAcheteur +
					" mais il faut etre un habitant de"
					+ " notre village pour commercer ici.");
		} else if (tab.length==1&&tab[0]=="pas de vendeur") {
			System.out.println("Désolée, personne ne vend ce produit au marché");
		} else {
			System.out.println("Chez quel commercant voulez-vous acheter des " + produit); 
			for (int i=0;i<tab.length;i++) {
				System.out.println((i+1) +" - "+ tab[i]);
			}
			int indexvendeur= (Clavier.entrerEntier(""))-1;
			while (indexvendeur>=tab.length||indexvendeur<0) {
				System.out.println("Vous n'avez pas sélectionner de bon vendeur");
				indexvendeur= (Clavier.entrerEntier(""))-1;
			}
			
			System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeurb "+ tab[indexvendeur]);
			int demande=Clavier.entrerEntier("Combien de "+produit+ " voulez-vous acheter ?");
			int vendu=controlAcheterProduit.AcheterProduit(tab[indexvendeur],demande);
			if (vendu==0) {
				System.out.println(nomAcheteur+" veut acheter "+ demande+" "+ produit+" mais il n'yen a plus");
				
			} else if(vendu!=demande) {
				System.out.println(nomAcheteur+" veut acheter "+ demande+" "+ produit+" mais "+tab[indexvendeur]
						+" n'ens as plus que "+vendu+". "+nomAcheteur+" achète tout le stock de "+tab[indexvendeur] );
			} else {
				System.out.println(nomAcheteur+ " achète "+vendu+" "+produit+ " à "+tab[indexvendeur]);
			}
		}
		
		
		
		
		
	}
	
	public String getProduit(String nomAcheteur) {
		String produit =Clavier.entrerChaine("Quel produit voulez-vous acheter");
		return produit;
	}
}
