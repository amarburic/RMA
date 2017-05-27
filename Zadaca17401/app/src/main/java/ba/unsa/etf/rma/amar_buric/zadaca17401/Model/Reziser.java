package ba.unsa.etf.rma.amar_buric.zadaca17401.Model;

/**
 * Created by Amar.B on 29.03.2017..
 */

public class Reziser {

    String ime, prezime;
    Integer id;
    public Reziser() {}

    public Reziser(Integer id, String ime, String prezime) {
        this.ime = ime;
        this.id = id;
        this.prezime = prezime;
    }

    public Integer getId() { return id; }

    public String getIme() {
        return ime;
    }

    public void setIme(String ime) {
        this.ime = ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public void setPrezime(String prezime) {
        this.prezime = prezime;
    }

    public String getImeIPrezime() { return ime + " " + prezime; }

}
