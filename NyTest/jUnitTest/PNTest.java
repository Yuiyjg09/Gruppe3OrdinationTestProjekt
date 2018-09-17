package jUnitTest;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import ordination.Laegemiddel;
import ordination.PN;
import ordination.Patient;
import service.Service;
import sun.font.CreatedFontTracker;

public class PNTest {
	private Service service = Service.getTestService();

	@Before
	public void setup() throws Exception {
		Service.getTestService().createSomeObjects();
		ArrayList<Patient> patienter = new ArrayList<>();
		ArrayList<Laegemiddel> laegemidler = new ArrayList<>();
	}

	@Test
	public void testSamletDosis() {
		double antalEnheder = 12;
		double antalGangeGivet = 6;
		double result = antalEnheder * antalGangeGivet;

		assertEquals(72, result, 0.001);
	}

	@Test
	public void testDoegnDosis() {
		double result = 0;
		double antalGangeGivet = 4;
		double antalEnheder = 2;
		double daysBetween = 0;
		LocalDate startTid = LocalDate.of(2018, 5, 20);
		LocalDate slutTid = LocalDate.of(2018, 5, 24);
		daysBetween = ChronoUnit.DAYS.between(startTid, slutTid);

		result = (antalGangeGivet * antalEnheder) / daysBetween;

		assertNotNull(antalGangeGivet);
		assertEquals(2, result, 0.001);
	}

	@Test
	public void testGivDosis() {
		LocalDate startTid = LocalDate.of(2018, 5, 20);
		LocalDate slutTid = LocalDate.of(2018, 5, 26);
		LocalDate givesDen = LocalDate.of(2018, 5, 21);

		assertTrue(givesDen.isAfter(startTid));
		assertTrue(givesDen.isBefore(slutTid));
		assertFalse(givesDen.isBefore(startTid));
		assertFalse(givesDen.isAfter(slutTid));
	}
}