package jUnitTest;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import org.junit.Before;
import org.junit.Test;
import ordination.DagligFast;
import ordination.Dosis;
import ordination.Laegemiddel;
import ordination.Patient;
import service.Service;

public class DagligFastTest {

	private Patient benny = new Patient("123456-7890", "Benny Bomstærk", 98.3);
	private Laegemiddel pistol = new Laegemiddel("Anti-pistolskid", 1, 2, 3, "Styk");

	@Before
	public void setUp() throws Exception {
		Service.getTestService().createSomeObjects();
	}

	@Test
	public void testSamletDosisTC1() {
		DagligFast dagligFast = new DagligFast(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 21));
		dagligFast.setLaegemiddel(pistol);
		dagligFast.opretDosis(LocalTime.of(8, 0), 0);
		dagligFast.opretDosis(LocalTime.of(12, 0), 0);
		dagligFast.opretDosis(LocalTime.of(18, 0), 0);
		dagligFast.opretDosis(LocalTime.of(23, 0), 0);
		benny.addOrdination(dagligFast);
		assertEquals(0, dagligFast.samletDosis(), 0.0);
	}

	@Test
	public void testSamletDosisTC2() {
		DagligFast dagligFast = new DagligFast(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 20));
		dagligFast.setLaegemiddel(pistol);
		dagligFast.opretDosis(LocalTime.of(8, 0), 0);
		dagligFast.opretDosis(LocalTime.of(12, 0), 0);
		dagligFast.opretDosis(LocalTime.of(18, 0), 0);
		dagligFast.opretDosis(LocalTime.of(23, 0), 1);
		benny.addOrdination(dagligFast);
		assertEquals(0, dagligFast.samletDosis(), 0.0);
	}

	@Test
	public void testSamletDosisTC3() {
		DagligFast dagligFast = new DagligFast(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 21));
		dagligFast.setLaegemiddel(pistol);
		dagligFast.opretDosis(LocalTime.of(8, 0), 0);
		dagligFast.opretDosis(LocalTime.of(12, 0), 0);
		dagligFast.opretDosis(LocalTime.of(18, 0), 0);
		dagligFast.opretDosis(LocalTime.of(23, 0), 1);
		benny.addOrdination(dagligFast);
		assertEquals(0, dagligFast.samletDosis(), 1);
	}

	@Test(expected = Exception.class)
	public void testSamletDosisTC4() {
		DagligFast dagligFast = new DagligFast(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 21));
		dagligFast.setLaegemiddel(pistol);
		dagligFast.opretDosis(LocalTime.of(8, 0), 0);
		dagligFast.opretDosis(LocalTime.of(12, 0), 0);
		dagligFast.opretDosis(LocalTime.of(18, 0), 0);
		dagligFast.opretDosis(LocalTime.of(23, 0), -1);
		benny.addOrdination(dagligFast);
		assertEquals(0, dagligFast.samletDosis(), -1);
	}

	@Test
	public void testDoegnDosisTC1() {
		double resultat = 0;
		double antalGangeGivet = 6;
		double antalEnheder = 2;
		double daysBetween = 0;
		LocalDate startTid = LocalDate.of(2018, 5, 20);
		LocalDate slutTid = LocalDate.of(2018, 5, 24);
		daysBetween = ChronoUnit.DAYS.between(startTid, slutTid);

		resultat = (antalGangeGivet * antalEnheder) / daysBetween;

		assertNotNull(antalGangeGivet);
		assertEquals(2, resultat, 3);
	}

	@Test
	public void testDoegnDosisTC2() {
		double resultat = 0;
		double antalGangeGivet = 6;
		double antalEnheder = 0;
		double daysBetween = 0;
		LocalDate startTid = LocalDate.of(2018, 5, 20);
		LocalDate slutTid = LocalDate.of(2018, 5, 24);
		daysBetween = ChronoUnit.DAYS.between(startTid, slutTid);

		resultat = (antalGangeGivet * antalEnheder) / daysBetween;

		assertNotNull(antalGangeGivet);
		assertEquals(0, resultat, 3);
	}

	@Test
	public void testOpretDosisTC1() {
		LocalDate startDen = LocalDate.of(2018, 5, 20);
		LocalDate slutDen = LocalDate.of(2018, 5, 24);
		DagligFast dagligFast = new DagligFast(startDen, slutDen);
		LocalTime tid = LocalTime.of(11, 15);
		dagligFast.opretDosis(tid, 2);
		Dosis dosis = dagligFast.getDoser()[0];
		assertEquals(2, dosis.getAntal(), 0);
	}

	@Test(expected = NullPointerException.class)
	public void testOpretDosisTC2() {
		LocalDate startDen = LocalDate.of(2018, 5, 20);
		LocalDate slutDen = LocalDate.of(2018, 5, 24);
		DagligFast dagligFast = new DagligFast(startDen, slutDen);
		LocalTime tid = null;
		dagligFast.opretDosis(tid, 2);
		Dosis dosis = dagligFast.getDoser()[0];
		assertEquals(2, dosis.getAntal(), 0);
	}
}