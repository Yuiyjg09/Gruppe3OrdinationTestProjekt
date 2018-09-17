package jUnitTest;

import ordination.*;
import org.junit.Before;
import org.junit.Test;
import service.Service;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import static org.junit.Assert.*;

public class ServiceTest {

	private Service service = Service.getTestService();
	
	@Before
	public void setup() {
		service.createSomeObjects();
	}

	@Test(expected = IllegalArgumentException.class)
	public void opretPNOrdinationtc1() {
		service.createSomeObjects();
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		PN pn = service.opretPNOrdination(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 18), patient, laegemiddel, 2);

		assertTrue(patient.getOrdinationer().contains(pn));
	}

	@Test
	public void opretPNOrdinationtc2() {
		service.createSomeObjects();
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		PN pn = service.opretPNOrdination(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 22), patient, laegemiddel, 0);

		assertTrue(patient.getOrdinationer().contains(pn));
	}

	@Test(expected = IllegalArgumentException.class)
	public void opretPNOrdinationtc3() {
		service.createSomeObjects();
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		PN pn = service.opretPNOrdination(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 2), patient, laegemiddel, -1);

		assertTrue(patient.getOrdinationer().contains(pn));
	}

	@Test(expected = IllegalArgumentException.class)
	public void opretPNOrdinationtc4() {
		service.createSomeObjects();
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		PN pn = service.opretPNOrdination(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 18), patient, laegemiddel, -1);

		assertTrue(patient.getOrdinationer().contains(pn));
	}

	@Test
	public void opretPNOrdinationtc5() {
		service.createSomeObjects();
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		PN pn = service.opretPNOrdination(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 22), patient, laegemiddel,
				2);

		assertTrue(patient.getOrdinationer().contains(pn));
	}

	@Test(expected = NullPointerException.class)
	public void opretPNOrdinationtc6() {
		service.createSomeObjects();
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		PN pn = service.opretPNOrdination(null, LocalDate.of(2018, 5, 22), patient, laegemiddel, 2);
		assertTrue(patient.getOrdinationer().contains(pn));

	}

	@Test(expected = IllegalArgumentException.class)
	public void opretPNOrdinationtc7() {
		service.createSomeObjects();
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		PN pn = service.opretPNOrdination(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 22), null, laegemiddel, 2);
		
		assertTrue(patient.getOrdinationer().contains(pn));
	}

	@Test(expected = IllegalArgumentException.class)
	public void opretPNOrdinationtc8() {
		service.createSomeObjects();
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		PN pn = service.opretPNOrdination(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 22), patient, null, 2);
		assertTrue(patient.getOrdinationer().contains(pn));

	}

	@Test
	public void opretDagligFastOrdinationtc1() {
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		DagligFast dagligFast = service.opretDagligFastOrdination(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 22),
				patient, laegemiddel, 2, 1, 0, 1);
		assertTrue(patient.getOrdinationer().contains(dagligFast));
	}

	@Test(expected = IllegalArgumentException.class)
	public void opretDagligFastOrdinationtc2() {
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		DagligFast dagligFast = service.opretDagligFastOrdination(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 22),
				patient, laegemiddel, 2, 1, 0, -1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void opretDagligFastOrdinationtc3() {
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		DagligFast dagligFast = service.opretDagligFastOrdination(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 22),
				patient, laegemiddel, 2, 1, -1, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void opretDagligFastOrdinationtc4() {
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		DagligFast dagligFast = service.opretDagligFastOrdination(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 22),
				patient, laegemiddel, 2, -1, 0, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void opretDagligFastOrdinationtc5() {
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		DagligFast dagligFast = service.opretDagligFastOrdination(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 22),
				patient, laegemiddel, -1, 1, 0, 1);
	}

	@Test(expected = IllegalArgumentException.class)
	public void opretDagligSkaevOrdinationtc1() {
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		LocalTime[] klokkSlet = { LocalTime.of(6, 30), LocalTime.of(8, 30), LocalTime.of(12, 30), LocalTime.of(15, 30),
				LocalTime.of(22, 30) };
		double[] antalEnheder = { 2, 1, 3, 2, 2, 1 };
		DagligSkaev dagligSkaev = service.opretDagligSkaevOrdination(LocalDate.of(2018, 5, 20),
				LocalDate.of(2018, 5, 18), patient, laegemiddel, klokkSlet, antalEnheder);

	}

	@Test(expected = IllegalArgumentException.class)
	public void opretDagligSkaevOrdinationtc2() {
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		LocalTime[] klokkSlet = { LocalTime.of(6, 30), LocalTime.of(8, 30), LocalTime.of(12, 30),
				LocalTime.of(15, 30) };
		double[] antalEnheder = { 2, 1, 3, 2, 2, 1 };
		DagligSkaev dagligSkaev = service.opretDagligSkaevOrdination(LocalDate.of(2018, 5, 20),
				LocalDate.of(2018, 5, 22), patient, laegemiddel, klokkSlet, antalEnheder);
	}

	@Test(expected = IllegalArgumentException.class)
	public void opretDagligSkaevOrdinationtc3() {
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		LocalTime[] klokkSlet = { LocalTime.of(6, 30), LocalTime.of(8, 30), LocalTime.of(12, 30), LocalTime.of(15, 30),
				LocalTime.of(22, 30) };
		double[] antalEnheder = { 2, 1, 3, 2, 2, 1 };
		DagligSkaev dagligSkaev = service.opretDagligSkaevOrdination(LocalDate.of(2018, 5, 20),
				LocalDate.of(2018, 5, 22), patient, laegemiddel, klokkSlet, antalEnheder);
		assertTrue(patient.getOrdinationer().contains(dagligSkaev));
	}

	@Test(expected = IllegalArgumentException.class)
	public void opretDagligSkaevOrdinationtc4() {
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		LocalTime[] klokkSlet = { LocalTime.of(6, 30), LocalTime.of(8, 30), LocalTime.of(12, 30), LocalTime.of(15, 30),
				LocalTime.of(22, 30) };
		double[] antalEnheder = { 2, 1, 3, 2, 2, 1 };
		DagligSkaev dagligSkaev = service.opretDagligSkaevOrdination(LocalDate.of(2018, 5, 20),
				LocalDate.of(2018, 5, 22), null, laegemiddel, klokkSlet, antalEnheder);
	}

	@Test(expected = IllegalArgumentException.class)
	public void opretDagligSkaevOrdinationtc5() {
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		LocalTime[] klokkSlet = { LocalTime.of(6, 30), LocalTime.of(8, 30), LocalTime.of(12, 30), LocalTime.of(15, 30),
				LocalTime.of(22, 30) };
		double[] antalEnheder = { 2, 1, 3, 2, 2, 1 };
		DagligSkaev dagligSkaev = service.opretDagligSkaevOrdination(LocalDate.of(2018, 5, 20),
				LocalDate.of(2018, 5, 22), patient, null, klokkSlet, antalEnheder);
	}

	@Test(expected = NullPointerException.class)
	public void opretDagligSkaevOrdinationtc6() {
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		LocalTime[] klokkSlet = { LocalTime.of(6, 30), LocalTime.of(8, 30), LocalTime.of(12, 30), LocalTime.of(15, 30),
				LocalTime.of(22, 30) };
		double[] antalEnheder = { 2, 1, 3, 2, 2, 1 };
		DagligSkaev dagligSkaev = service.opretDagligSkaevOrdination(null, LocalDate.of(2018, 5, 22), patient,
				laegemiddel, klokkSlet, antalEnheder);
	}

	@Test
	public void ordinationPNAnvendttc1() {
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		PN pn = service.opretPNOrdination(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 26), patient, laegemiddel,
				2);
		service.ordinationPNAnvendt(pn, LocalDate.of(2018, 5, 22));

		assertTrue(pn.givDosis(LocalDate.of(2018, 5, 22)));
	}

	@Test(expected = IllegalArgumentException.class)
	public void ordinationPNAnvendttc2() {
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		PN pn = service.opretPNOrdination(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 19), patient, laegemiddel,
				2);
		service.ordinationPNAnvendt(pn, LocalDate.of(2018, 5, 22));

		assertTrue(pn.givDosis(LocalDate.of(2018, 5, 22)));
	}

	@Test(expected = NullPointerException.class)
	public void ordinationPNAnvendttc3() {
		Patient patient = service.opretPatient("123456-7891", "Benny Bomstærk", 98.3);
		Laegemiddel laegemiddel = service.opretLaegemiddel("Anti-pistolskid", 1, 2, 3, "Stk.");
		PN pn = service.opretPNOrdination(LocalDate.of(2018, 5, 20), LocalDate.of(2018, 5, 26), patient, laegemiddel,
				2);
		service.ordinationPNAnvendt(null, LocalDate.of(2018, 5, 22));

		assertTrue(pn.givDosis(LocalDate.of(2018, 5, 22)));
	}
}
