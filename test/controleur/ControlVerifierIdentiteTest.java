package controleur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	private ControlVerifierIdentite ctrlverif;
	private ControlEmmenager ctrlemm;
	private Village village;
	private Chef chef;
	private int tailleduvillage = 5;

	@BeforeEach
	void setUp() {
		village = new Village("Villagetest", tailleduvillage, 3);
		ctrlverif = new ControlVerifierIdentite(village);
		ctrlemm = new ControlEmmenager(village);
		chef = new Chef("Chi-ef", 10, village);
		village.setChef(chef);
	}

	@Test
	void testverifierIdentite() {
		assertFalse(ctrlverif.verifierIdentite("Bonemine"));
		ctrlemm.ajouterGaulois("Bonemine", 5);
		assertTrue(ctrlverif.verifierIdentite("Bonemine"));
		assertFalse(ctrlverif.verifierIdentite("Bonemine2"));
	}

}
