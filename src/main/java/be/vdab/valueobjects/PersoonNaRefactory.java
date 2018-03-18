package be.vdab.valueobjects;

import java.util.LinkedHashSet;
import java.util.Set;

public class PersoonNaRefactory {
	private Set<String> voornamen = new LinkedHashSet<>();
	
	public PersoonNaRefactory(Set<String> voornamen) {
		if (voornamen.isEmpty()) {
			throw new IllegalArgumentException("Foutmelding: u mag geen lege voornamenlijst ingeven.");
		}
		for (String voornaam : voornamen) {
			if (voornaam.isEmpty()) {
				throw new IllegalArgumentException("Foutmelding: u kan geen lege voornaam ingeven.");
			}
			if (voornaam.contains(" ")) {
				throw new IllegalArgumentException("Foutmelding: u kan geen voornaam met een blanco teken ingeven.");
			}
		this.voornamen = voornamen;	
		} 
	}
	
	@Override
	public String toString() {
		String zin = "";
		for (String voornaam : voornamen) {
			zin += " "+voornaam;
		}
		return zin.substring(1);
	}
}
