package frontiere;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		boolean nomVendeurConnu  = this.controlPrendreEtal.verifierIdentite(nomVendeur);
		if(!nomVendeurConnu){
			System.out
				.println("Je suis désolée " + nomVendeur + " mais il faut être un habitant de notre village pour commercer ici.");
		}else{
			System.out
				.println("Bonjour "+nomVendeur+" ,je vais regarder si je peux vous trouver une étale.");
			boolean etalDisponible = this.controlPrendreEtal.resteEtals();
			if(!etalDisponible) {
				System.out
					.println("Désolée" + nomVendeur + " je n'ai plus d'étal qui ne soit pas déjà occupé.");
			}else{
				this.installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		String produit = Clavier.entrerChaine
			("C'est parfait ! \nIl me faudrait quelques renseignements :\nQuel produit souhaitez vous vendre ?");
		int nbProduit = Clavier.entrerEntier("Combien souhaitez vous en vendre ?");

		int nbEtal = this.controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if (nbEtal != -1){
			System.out
				.println("Le vendeur"+nomVendeur+" s'est installer à l'étal n°"+(nbEtal+1));
		}
	}
}
