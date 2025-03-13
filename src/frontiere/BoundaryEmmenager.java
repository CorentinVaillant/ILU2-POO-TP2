package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					System.out.println("Bienvenue villageois" + nomVisiteur);
					int force = Clavier.entrerEntier("Quelle est votre force ?");
					this.controlEmmenager.ajouterGaulois(nomVisiteur, force);
					break;

				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder builder = new StringBuilder();
		builder.append("Bienvenue Druide").append(nomVisiteur).append("\n Quelle est votre force ?");

		int forceDruide = Clavier.entrerEntier(builder.toString());

		int effetPotionMin = 0;
		int effetPotionMax = -1;

		while (effetPotionMax < effetPotionMin) { 
			effetPotionMin = Clavier.entrerEntier("Quelle est la force de potion la plus faible que vous produiez ?");
			effetPotionMax = Clavier.entrerEntier("Quelle est la force de potion la plus forte que vous produiez ?");

			if (effetPotionMax < effetPotionMin){
				System.out.println("Attention Druide, vous vous êtes trompé entre le min et le max !");
			}

		}
		this.controlEmmenager.ajouterDruide(nomVisiteur, forceDruide, effetPotionMin, effetPotionMax);
	}
}
