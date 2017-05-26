package ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

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

    public static String replaceNullWithQMark(String s) {
        return (s == "null") ? "?" : s;
    }

    public static String replaceNullWithSpace(String s) {
        return (s == "null") ? " " : s;
    }

    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {

        } finally {
            try {
                is.close();
            } catch (IOException e) {

            }
        }
        return sb.toString();
    }
}
