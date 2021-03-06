package ba.unsa.etf.rma.amar_buric.zadaca17401.Model;

import ba.unsa.etf.rma.amar_buric.zadaca17401.R;

/**
 * Created by Amar.B on 28.03.2017..
 */

public abstract class Osoba {

    public enum Spol {
        M, Z, O
    };

    private String slika;
    private String ime, prezime;
    private int godinaRodjenja, godinaSmrti;
    private String mjestoRodjenja;
    private Spol spol;
    private String biografija;

    public Osoba() {
        slika = null;
    }

    public Osoba(String slika, String ime, String prezime, int godinaRodjenja, int godinaSmrti,
                 String mjestoRodjenja, Spol spol, String biografija) {
        this.slika = slika;
        this.ime = ime;
        this.prezime = prezime;
        this.godinaRodjenja = godinaRodjenja;
        this.godinaSmrti = godinaSmrti;
        this.mjestoRodjenja = mjestoRodjenja;
        this.spol = spol;
        this.biografija = biografija;
    }

    public String getSlika() {
        return slika;
    }

    public void setSlika(String slika) {
        this.slika = slika;
    }

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

    public int getGodinaRodjenja() {
        return godinaRodjenja;
    }

    public void setGodinaRodjenja(int godinaRodjenja) {
        this.godinaRodjenja = godinaRodjenja;
    }

    public int getGodinaSmrti() {
        return godinaSmrti;
    }

    public void setGodinaSmrti(int godinaSmrti) {
        this.godinaSmrti = godinaSmrti;
    }

    public String getMjestoRodjenja() {
        return mjestoRodjenja;
    }

    public void setMjestoRodjenja(String mjestoRodjenja) {
        this.mjestoRodjenja = mjestoRodjenja;
    }

    public Spol getSpol() {
        return spol;
    }

    public void setSpol(Spol spol) {
        this.spol = spol;
    }


    public int getSpolAsInt() {
        switch (spol) {
            case M:
                return 2;
            case Z:
                return 1;
            case O:
                return 0;
        }
        return -1;
    }

    public void satSpolAsInt(int value) {
        switch (value) {
            case 2:
                spol = Spol.M;
                break;
            case 1:
                spol = Spol.Z;
                break;
            default:
                spol = Spol.O;
                break;
        }
    }


    public String getBiografija() {
        return biografija;
    }

    public void setBiografija(String biografija) {
        this.biografija = biografija;
    }

    public String dajImeIPrezime() {
        return ime + " " + prezime;
    }

    public int dajResIdSpola() {
        switch(spol) {
            case M:
                return R.string.spolM;
            case Z:
                return R.string.spolZ;
            case O:
                return R.string.spolO;
        }
        return -1;
    }
}
