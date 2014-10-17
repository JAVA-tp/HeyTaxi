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

	public static Saisies saisies = new Saisies();
	public static Calculer calcul = new Calculer();
	public static List<Tarifs> tarifs = new ArrayList<Tarifs>();

	
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
		
		try{
			Class.forName("org.postgresql.Driver");
		}
		catch (Exception e){
			System.out.println("Impossible de charger le driver");
		}
		
		try{
			String url = "jdbc:postgresql://172.16.99.2:5432/tdabre";
			Connection maConnexion = DriverManager.getConnection(url, "t.dabre", "pass123");
			
			try{
				Statement maRequete = maConnexion.createStatement();
				
				try{
					String texteRequete = "select * from \"HeyTaxi\".tarif";
					ResultSet curseurResultat = maRequete.executeQuery(texteRequete);
					ResultSetMetaData detailsDonnees = curseurResultat.getMetaData();
					
					while(curseurResultat.next()){
						
						tarifs.add(new Tarifs(curseurResultat.getInt("departement"),curseurResultat.getDouble("prisEnCharge"),curseurResultat.getDouble("tarifKmArSemaine"),curseurResultat.getDouble("tarifKmAsSemaine"),
								curseurResultat.getDouble("tarifHoraireJourSemaine"),curseurResultat.getDouble("tarifKmArNuitDimanche"),curseurResultat.getDouble("tarifKmAsNuitDimanche"),curseurResultat.getDouble("tarifHoraireNuitDimanche")));
	    			}
					curseurResultat.close();
					maConnexion.close();
					
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
	}
}
