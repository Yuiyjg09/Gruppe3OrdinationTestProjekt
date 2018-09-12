package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PN extends Ordination {

	private double antalEnheder;
	private int antalGangeGivet;

	public PN(LocalDate startDen, LocalDate slutDen) {
		super(startDen, slutDen);
		this.antalEnheder = 0;
		this.antalGangeGivet = 0;
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
		if (givesDen.isAfter(this.getStartDen()) && givesDen.isBefore(this.getSlutDen())) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * (antal gange ordinationen er anvendt * antal enheder) / (antal dage mellem
	 * f�rste og sidste givning)
	 */
	public double doegnDosis() {
		return (antalGangeGivet * antalEnheder) / ChronoUnit.DAYS.between(getStartDen(), getSlutDen());
	}

	@Override
	public String getType() {
		return this.getClass().getName();
	}

	public double samletDosis() {
		return antalEnheder * antalGangeGivet;
	}

	/**
	 * Returnerer antal gange ordinationen er anvendt
	 * 
	 * @return
	 */
	public int getAntalGangeGivet() {
		return antalGangeGivet;
	}

	public double getAntalEnheder() {
		return antalEnheder;
	}

	public void setAntalEnheder(double antalEnheder) {
		this.antalEnheder = antalEnheder;
	}
}
