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
	private ControlEmmenager controlemmenager;
	private Village village;
	private Chef chef;
	private int tailleduvillage = 5;

	@BeforeEach
	void setUp() {
		village = new Village("Villagetest", tailleduvillage, 3);
		controlemmenager = new ControlEmmenager(village);
		chef = new Chef("Chi-ef", 10, village);
		village.setChef(chef);
	}

	@Test
	void testisHabitant() {
		assertFalse(controlemmenager.isHabitant("Bonemine"));
		controlemmenager.ajouterGaulois("Bonemine", 5);
		assertTrue(controlemmenager.isHabitant("Bonemine"));
		assertFalse(controlemmenager.isHabitant("N'existe pas"));
		controlemmenager.ajouterDruide("DR-huide", 10, 1, 5);
	}

	@Test
	void testajouterGaulois() {
		// test rajoue sans dépasser limite
		for (int i = 0; i < tailleduvillage; i++) {
			controlemmenager.ajouterGaulois("faiblard" + (i + 1), 1);
		}
		for (int i = 0; i < tailleduvillage; i++) {
			assertTrue(controlemmenager.isHabitant("faiblard" + (i + 1)));
		}

		// test rajoue en depassant limite
		for (int i = 0; i < tailleduvillage; i++) {
			controlemmenager.ajouterGaulois("fort" + (i + 1), 1);
		}
		for (int i = 0; i < tailleduvillage; i++) {
			assertFalse(controlemmenager.isHabitant("fort" + (i + 1)));
		}
	}

	@Test
	void testajouterDruide() {
		// test rajoue sans dépasser limite
		for (int i = 0; i < tailleduvillage; i++) {
			controlemmenager.ajouterDruide("Druidard" + (i + 1), 10, 1, 5);
		}
		for (int i = 0; i < tailleduvillage; i++) {
			assertTrue(controlemmenager.isHabitant("Druidard" + (i + 1)));
		}

		// test rajoue en depassant limite
		for (int i = 0; i < tailleduvillage; i++) {
			controlemmenager.ajouterDruide("Gaudruide" + (i + 1), 10, 1, 5);
		}
		for (int i = 0; i < tailleduvillage; i++) {
			assertFalse(controlemmenager.isHabitant("Gaudruide" + (i + 1)));
		}
	}

}
