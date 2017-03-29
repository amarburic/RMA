package ba.unsa.etf.rma.amar_buric.zadaca17401.Model;

/**
 * Created by Amar.B on 29.03.2017..
 */

public class Zanr {

    String naziv;
    int slika;

    public Zanr(String naziv, int slika) {
        this.naziv = naziv;
        this.slika = slika;
    }

    public Zanr() {
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public int getSlika() {
        return slika;
    }

    public void setSlika(int slika) {
        this.slika = slika;
    }

}
