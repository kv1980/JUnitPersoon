package be.vdab.valueobjects;

import static org.junit.Assert.assertEquals;

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

	@Test(expected = IllegalArgumentException.class)
	public void een_persoon_zonder_één_voornaam_bestaat_niet() {
		Persoon persoon = new Persoon(voornamen);
	}

	@Test
	public void een_persoon_kan_één_voornaam_hebben() {
		voornamen.add("Hans");
		Persoon persoon = new Persoon(voornamen);
	}

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

	@Test
	public void toString_geeft_String_met_enige_voornaam() {
		voornamen.add("Hans");
		Persoon persoon = new Persoon(voornamen);
		assertEquals("Hans", persoon.toString());
	}
	
	@Test
	public void toString_geeft_String_met_meerdere_voornamen_gescheiden_door_een_spatie_in_de_juiste_volgorde() {
		voornamen.add("Hans");
		voornamen.add("Kristof");
		Persoon persoon = new Persoon(voornamen);
		assertEquals("Hans Kristof", persoon.toString());
	}
}
