package ba.unsa.etf.rma.amar_buric.zadaca17401.Model;

import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Funkcije;

/**
 * Created by Amar.B on 28.03.2017..
 */

public class Glumac extends Osoba {

    private int rejting;

    private int imdbId;

    public Glumac() {}

    public Glumac(int slika, String ime, String prezime, int godinaRodjenja, int godinaSmrti,
                  String mjestoRodjenja, Spol spol, String biografija, int rejting, int imdbId) {
        super(slika, ime, prezime, godinaRodjenja, godinaSmrti, mjestoRodjenja, spol, biografija);
        this.rejting = rejting;
        this.imdbId = imdbId;
    }

    public int getRejting() {
        return rejting;
    }

    public void setRejting(int rejting) {
        this.rejting = rejting;
    }

    public String getImdbLink() {
        return "http://www.imdb.com/name/nm" +
                Funkcije.padujLijevo("" + imdbId, 7, '0') + "/";
    }


}
