package ordination;

import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev {

    private ArrayList<Dosis> doses = new ArrayList<>();

    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        this.addDosis(dosis);
    }

    public ArrayList<Dosis> getDoses() {
        return new ArrayList<Dosis>(doses);
    }

    public void addDosis(Dosis dosis) {
        doses.add(dosis);
    }

    public void removeDosis(Dosis dosis) {
        doses.remove(dosis);
    }
}
