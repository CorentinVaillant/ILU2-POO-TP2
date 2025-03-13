package controleur;

import personnages.Gaulois;
import villagegaulois.Etal;
import villagegaulois.Village;

public class ControlTrouverEtalVendeur {
	private Village village;

	public ControlTrouverEtalVendeur(Village village) {
		this.village = village;
	}

	public Etal trouverEtalVendeur(String nomVendeur) {
		Gaulois gaulois = this.village.trouverHabitant(nomVendeur);
		if (gaulois != null){
			return this.village.rechercherEtal(gaulois);
		}else{
			return null;
		}
	}
}
