package ordination;

import java.time.*;

public class DagligFast extends Ordination {

	private Dosis[] doses = new Dosis[4];

	public DagligFast(LocalDate startDen, LocalDate slutDen) {
		super(startDen, slutDen);
	}

	public void opretDosis(LocalTime tid, double antal) {
		if (tid != null) {
			if (antal >= 0) {
				Dosis dosis = new Dosis(tid, antal);
				boolean free = false;
				for (int i = 0; i < doses.length; i++) {
					if (doses[i] == null) {
						free = true;
					}
				}

				if (free) {
					addDosis(dosis);
				}
			} else {
				throw new IllegalArgumentException();
			}
		} else {
			throw new NullPointerException();
		}
	}

	@Override
	public double samletDosis() {
		return doegnDosis() * (getSlutDen().getDayOfYear() - getStartDen().getDayOfYear());
	}

	@Override
	public double doegnDosis() {
		double totalDosis = 0.0;
		for (Dosis dosis : doses) {
			totalDosis += dosis.getAntal();
		}
		return totalDosis;
	}

	@Override
	public String getType() {
		return this.getClass().getName();
	}

	public Dosis[] getDoser() {
		return doses;
	}

	public void setDoses(Dosis[] doses) {
		this.doses = doses;
	}

	public void addDosis(Dosis dosis) {
		for (int i = 0; i < doses.length; i++) {
			if (doses[i] == null) {
				doses[i] = dosis;
			}
		}
	}

	public void removeDosis(Dosis dosis) {
		for (int i = 0; i < doses.length; i++) {
			if (doses[i] == dosis) {
				doses[i] = null;
			}
		}
	}
}