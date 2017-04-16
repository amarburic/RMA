package ba.unsa.etf.rma.amar_buric.zadaca17401;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;

import ba.unsa.etf.rma.amar_buric.zadaca17401.Aktivnosti.GlumacActivity;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Aktivnosti.ListaReziseraActivity;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Aktivnosti.ListaZanrovaActivity;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Fragmenti.DugmadFragment;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Fragmenti.GlumacFragment;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Fragmenti.ListaGlumacaFragment;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Fragmenti.ListaReziseraFragment;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Fragmenti.ListaZanrovaFragment;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Kontroler.GlumacArrayAdapter;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Model.Glumac;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Podaci;

public class MainActivity extends AppCompatActivity implements DugmadFragment.OnButtonClick, ListaGlumacaFragment.OnGlumacItemClick {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fm = getFragmentManager();
        FrameLayout ldugmad = (FrameLayout)findViewById(R.id.mjestoF1);
        DugmadFragment df = (DugmadFragment)fm.findFragmentById(R.id.mjestoF1);
        df = new DugmadFragment();
        fm.beginTransaction().replace(R.id.mjestoF1, df).commit();

        Fragment f = fm.findFragmentById(R.id.mjestoF2);
        if(f == null) {
            FrameLayout lsadrzaj = (FrameLayout)findViewById(R.id.mjestoF2);
            ListaGlumacaFragment lgf = new ListaGlumacaFragment();
            fm.beginTransaction().replace(R.id.mjestoF2, lgf).commit();
        }

    }

    @Override
    public void onButtonClicked(DugmadFragment.Menu m) {
        FragmentManager fm = getFragmentManager();
        FrameLayout lsadrzaj = (FrameLayout)findViewById(R.id.mjestoF2);
        if(m == DugmadFragment.Menu.Glumci) {
            ListaGlumacaFragment lgf = new ListaGlumacaFragment();

            fm.beginTransaction().replace(R.id.mjestoF2, lgf).commit();
        } else if(m == DugmadFragment.Menu.Reziseri) {
            ListaReziseraFragment lrf = new ListaReziseraFragment();

            fm.beginTransaction().replace(R.id.mjestoF2, lrf).commit();
        } else if(m == DugmadFragment.Menu.Zanrovi) {
            ListaZanrovaFragment lzf = new ListaZanrovaFragment();

            fm.beginTransaction().replace(R.id.mjestoF2, lzf).commit();
        }

    }

    @Override
    public void onGlumacItemClicked(int item) {
        Bundle arguments = new Bundle();
        arguments.putInt("indeksGlumca", item);
        GlumacFragment gf = new GlumacFragment();
        gf.setArguments(arguments);
        getFragmentManager().beginTransaction().replace(R.id.mjestoF2, gf).addToBackStack(null).commit();
    }
}
