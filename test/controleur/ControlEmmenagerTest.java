package controleur;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/* A faire
public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}
*/

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlEmmenagerTest {
	private ControlEmmenager ctrlemm;
	private Village village;
	private Chef chef;
	private int tailleduvillage = 5;

	@BeforeEach
	void setUp() {
		village = new Village("Villagetest", tailleduvillage, 3);
		ctrlemm = new ControlEmmenager(village);
		chef = new Chef("Chi-ef", 10, village);
		village.setChef(chef);
	}

	@Test
	void testisHabitant() {
		assertFalse(ctrlemm.isHabitant("Bonemine"));
		ctrlemm.ajouterGaulois("Bonemine", 5);
		assertTrue(ctrlemm.isHabitant("Bonemine"));
		assertFalse(ctrlemm.isHabitant("N'existe pas"));
		ctrlemm.ajouterDruide("DR-huide", 10, 1, 5);
	}

	@Test
	void testajouterGaulois() {
		// test rajoue sans dépasser limite
		for (int i = 0; i < tailleduvillage; i++) {
			ctrlemm.ajouterGaulois("faiblard" + (i + 1), 1);
		}
		for (int i = 0; i < tailleduvillage; i++) {
			assertTrue(ctrlemm.isHabitant("faiblard" + (i + 1)));
		}

		// test rajoue en depassant limite
		for (int i = 0; i < tailleduvillage; i++) {
			ctrlemm.ajouterGaulois("fort" + (i + 1), 1);
		}
		for (int i = 0; i < tailleduvillage; i++) {
			assertFalse(ctrlemm.isHabitant("fort" + (i + 1)));
		}
	}

	@Test
	void testajouterDruide() {
		// test rajoue sans dépasser limite
		for (int i = 0; i < tailleduvillage; i++) {
			ctrlemm.ajouterDruide("Druidard" + (i + 1), 10, 1, 5);
		}
		for (int i = 0; i < tailleduvillage; i++) {
			assertTrue(ctrlemm.isHabitant("Druidard" + (i + 1)));
		}

		// test rajoue en depassant limite
		for (int i = 0; i < tailleduvillage; i++) {
			ctrlemm.ajouterDruide("Gaudruide" + (i + 1), 10, 1, 5);
		}
		for (int i = 0; i < tailleduvillage; i++) {
			assertFalse(ctrlemm.isHabitant("Gaudruide" + (i + 1)));
		}
	}

}
