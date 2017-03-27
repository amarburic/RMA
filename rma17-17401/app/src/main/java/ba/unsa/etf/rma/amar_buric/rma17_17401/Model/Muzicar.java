package ba.unsa.etf.rma.amar_buric.rma17_17401.Model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * Created by Amar.B on 20.03.2017..
 */

public class Muzicar {

    public enum Zanr {
        GRUNGE(0) {
            @Override
            public String toString() {
                return "Grunge";
            }
        }, METAL(1) {
            @Override
            public String toString() {
                return "Metal";
            }
        }, PUNK(2) {
            @Override
            public String toString() {
                return "Punk";
            }
        }, RAP(3) {
            @Override
            public String toString() {
                return "Rap";
            }
        }, JAZZ(4) {
            @Override
            public String toString() {
                return "Jazz";
            }
        };

        private final int value;
        private Zanr(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private String ime, prezime, link;
    private Zanr zanr;
    private List<String> pjesme;

    public String getIme() {
        return ime;
    }

    public String getPrezime() {
        return prezime;
    }

    public Zanr getZanr() {
        return zanr;
    }

    public Muzicar() {}

    public Muzicar(String ime, String prezime, Zanr zanr, String link) {
        this.ime = ime;
        this.prezime = prezime;
        this.zanr = zanr;
        this.link = link;
        pjesme = new ArrayList<String>();
    }

    public Muzicar(String ime, String prezime, Zanr zanr) {
        this(ime, prezime, zanr, "");
    }

    public void dodajPjesmu(String p) {
        pjesme.add(p);
    }

    public List<String> dajTop5Pjesama() {
        int velicina = min(pjesme.size(), 5);
        return pjesme.subList(0, velicina);
    }

    public String getLink() {
        return link;
    }
    private int min(int size, int i) {
        return ((size < i) ? size : i);
    }
}
