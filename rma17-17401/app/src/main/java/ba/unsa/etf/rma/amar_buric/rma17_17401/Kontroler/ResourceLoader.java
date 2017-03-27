package ba.unsa.etf.rma.amar_buric.rma17_17401.Kontroler;

import java.util.ArrayList;
import java.util.Arrays;

import ba.unsa.etf.rma.amar_buric.rma17_17401.Model.Muzicar;
import ba.unsa.etf.rma.amar_buric.rma17_17401.R;

/**
 * Created by Amar.B on 22.03.2017..
 */

public class ResourceLoader {
    private static final ResourceLoader ourInstance = new ResourceLoader();

    static ResourceLoader getInstance() {
        return ourInstance;
    }

    private ResourceLoader() {
    }

    public static int dajSlikuZanra(Muzicar.Zanr zanr) {
        ArrayList<Integer> slike = new ArrayList<Integer>(
                Arrays.asList(R.drawable.grunge, R.drawable.metal, R.drawable.punk, R.drawable.rap, R.drawable.jazz));
        return slike.get(zanr.getValue());
    }
}
