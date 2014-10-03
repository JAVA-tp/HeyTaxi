package heyTaxi;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import heyTaxi.Tarifs;
import heyTaxi.Saisies;
import heyTaxi.Calculer;

public class HeyTaxi {

	static Saisies saisies = new Saisies();
	static Calculer calcul = new Calculer();
	static List<Tarifs> tarifs = new ArrayList<Tarifs>();


	
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
		
		
		/*
		for(int i=0; i < array_tarifs.length; i++){
			tarifs.add(new Tarifs((int)(array_tarifs[i][0]), array_tarifs[i][1], array_tarifs[i][2], array_tarifs[i][3], array_tarifs[i][4], array_tarifs[i][5], array_tarifs[i][6], array_tarifs[i][7]));
		}
		 */
		
		try{
			Class.forName("org.postgresql.Driver");
		}
		catch (Exception e){
			System.out.println("Impossible de charger le driver");
		}
		
		try{
			String url = "jdbc:postgresql://172.16.99.2:5432/tdabre";
			Connection maConnexion = DriverManager.getConnection(url, "Anonymous", "CeciNestPasMOnMotDePasse");
			
			try{
				Statement maRequete = maConnexion.createStatement();
				
				try{
					String texteRequete = "select * from \"HeyTaxi\".tarif";
					ResultSet curseurResultat = maRequete.executeQuery(texteRequete);
					ResultSetMetaData detailsDonnees = curseurResultat.getMetaData();
					
					while(curseurResultat.next())
	    			{
						
	    			}
	    			
					System.out.print("Prix a payer : ");
					System.out.printf("%.2f", calcul.CalculTarifs(Finder()));
					System.out.println(" €");
				}
				catch(Exception e){
					System.out.println("Impossible d'executer la requete");
				}
				
			}
			catch (Exception e){
				System.out.println("Impossible de stocker le texte des requetes");
			}
		}
		catch (Exception e){
			System.out.println("Impossible d'établir une connexion");
		}
		saisies.Saisies();
	}
}
