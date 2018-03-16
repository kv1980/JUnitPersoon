package be.vdab.valueobjects;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class PersoonTest {
	private List<String> voornamen;

	@Before
	public void before() {
		voornamen = new ArrayList<>();
	}
	
	// EEN PERSOON HEEFT MINSTENS 1 VOORNAAM 
	
	@Test(expected = NullPointerException.class)
	public void de_lijst_met_voornamen_mag_niet_null_zijn() {
		Persoon persoon = new Persoon(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void een_persoon_heeft_minstens_één_voornaam() {
		Persoon persoon = new Persoon(voornamen);
	}

	@Test
	public void een_persoon_kan_één_voornaam_hebben() {
		voornamen.add("Hans");
		Persoon persoon = new Persoon(voornamen);
	}
	
	// EEN PERSOON KAN GEEN TWEE KEER DEZELFDE VOORNAAM HEBBEN

	@Test(expected = IllegalArgumentException.class)
	public void een_persoon_kan_geen_twee_gelijke_voornamen_hebben() {
		voornamen.add("Hans");
		voornamen.add("Hans");
		Persoon persoon = new Persoon(voornamen);
	}

	@Test
	public void een_persoon_kan_wel_meerdere_verschillende_voornamen_hebben() {
		voornamen.add("Hans");
		voornamen.add("Kristof");
		Persoon persoon = new Persoon(voornamen);
	}
	
	// EEN VOORNAAM MOET MINSTENS 1 NIET-BLANCO TEKEN BEVATTEN
	
	@Test(expected = NullPointerException.class)
	public void geen_enkele_voornaam_mag_null_zijn() {
		voornamen.add(null);
		Persoon persoon = new Persoon(voornamen);
	}

	@Test(expected = IllegalArgumentException.class)
	public void geen_enkele_voornaam_mag_leeg_zijn() {
		voornamen.add("Hans");
		voornamen.add("");
		Persoon persoon = new Persoon(voornamen);
	}

	@Test(expected = IllegalArgumentException.class)
	public void geen_enkele_voornaam_mag_een_blanco_teken_bevatten() {
		voornamen.add("Hans");
		voornamen.add("Kristof ");
		Persoon persoon = new Persoon(voornamen);
	}
	
	// DE toString METHOD MOET EEN STRING TERUGGEVEN DIE BESTAAT UIT
	// ALLE VOORNAMEN VAN DIE PERSOON, GESCHEIDEN DOOR EEN SPATIE
	// DE VOLGORDE VAN DE VOORNAMEN MOET GELIJK ZIJN AAN DE VOLGORDE ZOALS ZE
	// IN DE CONSTRUCTOR PARAMETER WERDEN MEEGEGEVEN.

	@Test
	public void toString_geeft_String_met_enige_voornaam() {
		voornamen.add("Hans");
		Persoon persoon = new Persoon(voornamen);
		assertEquals("Hans", persoon.toString());
	}
	
	@Test
	public void toString_geeft_String_met_meerdere_voornamen_met_spaties_ertussen() {
		voornamen.add("Hans");
		voornamen.add("Kristof");
		Persoon persoon = new Persoon(voornamen);
		assertTrue(persoon.toString().equals("Hans Kristof"));
		assertFalse(persoon.toString().equals("HansKristof"));
	}
	
	@Test
	public void toString_geeft_String_met_meerdere_voornamen_in_de_volgorde_zoals_ingegeven() {
		voornamen.add("Hans");
		voornamen.add("Kristof");
		Persoon persoon = new Persoon(voornamen);
		assertTrue(persoon.toString().equals("Hans Kristof"));
		assertFalse(persoon.toString().equals("Kristof Hans"));
	}
}
