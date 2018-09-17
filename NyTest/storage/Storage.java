package storage;

import java.util.ArrayList;
import java.util.List;

import ordination.Laegemiddel;
import ordination.Patient;

public class Storage {
	private List<Patient> patienter;
	private List<Laegemiddel> laegemidler;

	public Storage() {
		patienter = new ArrayList<Patient>();
		laegemidler = new ArrayList<Laegemiddel>();
	}

	/**
	 * Returnerer en liste med alle gemte patienter
	 */
	public List<Patient> getAllPatienter() {
		return new ArrayList<Patient>(patienter);
	}

	/**
	 * Gemmer patient
	 */
	public void addPatient(Patient patient) {
		if (!patienter.contains(patient)) {
			patienter.add(patient);
		}
	}

	/**
	 * Returnerer en liste med alle gemte l�gemidler
	 */
	public List<Laegemiddel> getAllLaegemidler() {
		return new ArrayList<Laegemiddel>(laegemidler);
	}

	/**
	 * Gemmer l�gemiddel
	 */
	public void addLaegemiddel(Laegemiddel laegemiddel) {
		if (!laegemidler.contains(laegemiddel)) {
			laegemidler.add(laegemiddel);
		}
	}
}