package heyTaxi;

import java.util.ArrayList;
import java.util.List;
import heyTaxi.Tarifs;
import heyTaxi.Saisies;
import heyTaxi.Calculer;

public class HeyTaxi {

	static Saisies saisies = new Saisies();
	static Calculer calcul = new Calculer();
	static List<Tarifs> tarifs = new ArrayList<Tarifs>();
	
	static double[][] array_tarifs = {
			{ 21, 2, 0.86, 1.72, 21.93, 1.29, 2.58, 21.93 },
			{ 25, 2.1, 0.83, 1.66, 22.5, 1.2, 2.4, 22.5 },
			{ 39, 2.1, 0.83, 1.66, 22.5, 1.23, 2.46, 25 },
			{ 44, 2.2, 0.79, 1.58, 24.19, 1.19, 2.37, 24.19 },
			{ 72, 2.15, 0.79, 1.58, 22.86, 1.19, 2.38, 22.86 },
			{ 73, 2.4, 0.84, 1.68, 25.4, 1.26, 2.52, 25.4 },
			{ 74, 3.15, 0.92, 1.84, 17.3, 1.38, 2.76, 17.3 },
			{ 75, 2.5, 1, 1.24, 0.0, 1.5, 1.5, 0.0 },
			{ 85, 2.3, 0.8, 1.6, 22.2, 1.2, 2.4, 22.2 },
			{ 90, 2.2, 0.83, 1.66, 21, 1.15, 2.3, 21 } };

	public static void Saisie() {
		saisies.SaisiesDept();
		saisies.SaisiesTypeTrajet();
		saisies.SaisiesDimanche();
		saisies.SaisiesNuit();
		saisies.SaisiesDuree();
		saisies.SaisiesKm();
	}
	
	public static int Finder(){
		int indice = -1;
		for (int i = 0; i < 10; i++) { // Pour toutes les lignes du tableau,
			if (tarifs.get(i).getDept() == saisies.getDept()){ // Si un departement correspond à celui saisie
				indice = i; // Stockage de l'indice de la ligne dans le tableau
				break;
			}
		}
		return indice;
	}
	
	public static void main(String[] args) {
		
		double resultat;
		
		for(int i=0; i < array_tarifs.length; i++){
			tarifs.add(new Tarifs((int)(array_tarifs[i][0]), array_tarifs[i][1], array_tarifs[i][2], array_tarifs[i][3], array_tarifs[i][4], array_tarifs[i][5], array_tarifs[i][6], array_tarifs[i][7]));
		}

		Saisie();
		
		if(Finder() != -1)
			System.out.println("Prix a payer : " + calcul.CalculTarifs(Finder()) + "€");
		else
			System.out.println("Erreur ! Il n'y a pas de taxi par ici !");
	}
}
