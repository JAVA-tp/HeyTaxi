package heyTaxi;

import java.util.Scanner;

public class Saisies {
	private int dept, duree, km;
	private char dimanche, nuit, typeTrajet;
	
	Scanner reader = new Scanner(System.in);
	
	
	public void Saisies(){
		System.out.println("Saisissez le département :");
		dept = reader.nextInt();
		
		System.out.println("Durée du trajet ? (en minute(s))");
		duree = reader.nextInt();
		
		System.out.println("Nombre de kilomètres parcourus ?");
		km = reader.nextInt();
	
		System.out.println("Le trajet était-il un dimanche ? (o/n)");
		dimanche = reader.next().toLowerCase().charAt(0);
	
		System.out.println("Est-ce un trajet de nuit ? (o/n)");
		nuit = reader.next().toLowerCase().charAt(0);
	
		System.out.println("Aller simple ou aller/retour ? (S/R)");
		typeTrajet = reader.next().toLowerCase().charAt(0);
	}
	
	
	/**
	 * Accesseur du numéro de département
	 * @return Le numéro du département [entier]
	 */
	public int getDept() {
		return dept;
	}
	
	public void setDept(int departement) {
		this.dept = departement;
	}
	
	/**
	 * Accesseur de la duree du trajet
	 * @return duree [int]
	 */
	public int getDuree(){
		return duree;
	}
	
	public void setDuree(int duree) {
		this.duree = duree;
	}
	
	/**
	 * Accesseur du nombre de km
	 * @return km [int]
	 */
	public int getKm(){
		return km;
	}
	
	public void setKm(int km) {
		this.km = km;
	}
	
	/**
	 * Accesseur du jour
	 * @return dimanche [char]
	 */
	public char getDimanche(){
		return dimanche;
	}
	
	public void setDimanche(char dimanche) {
		this.dimanche = dimanche;
	}
	
	/**
	 * Accesseur de l'heure
	 * @return nuit [char]
	 */
	public char getNuit(){
		return nuit;
	}
	
	public void setNuit(char nuit) {
		this.nuit = nuit;
	}
	
	/**
	 * Accesseur du type de trajet
	 * @return typeTrajet [char]
	 */
	public char getTypeTrajet(){
		return typeTrajet;
	}
	
	public void setTypeTrajet(char typeTrajet) {
		this.typeTrajet = typeTrajet;
	}
}
