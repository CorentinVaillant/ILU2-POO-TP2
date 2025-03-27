package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAcheterProduitTest {
	private int nbEtal;
	private Village village;
	private Chef chef;
	
	private ControlVerifierIdentite controlVerifierIdentite;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	
	private ControlAcheterProduit controleAcheterProduit;

	@BeforeEach
	void initTest() {
		nbEtal = 5;
		village = new Village("village de testarix", 10, nbEtal);
		chef = new Chef("Testarix", 10, village);
		village.setChef(chef);
		
		controlVerifierIdentite = new ControlVerifierIdentite(village);
		controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		
		controleAcheterProduit = new ControlAcheterProduit(controlVerifierIdentite, controlTrouverEtalVendeur, village);
	}
	
	
/*
 * 
 * Tests de la méthode ListEtalProduit
 * 
 * */
	@Test
	void testListEtalProduitNonTrouver() {
		String fleurs = new String("fleurs");
		controleAcheterProduit.listEtalProduit(fleurs);
		
		assertTrue(controleAcheterProduit.listEtalProduit(fleurs) == null);
	}
	
	@Test
	void testListEtalProduitTrouver() {
		
		String fleurs = new String("fleurs");
		
		Gaulois bonemine = new Gaulois("Bonemine", 97846531);
		village.installerVendeur(bonemine, fleurs, 20);
		
		controleAcheterProduit.listEtalProduit(fleurs);
		
		assertTrue(controleAcheterProduit.listEtalProduit(fleurs)[0].equals(bonemine));
	}
	
	@Test
	void testListEtalProduitTrouverMultiple() {
		
		String fleurs = new String("fleurs");
		
		Gaulois[] bonemines = new Gaulois[100];
		for(int i = 0;i<100;i++) {
			bonemines[i]= new Gaulois("bonemine n°"+i, 10);
			village.installerVendeur(bonemines[i], fleurs, 20);
		
		}
		Gaulois[] vendeurs = controleAcheterProduit.listEtalProduit(fleurs); 
		
		assert(vendeurs.length <= nbEtal);
		assert(0 < vendeurs.length);
	}
	
	@Test
	void testListEtalProduitMultiple() {
		
		Gaulois bonemine = new Gaulois("Bonemine", 20);
		Gaulois vendeurDePoissonrix = new Gaulois("VendeurDePoissonrix",1);
		
		village.installerVendeur(vendeurDePoissonrix, "poissons", 20);
		village.installerVendeur(bonemine, "fleurs", 665448);
		
		Gaulois[] vendeursPoisson = controleAcheterProduit.listEtalProduit("poissons");
		Gaulois[] vendeursFleurs = controleAcheterProduit.listEtalProduit("fleurs");
		
		assert(vendeursPoisson[0].equals(vendeurDePoissonrix));
		assert(vendeursFleurs[0].equals(bonemine));
		
		assert(vendeursPoisson.length == 1);
		assert(vendeursFleurs.length == 1);
		
	}



/*
 * 
 * Tests methode acheterGaulois
 * 
 * */
	@Test
	void testAcheterGaulois() {
		String fleurs = new String("fleurs");
		
		Gaulois bonemine = new Gaulois("Bonemine", 97846531);
		village.installerVendeur(bonemine, fleurs, 20);
		
		assert(controleAcheterProduit.acheterGaulois(bonemine, 5) == 5);
	}
	
	@Test
	void testAcheterGauloisPlusQueStock() {
		String fleurs = new String("fleurs");
		
		Gaulois bonemine = new Gaulois("Bonemine", 97846531);
		village.installerVendeur(bonemine, fleurs, 20);
		
		assert(controleAcheterProduit.acheterGaulois(bonemine, 784) == 20);
	}
	
	@Test
	void testAcheterGauloisStockVide() {
		String fleurs = new String("fleurs");
		
		Gaulois bonemine = new Gaulois("Bonemine", 97846531);
		village.installerVendeur(bonemine, fleurs, 0);
		
		assert(controleAcheterProduit.acheterGaulois(bonemine, 1) == 0);
	}

}