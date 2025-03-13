package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		if (!this.controlLibererEtal.isVendeur(nomVendeur)){
			System.out
				.println("Mais vous êtes déjà inscrit sur notre marché aujourd'hui !");
		}else{
			String[] donneEtal = this.controlLibererEtal.libererEtal(nomVendeur);
			if(donneEtal !=null){
				//? https://moodle.univ-tlse3.fr/pluginfile.php/671301/mod_resource/content/3/TP2-6-LibérerEtal.pdf
				//TP2-6
			}
		}
	}

}
