package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if (!vendeurReconnu){
			System.out
				.println("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
		}else{
			String[] donneEtal = controlLibererEtal.libererEtal(nomVendeur);
			String etalOccupe = donneEtal[0];
			if (etalOccupe.equals("true")){
				String produit = donneEtal[2];
				String quantiteInitial = donneEtal[3];
				String quantiteVendu = donneEtal[4];
				System.out.println(new StringBuilder()
					.append("Vous avez vendu ").append(quantiteVendu).append(" sur ").append(quantiteInitial).append(" ").append(produit).append(".\n")
					.append("En revoir ").append(nomVendeur).append(", passez une bonne journée.")
				);

			}
		}
	}

}
