package ba.unsa.etf.rma.amar_buric.rma17_17401.Model;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Amar.B on 27.03.2017..
 */

public class Podaci {
    private static final Podaci ourInstance = new Podaci();

    static public Podaci getInstance() {
        return ourInstance;
    }

    static public ArrayList<Muzicar> unosi = new ArrayList<Muzicar>(Arrays.asList(
            new Muzicar("Kurt", "Cobain", Muzicar.Zanr.GRUNGE),
            new Muzicar("Avril", "Lavigne",  Muzicar.Zanr.PUNK),
            new Muzicar("Tarja", "Turunen",  Muzicar.Zanr.METAL),
            new Muzicar("Slim", "Shady", Muzicar.Zanr.RAP)
    ));

    static {
        unosi.get(0).dodajPjesmu(new Pjesma("Rape me").toString());
        unosi.get(0).dodajPjesmu(new Pjesma("Smells like teen spirit").toString());
        unosi.get(0).dodajPjesmu(new Pjesma("Heart-Shaped Box").toString());
        unosi.get(0).dodajPjesmu(new Pjesma("About a Girl").toString());
        unosi.get(0).dodajPjesmu(new Pjesma("The Man who sold the World").toString());
    }

    private Podaci() {
    }
}
