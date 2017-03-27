package ba.unsa.etf.rma.amar_buric.rma17_17401.Model;

/**
 * Created by Amar.B on 27.03.2017..
 */

public class Pjesma {
    private String naziv;

    public Pjesma() {};

    public Pjesma(String naziv) {
        this.naziv = naziv;
    }

    public String dajNaziv() {
        return naziv;
    }
    @Override
    public String toString() {
         return naziv;
     }
}
