package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

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

	public Gaulois[] listEtalProduit(String produit){

		return village.rechercherVendeursProduit(produit);
	}

	/**
	 * 
	 * @param vendeur
	 * @return le nombre acheter
	*/	 
	public int acheterGaulois(Gaulois vendeur,int quantite){
		Etal etal =controlTrouverEtalVendeur.trouverEtalVendeur(vendeur.getNom());

		return etal.acheterProduit(quantite);
	}

	public boolean peutAcheterProduit(String nomAcheteur){
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}

}
