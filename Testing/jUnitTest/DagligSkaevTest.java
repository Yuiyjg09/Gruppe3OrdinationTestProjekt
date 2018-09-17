package jUnitTest;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import org.junit.Before;
import org.junit.Test;

import ordination.DagligFast;
import ordination.DagligSkaev;
import ordination.Dosis;
import ordination.Laegemiddel;
import ordination.Patient;
import service.Service;

public class DagligSkaevTest {

	private Patient benny = new Patient("123456-7890", "Benny Bomstærk", 98.3);
	private Laegemiddel pistol = new Laegemiddel("Anti-pistolskid", 1, 2, 3, "Styk");

	@Before
	public void setUp() throws Exception {
		Service.getTestService().createSomeObjects();
	}

	@Test
	public void testSamletDosisTC1() {
		DagligSkaev ds = new DagligSkaev(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 21));
		ds.setLaegemiddel(pistol);
		ds.opretDosis(LocalTime.of(10, 00), 0);
		benny.addOrdination(ds);
		assertEquals(0, ds.samletDosis(), 0.0);
	}

	@Test
	public void testSamletDosisTC2() {
		DagligSkaev ds = new DagligSkaev(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 20));
		ds.setLaegemiddel(pistol);
		ds.opretDosis(LocalTime.of(10, 00), 1);
		benny.addOrdination(ds);
		assertEquals(0, ds.samletDosis(), 0.0);
	}

	@Test
	public void testSamletDosisTC3() {
		DagligSkaev ds = new DagligSkaev(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 21));
		ds.setLaegemiddel(pistol);
		ds.opretDosis(LocalTime.of(10, 00), 1);
		benny.addOrdination(ds);
		assertEquals(1, ds.samletDosis(), 0.0);
	}

	@Test
	public void testSamletDosisTC4() {
		DagligSkaev ds = new DagligSkaev(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 20));
		ds.setLaegemiddel(pistol);
		ds.opretDosis(LocalTime.of(10, 00), 0);
		benny.addOrdination(ds);
		assertEquals(0, ds.samletDosis(), 0.0);
	}

	@Test
	public void testDoegnDosisTC1() {
		LocalDate startDen = LocalDate.of(2018, 5, 20);
		LocalDate slutDen = LocalDate.of(2018, 5, 22);
		DagligSkaev ds = new DagligSkaev(startDen, slutDen);
		ds.opretDosis(LocalTime.of(10, 00), 2);
		ds.opretDosis(LocalTime.of(12, 00), 3);
		assertEquals(2.5, ds.doegnDosis(), 1);
	}

	@Test (expected = AssertionError.class)
	public void testDoegnDosisTC2() {
		LocalDate startDen = LocalDate.of(2018, 5, 20);
		LocalDate slutDen = LocalDate.of(2018, 5, 22);
		DagligSkaev ds = new DagligSkaev(startDen, slutDen);
		assertEquals(0, ds.doegnDosis(), 1);
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

	@Test
	public void testOpretDosisTC2() {
		LocalDate startDen = LocalDate.of(2018, 5, 20);
		LocalDate slutDen = LocalDate.of(2018, 5, 24);
		DagligFast dagligFast = new DagligFast(startDen, slutDen);
		LocalTime tid = LocalTime.of(11, 15);
		dagligFast.opretDosis(tid, 2);
		Dosis dosis = dagligFast.getDoser()[0];
		assertEquals(2, dosis.getAntal(), 0);
	}
}