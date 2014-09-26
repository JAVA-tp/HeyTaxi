package heyTaxi;

import heyTaxi.HeyTaxi;

public class Calculer {

	private double resultat;
	
	public double CalculTarifs(int indice){
		if (HeyTaxi.saisies.getTypeTrajet() == 's') {
			if (HeyTaxi.saisies.getNuit() == 'n') {
				resultat = HeyTaxi.tarifs.get(indice).getPriseEnCharge() + (HeyTaxi.saisies.getKm() * HeyTaxi.tarifs.get(indice).getTarifKmAsSemaine());
				if (HeyTaxi.saisies.getDuree() > 60) {
					resultat = resultat + (HeyTaxi.tarifs.get(indice).getTarifHoraireJourSemaine() * (int)(HeyTaxi.saisies.getDuree() / 60));
				}
			}
			else {
				resultat = HeyTaxi.tarifs.get(indice).getPriseEnCharge() + (HeyTaxi.saisies.getKm() * HeyTaxi.tarifs.get(indice).getTarifKmAsNuitDimanche());
				if (HeyTaxi.saisies.getDuree() > 60) {
					resultat = resultat + (HeyTaxi.tarifs.get(indice).getTarifHoraireNuitDimanche() * (int)(HeyTaxi.saisies.getDuree() / 60));
				}
			}
		} else {
			if (HeyTaxi.saisies.getNuit() == 'n') {
				resultat = HeyTaxi.tarifs.get(indice).getPriseEnCharge() + (HeyTaxi.saisies.getKm() * HeyTaxi.tarifs.get(indice).getTarifKmArSemaine());
				if (HeyTaxi.saisies.getDuree() > 60) {
					resultat = resultat + (HeyTaxi.tarifs.get(indice).getTarifHoraireJourSemaine() * (int)(HeyTaxi.saisies.getDuree() / 60));
				}
			}
			else {
				resultat = HeyTaxi.tarifs.get(indice).getPriseEnCharge() + (HeyTaxi.saisies.getKm() * HeyTaxi.tarifs.get(indice).getTarifKmArNuitDimanche());
				if (HeyTaxi.saisies.getDuree() > 60) {
					resultat = resultat + (HeyTaxi.tarifs.get(indice).getTarifHoraireNuitDimanche() * (int)(HeyTaxi.saisies.getDuree() / 60));
				}
			}
		}
		
		return resultat;
	}
}
