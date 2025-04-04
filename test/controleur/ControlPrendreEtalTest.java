package controleur;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	private ControlEmmenager controlemmenager;
	private ControlVerifierIdentite verif;
	private ControlPrendreEtal controlprendreetal;
	private Village village;
	private Chef chef;
	private int tailleduvillage = 5;

	@BeforeEach
	void setUp() throws Exception {
		village = new Village("Villagetest", tailleduvillage, 4);
		controlemmenager = new ControlEmmenager(village);
		verif = new ControlVerifierIdentite(village);
		controlprendreetal = new ControlPrendreEtal(verif, village);
		chef = new Chef("Chi-ef", 10, village);
		village.setChef(chef);
		controlemmenager.ajouterGaulois("Bonemine", 3);
		controlemmenager.ajouterGaulois("Asterix", 3);
	}

	@Test
	void testprendreEtal() {
		assertTrue(controlprendreetal.prendreEtal("Bonemine", "fleur", 10) == 0);
		assertTrue(controlprendreetal.prendreEtal("Bonemine", "coco", 10) == 1);
		assertTrue(controlprendreetal.prendreEtal("Asterix", "coco", 10) == 2);
		assertTrue(controlprendreetal.prendreEtal("panoramix", "coco", 10) == -1);
	}

	@Test
	void testresteEtals() {
		assertTrue(controlprendreetal.resteEtals());
	}

}
