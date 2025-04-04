package controleur;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private ControlEmmenager controlemmenager;
	private ControlVerifierIdentite verif;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlPrendreEtal controlprendreetal;
	private ControlAcheterProduit controlacheterproduit;
	private Village village;
	private Chef chef;
	private int tailleduvillage = 5;

	@BeforeEach
	void setUp() {
		village = new Village("Villagetest", tailleduvillage, 3);
		controlemmenager = new ControlEmmenager(village);
		verif = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		controlprendreetal = new ControlPrendreEtal(verif, village);
		controlacheterproduit = new ControlAcheterProduit(verif, controlTrouverEtalVendeur, village);
		chef = new Chef("Chi-ef", 10, village);
		village.setChef(chef);
		controlemmenager.ajouterGaulois("Bonemine", 3);
		controlemmenager.ajouterGaulois("Asterix", 5);
		controlprendreetal.prendreEtal("Bonemine", "fleur", 10);
		controlprendreetal.prendreEtal("Bonemine", "s", 10);
		controlprendreetal.prendreEtal("Asterix", "s", 10);
		controlemmenager.ajouterGaulois("Obelix", 10);

	}

	@Test
	void testTrouverProduit() {
		String[] retour;
		retour = controlacheterproduit.TrouverProduit("panoramix", "fleur");
		assert (retour[0] == "pas dans le village" && retour.length == 1);
		retour = controlacheterproduit.TrouverProduit("Obelix", "poisson");
		assert (retour[0] == "pas de vendeur" && retour.length == 1);
		retour = controlacheterproduit.TrouverProduit("Obelix", "fleur");
		assert (retour[0] == "Bonemine" && retour.length == 1);
		String[] retour2 = controlacheterproduit.TrouverProduit("Obelix", "s");
		assert (retour2.length == 2);
		assert (retour2[0] == "Bonemine");
		assert (retour2[1] == "Asterix");
	}

	@Test
	void testAcheterProduit() {
		int vendu;
		vendu = controlacheterproduit.AcheterProduit("Asterix", 10);
		assert (vendu == 10);
		vendu = controlacheterproduit.AcheterProduit("Bonemine", 5);
		assert (vendu != 0);
		// modifier acheter produit pour indiquer le produit acheter
	}
}
