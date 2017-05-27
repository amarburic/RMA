package ba.unsa.etf.rma.amar_buric.zadaca17401.WebServis;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Funkcije;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Podaci;

/**
 * Created by Amar.B on 27.05.2017..
 */

public class TraziZanr extends AsyncTask<String, Integer, String> {

    private Integer id;
    private onZanrSearchDone pozivateljAktivnost;
    public TraziZanr() {}

    public TraziZanr(Integer id, onZanrSearchDone pozivateljAktivnost) {
        this.id = id;
        this.pozivateljAktivnost = pozivateljAktivnost;
    }

    @Override
    protected void onPostExecute(String rezultat) {
       // if (rezultat != null) {
            try {
                JSONObject result = new JSONObject(rezultat);
                JSONArray genres = result.getJSONArray("genres");
                if (genres.length() != 0) {
                    String genre = genres.getJSONObject(0).getString("name");
                    Log.v("DEBUG", "Nasao zanr " + genre + " glumca " + Podaci.dajGlumca(id).dajImeIPrezime());
                    pozivateljAktivnost.onDone(id, genre);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
       // }
        super.onPostExecute(rezultat);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected String doInBackground(String... params) {
        String query = null;
        try {
            query = URLEncoder.encode(params[0], "utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
        String url1 = "https://api.themoviedb.org/3/movie/" + params[0] + "?api_key="
                + Podaci.api_key + "&language=" + Podaci.jezik;

        String rezultat = null;
        try {
            URL url = new URL(url1);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            rezultat = Funkcije.convertStreamToString(in);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return rezultat;
    }

    public interface onZanrSearchDone{
        public void onDone(Integer id, String zanr);
    }


}
