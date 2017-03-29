package ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke;

/**
 * Created by Amar.B on 28.03.2017..
 */

public class Funkcije {
    public static String podvuciTekst(String tekst) {
        return "<u>" + tekst + "<\\u>";
    }

    public static String padujLijevo(String s, int n, char znak) {
        return String.format("%1$" + n + "s", s).replace(' ', znak);
    }
}
