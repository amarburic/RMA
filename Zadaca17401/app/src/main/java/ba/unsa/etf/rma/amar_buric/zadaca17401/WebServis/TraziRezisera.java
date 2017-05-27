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

import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Funkcije;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Podaci;

/**
 * Created by Amar.B on 27.05.2017..
 */

public class TraziRezisera extends AsyncTask<String, Integer, String> {

    private Integer id;
    private TraziRezisera.onReziserSearchDone pozivateljAktivnost;

    public TraziRezisera() {
    }

    public TraziRezisera(Integer id, onReziserSearchDone pozivateljAktivnost) {
        this.id = id;
        this.pozivateljAktivnost = pozivateljAktivnost;
    }

    @Override
    protected void onPostExecute(String rezultat) {
        // if (rezultat != null) {
        try {
            JSONObject result = new JSONObject(rezultat);
            JSONArray crew = result.getJSONArray("crew");
            for(int i = 0; i < crew.length(); i++) {
                JSONObject person = crew.getJSONObject(i);
                String job = person.getString("job");
                if(!job.equals("Director"))
                    continue;
                String[] splitName = person.getString("name").split(" ");
                String firstName = splitName[0];
                String lastName = splitName[splitName.length - 1];
                Integer rId = person.getInt("id");
                Log.v("DEBUG", "Nasao rezisera " + firstName + " " + lastName + " glumca " + Podaci.dajGlumca(id).dajImeIPrezime());
                pozivateljAktivnost.onDone(id, rId, firstName, lastName);
                break;
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
        String url1 = "https://api.themoviedb.org/3/movie/" + params[0] + "/credits?api_key="
                + Podaci.api_key;

        String rezultat = null;
        try {
            URL url = new URL(url1);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream in = new BufferedInputStream(urlConnection.getInputStream());
            rezultat = Funkcije.convertStreamToString(in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rezultat;
    }

    public interface onReziserSearchDone {
        public void onDone(Integer id, Integer rId, String ime, String prezime);
    }

}