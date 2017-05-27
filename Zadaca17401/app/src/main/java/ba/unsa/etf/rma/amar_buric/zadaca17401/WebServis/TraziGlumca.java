package ba.unsa.etf.rma.amar_buric.zadaca17401.WebServis;

import android.os.AsyncTask;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

import ba.unsa.etf.rma.amar_buric.zadaca17401.Model.Glumac;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Model.Osoba;
import ba.unsa.etf.rma.amar_buric.zadaca17401.R;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Funkcije;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Podaci;

import static ba.unsa.etf.rma.amar_buric.zadaca17401.WebServis.TraziGlumca.TipPretrage.Id;
import static ba.unsa.etf.rma.amar_buric.zadaca17401.WebServis.TraziGlumca.TipPretrage.Name;

/**
 * Created by Amar.B on 25.05.2017..
 */

public class TraziGlumca extends AsyncTask<String, Integer, String> {

    public enum TipPretrage {
        Id, Name
    }
    private onGlumacSearchDone pozivatelj;
    private TraziZanr.onZanrSearchDone pozivateljA;
    private TraziRezisera.onReziserSearchDone pozivateljB;
    private TipPretrage tip;

    public TraziGlumca() {}

    public TraziGlumca(onGlumacSearchDone pozivatelj,
                       TraziZanr.onZanrSearchDone pozivateljA,
                       TraziRezisera.onReziserSearchDone pozivateljB,
                       TipPretrage tip) {
        this.pozivatelj = pozivatelj;
        this.pozivateljA = pozivateljA;
        this.pozivateljB = pozivateljB;
        this.tip = tip;
    }

    @Override
    protected void onPostExecute(String rezultat) {
        try {
            if(tip == Name) {
                JSONArray results = (new JSONObject(rezultat)).getJSONArray("results");
                for(int i = 0; i < results.length(); i++) {
                    JSONObject actor = results.getJSONObject(i);
                    Integer id = actor.getInt("id");

                    (new TraziGlumca(pozivatelj, pozivateljA, pozivateljB, Id)).execute(id + "");
                }
            } else if(tip == Id) {
                JSONObject js = new JSONObject(rezultat);
                pozivatelj.onDone(js);
                Log.v("DEBUG", "Dodao glumca " + Podaci.dajGlumca(js.getInt("id")).dajImeIPrezime());
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
        String url1 = "https://api.themoviedb.org/3/";
        if(tip == Id) {
            url1 = url1 + "person/" + query;
        } else if(tip == Name) {
            url1 = url1 + "search/person";
        }
        url1 = url1 + "?api_key="
                        + Podaci.api_key
                        + "&language="
                        + Podaci.jezik;
        if(tip == Name) {
            url1 = url1 + "&query="
                    + query
                    +"&page=1&include_adult=false";
        }
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

    public interface onGlumacSearchDone{
        public void onDone(JSONObject rezultat);
    }

}
