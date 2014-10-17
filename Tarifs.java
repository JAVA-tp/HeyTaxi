package heyTaxi;

public class Tarifs {

	private int dept;
	private double priseEnCharge;
	private double tarifKmArSemaine;
	private double tarifKmAsSemaine;
	private double tarifHoraireJourSemaine;
	private double tarifKmArNuitDimanche;
	private double tarifKmAsNuitDimanche;
	private double tarifHoraireNuitDimanche;
	

	public Tarifs(int dept, double priseEnCharge, double tarifKmArSemaine, double tarifKmAsSemaine, double tarifHoraireJourSemaine, double tarifKmArNuitDimanche, double tarifKmAsNuitDimanche, double tarifHoraireNuitDimanche){
		this.dept = dept;
		this.priseEnCharge = priseEnCharge;
		this.tarifKmArSemaine = tarifKmArSemaine;
		this.tarifKmAsSemaine = tarifKmAsSemaine;
		this.tarifHoraireJourSemaine = tarifHoraireJourSemaine;
		this.tarifKmArNuitDimanche = tarifKmArNuitDimanche;
		this.tarifKmAsNuitDimanche = tarifKmAsNuitDimanche;
		this.tarifHoraireNuitDimanche = tarifHoraireNuitDimanche;
	}
	
	/**
	 * Accesseur du numéro de département
	 * @return Le numéro du département [entier]
	 */
	public int getDept() {
		return dept;
	}
	
	/**
	 * Accesseur du tarif de prise en charge
	 * @return tarif de la prise en charge [double]
	 */
	public double getPriseEnCharge(){
		return priseEnCharge;
	}
	
	/**
	 * Accesseur du tarif km aller/retour en semaine
	 * @return tarif du km aller/retour en semaine [double]
	 */
	public double getTarifKmArSemaine(){
		return tarifKmArSemaine;
	}
	
	/**
	 * Accesseur du tarif km aller simple en semaine
	 * @return tarif du km aller simple en semaine [double]
	 */
	public double getTarifKmAsSemaine(){
		return tarifKmAsSemaine;
	}
	
	/**
	 * Accesseur du tarif horaire de jour en semaine
	 * @return tarif horaire de jour & en semaine [double]
	 */
	public double getTarifHoraireJourSemaine(){
		return tarifHoraireJourSemaine;
	}
	
	/**
	 * Accesseur du tarif km aller/retour de nuit & le dimanche
	 * @return tarif km aller/retour de nuit le dimanche [double]
	 */
	public double getTarifKmArNuitDimanche(){
		return tarifKmArNuitDimanche;
	}
	
	/**
	 * Accesseur du tarif km aller simple de nuit & le dimanche
	 * @return tarif km aller simple de nuit le dimanche[double] 
	 */
	public double getTarifKmAsNuitDimanche(){
		return tarifKmAsNuitDimanche;
	}
	
	/**
	 * Accesseur du tarif horaire nuit le dimanche
	 * @return tarif horaire la nuit le dimanche [double]
	 */
	public double getTarifHoraireNuitDimanche(){
		return tarifHoraireNuitDimanche;
	}
	

}
