package ordination;

import java.time.LocalDate;

public class PN {

	private double antalEnheder;

	public PN(double antalEnheder) {
		this.antalEnheder = antalEnheder;
	}

	/**
	 * Registrerer at der er givet en dosis paa dagen givesDen Returnerer true hvis
	 * givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
	 * Retrurner false ellers og datoen givesDen ignoreres
	 * 
	 * @param givesDen
	 * @return
	 */
	public boolean givDosis(LocalDate givesDen) {
		// TODO
		return false;
	}

	/**
	 * (antal gange ordinationen er anvendt * antal enheder) / (antal dage mellem
	 * første og sidste givning)
	 * 
	 * @return
	 */
	public double doegnDosis() {
		return 0.0;
	}

	public double samletDosis() {
		// TODO
		return 0.0;
	}

	/**
	 * Returnerer antal gange ordinationen er anvendt
	 * 
	 * @return
	 */
	public int getAntalGangeGivet() {
		// TODO
		return -1;
	}

	public double getAntalEnheder() {
		return antalEnheder;
	}
}