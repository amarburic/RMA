package ba.unsa.etf.rma.amar_buric.zadaca17401.Model;

import java.util.ArrayList;
import java.util.List;

import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Funkcije;

/**
 * Created by Amar.B on 28.03.2017..
 */

public class Glumac extends Osoba {

    private int rejting;

    private int imdbId;
    private int id;
    private List<Reziser> listaRezisera;
    private List<Zanr> listaZanrova;

    public Glumac() {}

    public Glumac(int id, String slika, String ime, String prezime, int godinaRodjenja, int godinaSmrti,
                  String mjestoRodjenja, Spol spol, String biografija, int rejting, int imdbId) {
        super(slika, ime, prezime, godinaRodjenja, godinaSmrti, mjestoRodjenja, spol, biografija);
        this.id = id;
        this.rejting = rejting;
        this.imdbId = imdbId;
        listaRezisera = new ArrayList<Reziser>();
        listaZanrova = new ArrayList<Zanr>();
    }

    public Glumac(String slika, String ime, String prezime, int godinaRodjenja, int godinaSmrti,
                  String mjestoRodjenja, Spol spol, String biografija, int rejting, int imdbId) {
        super(slika, ime, prezime, godinaRodjenja, godinaSmrti, mjestoRodjenja, spol, biografija);
        this.id = -1;
        this.rejting = rejting;
        this.imdbId = imdbId;
        listaRezisera = new ArrayList<Reziser>();
        listaZanrova = new ArrayList<Zanr>();
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

    public void dodajRezisera(Reziser r) {
        for(Reziser lr : listaRezisera)
            if(lr.getId().equals(r.getId()))
                return;
        listaRezisera.add(r);
    }

    public void dodajZanr(Zanr z) {
        for(Zanr lz : listaZanrova)
            if(lz.getNaziv().equals(z.getNaziv()))
                return;
        listaZanrova.add(z);
    }

    public Integer getId() {
        return id;
    }

    public List<Zanr> dajZanrove() {
        return listaZanrova;
    }

    public List<Reziser> dajRezisere() {
        return listaRezisera;
    }

}
