package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {
	private ArrayList<Dosis> doses = new ArrayList<>();

	public DagligSkaev(LocalDate startDen, LocalDate slutDen) {
		super(startDen, slutDen);
	}

	public void opretDosis(LocalTime tid, double antal) {
		Dosis dosis = new Dosis(tid, antal);
		this.addDosis(dosis);
	}

	public ArrayList<Dosis> getDoser() {
		return new ArrayList<Dosis>(doses);
	}

	public void addDosis(Dosis dosis) {
		doses.add(dosis);
	}

	public void removeDosis(Dosis dosis) {
		doses.remove(dosis);
	}

	@Override
	public double samletDosis() {
		return doegnDosis() * (getSlutDen().getDayOfYear() - getStartDen().getDayOfYear());
	}

	@Override
	public double doegnDosis() {
		double doegnDosis = 0.0;
		for (Dosis dosis : doses) {
			doegnDosis += dosis.getAntal();
		}
		return doegnDosis / doses.size();
	}

	@Override
	public String getType() {
		return this.getClass().getName();
	}
}
