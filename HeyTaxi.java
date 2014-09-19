package heyTaxi;

import java.util.Scanner;

public class HeyTaxi {

	static int dept, duree, km;
	static char dimanche, nuit, typeTrajet;

	static double[][] tarifs = {
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
		Scanner reader = new Scanner(System.in);

		System.out.println("Saisissez le département :");
		dept = reader.nextInt();
		System.out.println("Le trajet était-il un dimanche ? (o/n)");
		dimanche = reader.next().toLowerCase().charAt(0);
		System.out.println("Est-ce un trajet de nuit ? (o/n)");
		nuit = reader.next().toLowerCase().charAt(0);
		System.out.println("Aller simple ou aller/retour ? (S/R)");
		typeTrajet = reader.next().toLowerCase().charAt(0);
		System.out.println("Durée du trajet ? (en minute(s))");
		duree = reader.nextInt();
		System.out.println("Nombre de kilomètres parcourus ?");
		km = reader.nextInt();
	}

	public static void main(String[] args) {

		double resultat;

		Saisie();
		int indice = 0;
		for (int i = 0; i < 10; i++) { // Pour toutes les lignes du tableau,
			if (tarifs[i][0] == dept) // Si un departement correspond à celui saisie
				indice = i; // Stockage de l'indice de la ligne dans le tableau
		}

		if (typeTrajet == 's') {
			if (nuit == 'n') {
				resultat = tarifs[indice][1] + (km * tarifs[indice][3]);
				if (duree > 60) {
					resultat = resultat + (tarifs[indice][4] * (int)(duree / 60));
				}
			}
			else {
				resultat = tarifs[indice][1] + (km * tarifs[indice][6]);
				if (duree > 60) {
					resultat = resultat + (tarifs[indice][7] * (int)(duree / 60));
				}
			}
		} else {
			if (nuit == 'n') {
				resultat = tarifs[indice][1] + (km * tarifs[indice][2]);
				if (duree > 60) {
					resultat = resultat + (tarifs[indice][4] * (int)(duree / 60));
				}
			}
			else {
				resultat = tarifs[indice][1] + (km * tarifs[indice][5]);
				if (duree > 60) {
					resultat = resultat + (tarifs[indice][7] * (int)(duree / 60));
				}
			}
		}

		System.out.println("Prix a payer : " + resultat + "€");
	}
}
