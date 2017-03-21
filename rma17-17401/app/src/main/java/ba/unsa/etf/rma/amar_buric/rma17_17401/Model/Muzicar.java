package ba.unsa.etf.rma.amar_buric.rma17_17401.Model;

/**
 * Created by Amar.B on 20.03.2017..
 */

public class Muzicar {

    private String ime, prezime, zanr;

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public String getZanr() {
        return zanr;
    }

    public Muzicar() {}

    public Muzicar(String ime, String prezime, String zanr) {
        this.ime = ime;
        this.prezime = prezime;
        this.zanr = zanr;
    }
}
