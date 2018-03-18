package be.vdab.valueobjects;

import static org.junit.Assert.*;

import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class PersoonNaRefactoryTest {
	private Set<String> voornamen;

	@Before
	public void before() {
		voornamen = new LinkedHashSet<>();
	}
	
	@Test(expected = NullPointerException.class)
	public void de_lijst_met_voornamen_mag_niet_null_zijn() {
		new PersoonNaRefactory(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void de_lijst_met_voornamen_mag_niet_leeg_zijn(){
		new PersoonNaRefactory(voornamen);
	}

	@Test
	public void een_persoon_kan_één_voornaam_hebben() {
		voornamen.add("Hans");
		new PersoonNaRefactory(voornamen);
	}

	@Test
	public void een_persoon_kan_geen_twee_gelijke_voornamen_hebben() {
		voornamen.add("Hans");
		voornamen.add("Hans");
		PersoonNaRefactory persoon = new PersoonNaRefactory(voornamen);
		assertTrue(persoon.toString().equals("Hans"));
	}

	@Test
	public void een_persoon_kan_wel_meerdere_verschillende_voornamen_hebben() {
		voornamen.add("Hans");
		voornamen.add("Kristof");
		new PersoonNaRefactory(voornamen);
	}
	
	@Test(expected = NullPointerException.class)
	public void geen_enkele_voornaam_mag_null_zijn() {
		voornamen.add(null);
		new PersoonNaRefactory(voornamen);
	}

	@Test(expected = IllegalArgumentException.class)
	public void geen_enkele_voornaam_mag_leeg_zijn() {
		voornamen.add("");
		new PersoonNaRefactory(voornamen);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void geen_enkele_voornaam_mag_een_blanco_teken_zijn() {
		voornamen.add(" ");
		new PersoonNaRefactory(voornamen);
	}

	@Test(expected = IllegalArgumentException.class)
	public void geen_enkele_voornaam_mag_een_blanco_teken_bevatten() {
		voornamen.add("Hans ");
		new PersoonNaRefactory(voornamen);
	}

	@Test
	public void toString_geeft_String_met_enige_voornaam() {
		voornamen.add("Hans");
		PersoonNaRefactory persoon = new PersoonNaRefactory(voornamen);
		assertEquals("Hans", persoon.toString());
	}
	
	@Test
	public void toString_geeft_String_met_meerdere_voornamen_met_spaties_ertussen() {
		voornamen.add("Hans");
		voornamen.add("Kristof");
		PersoonNaRefactory persoon = new PersoonNaRefactory(voornamen);
		assertTrue(persoon.toString().equals("Hans Kristof"));
		assertFalse(persoon.toString().equals("HansKristof"));
	}
	
	@Test
	public void toString_geeft_String_met_meerdere_voornamen_in_de_volgorde_zoals_ingegeven() {
		voornamen.add("Hans");
		voornamen.add("Kristof");
		PersoonNaRefactory persoon = new PersoonNaRefactory(voornamen);
		assertTrue(persoon.toString().equals("Hans Kristof"));
		assertFalse(persoon.toString().equals("Kristof Hans"));
	}
}
