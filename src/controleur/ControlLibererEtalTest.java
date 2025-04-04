package controleur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private ControlEmmenager controlemmenager;
	private ControlVerifierIdentite verif;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlPrendreEtal controlprendreetal;
	private ControlLibererEtal controllibereretal;
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
		controllibereretal = new ControlLibererEtal(controlTrouverEtalVendeur);
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
	void testisVendeur() {
		assertFalse(controllibereretal.isVendeur("Obelix"));
		assertFalse(controllibereretal.isVendeur("inconnu"));
		assertTrue(controllibereretal.isVendeur("Bonemine"));
		assertTrue(controllibereretal.isVendeur("Asterix"));
	}

	@Test
	void testlibererEtal() {
		controllibereretal.libererEtal("Asterix");
		Gaulois Asterix = village.trouverHabitant("Asterix");
		Etal etal = village.rechercherEtal(Asterix);
		assert (etal != null);

	}
}
