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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

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

public class TraziFilm extends AsyncTask<String, Integer, String> {

    private TraziZanr.onZanrSearchDone pozivateljA;
    private TraziRezisera.onReziserSearchDone pozivateljB;
    private Integer id;

    public TraziFilm() {}

    public TraziFilm(TraziZanr.onZanrSearchDone pozivateljA, TraziRezisera.onReziserSearchDone pozivateljB, Integer id) {
        this.pozivateljA = pozivateljA;
        this.pozivateljB = pozivateljB;
        this.id = id;
    }

    @Override
    protected void onPostExecute(String rezultat) {
        try {
            JSONArray cast = (new JSONObject(rezultat)).getJSONArray("cast");
            //JSONArray crew = (new JSONObject(rezultat)).getJSONArray("crew");
            List<JSONObject> jsonValues = new ArrayList<JSONObject>();
            for (int i = 0; i < cast.length(); i++)
                jsonValues.add(cast.getJSONObject(i));
            /*for (int i = 0; i < crew.length(); i++)
                jsonValues.add(crew.getJSONObject(i));
                */
            Collections.sort( jsonValues, new Comparator<JSONObject>() {
                private static final String KEY_NAME = "release_date";

                @Override
                public int compare(JSONObject a, JSONObject b) {
                    Date valA = new Date();
                    Date valB = new Date();

                    try {
                        String sValA = a.getString(KEY_NAME);
                        String sValB = b.getString(KEY_NAME);
                        String[] splitValA = sValA.split("-");
                        String[] splitValB = sValB.split("-");
                        valA = new Date(Integer.parseInt(splitValA[0]),
                                Integer.parseInt(splitValA[1]),
                                Integer.parseInt(splitValA[2]));
                        valB = new Date(Integer.parseInt(splitValB[0]),
                                Integer.parseInt(splitValB[1]),
                                Integer.parseInt(splitValB[2]));
                    }
                    catch (Exception e) {
                        //do something
                    }

                    return -valA.compareTo(valB);
                    //if you want to change the sort order, simply use the following:
                    //return -valA.compareTo(valB);
                }
            });
            Log.v("DEBUG", "Nasao" + jsonValues.size() + "filmova za glumca " + Podaci.dajGlumca(id).dajImeIPrezime());
            jsonValues = jsonValues.subList(0, Math.min(jsonValues.size(), 7));
            for(JSONObject js : jsonValues) {
                (new TraziZanr(id, pozivateljA)).execute(js.getString("id"));
                (new TraziRezisera(id, pozivateljB)).execute(js.getString("id"));
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
        String url1 = "https://api.themoviedb.org/3/person/" + id + "/movie_credits?api_key="
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


}
