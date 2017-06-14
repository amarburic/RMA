package ba.unsa.etf.rma.amar_buric.zadaca17401.WebServis;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Funkcije;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Podaci;

import static ba.unsa.etf.rma.amar_buric.zadaca17401.WebServis.TraziGlumca.TipPretrage.Id;
import static ba.unsa.etf.rma.amar_buric.zadaca17401.WebServis.TraziGlumca.TipPretrage.Name;

/**
 * Created by Amar.B on 14.06.2017..
 */

public class TraziFilmPoRijeci extends AsyncTask<String, Integer, String> {

    private onFilmSearchDone pozivatelj;

    public TraziFilmPoRijeci() {}

    public TraziFilmPoRijeci(onFilmSearchDone pozivatelj) {
        this.pozivatelj = pozivatelj;
    }

    @Override
    protected void onPostExecute(String rezultat) {
        try {
            JSONObject result = new JSONObject(rezultat);
            JSONArray results = result.getJSONArray("results");
            List<String> films = new ArrayList<String>();
            for(int i = 0; i < results.length(); i++)
                films.add(results.getJSONObject(i).getString("title"));
            if (films.size() != 0) {
                pozivatelj.onDone(films);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        String url1 = "https://api.themoviedb.org/3/search/movie?api_key=" +
                Podaci.api_key + "&language=" + Podaci.jezik + "&query=" + params[0] + "&page=1";
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

    public interface onFilmSearchDone{
        public void onDone(List<String> rezultat);
    }

}
