package ordination;

import java.time.*;
import java.util.ArrayList;

public class DagligFast extends Ordination {

    private Dosis[] doses = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen) {
        super(startDen, slutDen);
    }

    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid, antal);
        boolean free = false;
        for (int i = 0; i < doses.length; i++) {
            if (doses[i] == null) {
                free = true;
            }
        }

        if (free) {
            this.addDosis(dosis);
        }
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
        return null;
    }

    public Dosis[] getDoses() {
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
