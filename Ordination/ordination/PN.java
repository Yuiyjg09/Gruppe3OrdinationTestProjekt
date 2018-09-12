package ordination;

import java.time.LocalDate;
<<<<<<< HEAD

public class PN extends Ordination {

    private double antalEnheder;

    public PN(LocalDate startDen, LocalDate slutDen) {
        super(startDen, slutDen);
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
        if (givesDen.isAfter(getStartDen()) && givesDen.isBefore(getSlutDen())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public double doegnDosis() {
        // TODO
        return 0.0;
    }

    @Override
    public String getType() {
        return this.getClass().getName();
    }

    @Override
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

    public void setAntalEnheder(double antalEnheder) {
        this.antalEnheder = antalEnheder;
    }
}
=======
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
	 * første og sidste givning)
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
>>>>>>> BranchMartin
