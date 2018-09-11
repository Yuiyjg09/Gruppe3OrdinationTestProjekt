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
		return 0;
	}

	@Override
	public double doegnDosis() {
		return 0;
	}

	@Override
	public String getType() {
		return this.getClass().getName();
	}
}