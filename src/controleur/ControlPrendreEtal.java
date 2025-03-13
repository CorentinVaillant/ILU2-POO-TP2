package controleur;

import personnages.Gaulois;
import villagegaulois.Village;

public class ControlPrendreEtal {
	private Village village;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlPrendreEtal(ControlVerifierIdentite controlVerifierIdentite,
			Village village) {
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.village = village;
	}

	public boolean resteEtals() {
		return this.village.rechercherEtalVide();
	}

	public int prendreEtal(String nomVendeur, String produit, int nbProduit) {
		Gaulois gaulois = this.village.trouverHabitant(nomVendeur);
		if (gaulois == null){
			//Si le gaulois n'est pas dans le village retourne -1
			return -1;
		}
		return this.village.installerVendeur(gaulois, produit, nbProduit);
	}

	public boolean verifierIdentite(String nomVendeur) {
		return this.controlVerifierIdentite.verifierIdentite(nomVendeur);
		
	}
}
