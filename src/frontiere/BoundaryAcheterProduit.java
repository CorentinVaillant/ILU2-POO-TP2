package frontiere;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {

		if (!controlAcheterProduit.peutAcheterProduit(nomAcheteur)){
			System.out.println("Je suis désolée "+nomAcheteur+" mais il faut être un habitant de notre village pour commercer ici.");
			return;
		}

		String produit = Clavier.entrerChaine("Quel produit voulez-vous acheter ?");
		Gaulois[] listeVendeur = controlAcheterProduit.listEtalProduit(produit);

		if(listeVendeur == null || listeVendeur.length == 0){
			System.out.println("Je suis désolé nous ne vendons pas de cela ici.");
			return;
		}
		int choix = -1;
		StringBuilder builder = new StringBuilder()
		.append("Chez quel commerçant voulez-vous acheter des "+produit+" ?\n");
		
		int i = 1;
		for(Gaulois vendeur : listeVendeur){
			builder.append(i).append("-").append(vendeur.getNom()).append("\n");
			i++;
		}

		while (choix < 0 || choix > listeVendeur.length -1) {

			choix = Clavier.entrerEntier(builder.toString()) - 1;
			if (choix < 0 || choix > listeVendeur.length)
				System.out.println("Mais... Je ne vous est pas proposez ce choix 😡 ");
		}
		Gaulois vendeur = listeVendeur[choix];
		builder = new StringBuilder();

		builder.append(nomAcheteur).append(" se déplace jusqu'à l'étal du vendeur ").append(vendeur).append(".\n")
		.append("Bonjour Panoramix\n")
		.append("Combien de ").append(produit).append(" voulez-vous acheter ?");

		int nbProduit = Clavier.entrerEntier(builder.toString());

		int nbAchete = controlAcheterProduit.acheterGaulois(vendeur, nbProduit);

		if (nbAchete == 0)
			System.out.println(nomAcheteur + " veut acheter "+nbProduit+" "+produit+", malheureusement il n’y en a plus !");
		else if (nbAchete != nbProduit) 
			System.out.println(nomAcheteur + " veut acheter "+nbProduit+" "+produit+", malheureusement "+vendeur.getNom()+" n’en a plus que "+nbAchete+". "+nomAcheteur+" achète tout le stock de "+vendeur.getNom()+"."); 
		else
			System.out.println(nomAcheteur + " achète "+nbProduit+" "+produit+" à "+vendeur.getNom()+".");

		return;
	}
}
