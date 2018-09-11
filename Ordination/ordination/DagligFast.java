package ordination;

import java.time.*;
import java.util.ArrayList;

public class DagligFast extends Ordination {

    private Dosis[] doses = new Dosis[4];

    public DagligFast(LocalDate startDen, LocalDate slutDen) {
        super(startDen, slutDen);
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

    public void addDosis(Dosis dosis) {
        for (int i = 0; i < doses.length; i++) {
            if (doses[i] == null) {

            }
        }
    }


}
