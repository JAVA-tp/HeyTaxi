package version5;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.JLabel;
import heyTaxi.*;

public class Graph extends JFrame {

	private JPanel contentPane;
	private JTextField txtBoxDept;
	private JButton btnReset;
	private JButton btnRecher;
	private JButton btnCalculer;
	private JTextField txtBoxNbKm;
	private JTextField txtBoxDuree;
	private JLabel lblDept;
	private JLabel lblNbKm;
	private JLabel lblDuree;
	private JLabel lblDeptInconnu;
	private JRadioButton rdbtnJour, rdbtnNuit,rdbtnSemaine,rdbtnWeekend,rdbtnAllerSimple,rdbtnAllerRetour;
	private JLabel lblPrix;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//System.out.print("Hello Word");
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Graph frame = new Graph();
					frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Graph() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 385);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnRecher = new JButton("Rechercher");
		btnRecher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNbKm.setEnabled(true);
				lblDuree.setEnabled(true);
				txtBoxNbKm.setEnabled(true);
				txtBoxDuree.setEnabled(true);
				txtBoxDept.setEnabled(true);
				rdbtnJour.setEnabled(true);
				rdbtnNuit.setEnabled(true);
				rdbtnSemaine.setEnabled(true);
				rdbtnWeekend.setEnabled(true);
				rdbtnAllerSimple.setEnabled(true);
				rdbtnAllerRetour.setEnabled(true);
				btnCalculer.setEnabled(true);
				heyTaxi.HeyTaxi.saisies.setDept(Integer.parseInt(txtBoxDept.getText()));
			}
		});
    	btnRecher.setBounds(234, 37, 117, 25);
		contentPane.add(btnRecher);
	
		btnCalculer = new JButton("Calculer");
		btnCalculer.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent arg0) {
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
								
								heyTaxi.HeyTaxi.tarifs.add(new Tarifs(curseurResultat.getInt("departement"),curseurResultat.getDouble("prisEnCharge"),curseurResultat.getDouble("tarifKmArSemaine"),curseurResultat.getDouble("tarifKmAsSemaine"),
										curseurResultat.getDouble("tarifHoraireJourSemaine"),curseurResultat.getDouble("tarifKmArNuitDimanche"),curseurResultat.getDouble("tarifKmAsNuitDimanche"),curseurResultat.getDouble("tarifHoraireNuitDimanche")));
			    			}
			    			
							curseurResultat.close();
							maConnexion.close();
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
				
		 	int i;
			boolean saisieOK = false;

			do{
				boolean trouve = false;
				i = 0;

				while(!trouve && i<heyTaxi.HeyTaxi.tarifs.size()){
					if(Integer.parseInt(txtBoxDept.getText())==heyTaxi.HeyTaxi.tarifs.get(i).getDept()){
						trouve = true;
					}else{
						i++;
					}
				}

				if(trouve){
					saisieOK = true;
				}
				else{
					Scanner deptObjet = new Scanner(System.in);
					txtBoxDept.setText("");
					lblDeptInconnu.setVisible(true);
				}
			}while(!saisieOK);

			int tps = 0;
			try{
				tps = Integer.parseInt(txtBoxDuree.getText());
			}catch (Exception e2) {
				System.exit(0);
			}

			int km = 0;
			try{
				km = Integer.parseInt(txtBoxNbKm.getText());
			}catch (Exception e3) {
				System.exit(0);
			}
			lblPrix.setText("Prix a payer :  %.2f" + heyTaxi.HeyTaxi.calcul.CalculTarifs(heyTaxi.HeyTaxi.Finder()) + "€");
			lblPrix.setVisible(true);
		 	}
			
		});
		
		
		btnCalculer.setBounds(185, 274, 117, 25);
		contentPane.add(btnCalculer);
		btnCalculer.setEnabled(false);
		
	
		btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				txtBoxDept.setText(null);
				txtBoxNbKm.setText(null);
				txtBoxDuree.setText(null);
				rdbtnJour.setSelected(false);
				rdbtnNuit.setSelected(false);
				rdbtnSemaine.setSelected(false);
				rdbtnWeekend.setSelected(false);
				rdbtnAllerSimple.setSelected(false);
				rdbtnAllerRetour.setSelected(false);
			}
		});
		btnReset.setBounds(363, 37, 117, 25);
		contentPane.add(btnReset);
		
		txtBoxDept = new JTextField();
		txtBoxDept.setBounds(183, 40, 39, 19);
		contentPane.add(txtBoxDept);
		txtBoxDept.requestFocus();
		txtBoxDept.setColumns(10);
		
		txtBoxNbKm = new JTextField();
		txtBoxNbKm.setBounds(268, 84, 61, 19);
		contentPane.add(txtBoxNbKm);
		txtBoxNbKm.setColumns(10);
		txtBoxNbKm.setEnabled(false);
		
		txtBoxDuree = new JTextField();
		txtBoxDuree.setColumns(10);
		txtBoxDuree.setBounds(268, 125, 61, 19);
		contentPane.add(txtBoxDuree);
		txtBoxDuree.setEnabled(false);
		
		rdbtnJour = new JRadioButton("Jour");
		rdbtnJour.setBounds(12, 154, 53, 23);
		contentPane.add(rdbtnJour);
	    rdbtnJour.setEnabled(false);
		
		rdbtnNuit = new JRadioButton("Nuit");
		rdbtnNuit.setBounds(132, 154, 61, 23);
		contentPane.add(rdbtnNuit);
		rdbtnNuit.setEnabled(false);
		
		rdbtnSemaine = new JRadioButton("Semaine");
		rdbtnSemaine.setBounds(12, 183, 86, 23);
		contentPane.add(rdbtnSemaine);
		rdbtnSemaine.setEnabled(false);
		
		rdbtnWeekend = new JRadioButton("Week-end");
		rdbtnWeekend.setBounds(132, 184, 97, 21);
		contentPane.add(rdbtnWeekend);
		rdbtnWeekend.setEnabled(false);
		
		rdbtnAllerSimple = new JRadioButton("Aller simple");
		rdbtnAllerSimple.setBounds(12, 215, 117, 23);
		contentPane.add(rdbtnAllerSimple);
		rdbtnAllerSimple.setEnabled(false);
		
		rdbtnAllerRetour = new JRadioButton("Aller retour");
		rdbtnAllerRetour.setBounds(133, 215, 106, 23);
		contentPane.add(rdbtnAllerRetour);
		rdbtnAllerRetour.setEnabled(false);
		
		lblDept = new JLabel("Saisir département :");
		lblDept.setBounds(12, 42, 153, 15);
		contentPane.add(lblDept);
		
		lblNbKm = new JLabel("Nombre de kilomètres à parcourir");
		lblNbKm.setBounds(12, 85, 238, 17);
		contentPane.add(lblNbKm);
		lblNbKm.setEnabled(false);
		
		lblDuree = new JLabel("Durée du trajet ? (en minutes)");
		lblDuree.setEnabled(false);
		lblDuree.setBounds(12, 127, 227, 15);
		contentPane.add(lblDuree);
		
		lblDeptInconnu = new JLabel("Erreur : Département inconnu.");
		lblDeptInconnu.setBounds(195, 311, 160, 15);
		contentPane.add(lblDeptInconnu);
	
		lblPrix = new JLabel("");
		lblPrix.setBounds(12, 311, 70, 15);
		contentPane.add(lblPrix);
		
	}
}
