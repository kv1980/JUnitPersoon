package be.vdab.valueobjects;

import java.util.ArrayList;
import java.util.List;

public class Persoon {
	private List<String> voornamen = new ArrayList<>();
	
	public Persoon(List<String> voornamen) {
		if (voornamen.isEmpty() || voornamen==null) {
			throw new IllegalArgumentException("Foutmelding: de voornamenlijst is leeg.");
		} 
		if (valideer(voornamen)) {
			this.voornamen = voornamen;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder zin = new StringBuilder();
		for (String voornaam : voornamen) {
			zin.append(" ");
			zin.append(voornaam);
		}
		return zin.substring(1).toString();
	}
	
	private boolean valideer(List<String> voornamen) {
		boolean eenVoornaamIsLeeg = false;
		boolean eenVoornaamBevatEenBlancoTeken = false;	
		boolean eenVoornaamKomtMeerdereKerenVoor = false;	
		for (String voornaam : voornamen) {
			if (voornaam.isEmpty()) {
				eenVoornaamIsLeeg = true;
			}
			if (voornaam.contains(" ")) {
				eenVoornaamBevatEenBlancoTeken = true;
			}
			if (voornamen.indexOf(voornaam)!=voornamen.lastIndexOf(voornaam)) {
				eenVoornaamKomtMeerdereKerenVoor = true;
			}
		}
		if (eenVoornaamIsLeeg) {
			throw new IllegalArgumentException("Foutmelding: minstens een van de voornamen is leeg.");
		}
		if (eenVoornaamBevatEenBlancoTeken) {
			throw new IllegalArgumentException("Foutmelding: minstens een van de voornamen is bevat een blanco teken.");
		}
		if (eenVoornaamKomtMeerdereKerenVoor) {
			throw new IllegalArgumentException("Foutmelding: minstens een van de voornamen komt meerdere keren voor.");
		}
		return !eenVoornaamIsLeeg && !eenVoornaamBevatEenBlancoTeken && !eenVoornaamKomtMeerdereKerenVoor;
	}
}
