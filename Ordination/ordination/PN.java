package ordination;

import com.sun.istack.internal.NotNull;

import java.time.LocalDate;

public class PN extends Ordination{

<<<<<<< HEAD
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
=======
    private double antalEnheder;

    public PN(@NotNull LocalDate startDen, @NotNull LocalDate slutDen) {
        super(startDen, slutDen);
    }

    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen) {
        // TODO
        if (givesDen.isAfter(this.getStartDen()) && givesDen.isBefore(this.getSlutDen())) {
            return true;
        } else return false;
    }

    public double doegnDosis() {
        // TODO
        return 0.0;
    }

    @Override
    public String getType() {
        return this.getClass().getName();
    }


    public double samletDosis() {
        // TODO
        return 0.0;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        // TODO
        return-1;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

    public void setAntalEnheder(double antalEnheder) {
        this.antalEnheder = antalEnheder;
    }
}
>>>>>>> master
