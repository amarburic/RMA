package ba.unsa.etf.rma.amar_buric.zadaca17401;

import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.facebook.stetho.Stetho;
import com.squareup.picasso.Picasso;

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
import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.BazaPodataka;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Podaci;
import ba.unsa.etf.rma.amar_buric.zadaca17401.WebServis.TraziFilm;
import ba.unsa.etf.rma.amar_buric.zadaca17401.WebServis.TraziRezisera;
import ba.unsa.etf.rma.amar_buric.zadaca17401.WebServis.TraziZanr;

public class MainActivity extends AppCompatActivity implements DugmadFragment.OnButtonClick, ListaGlumacaFragment.OnGlumacItemClick,
        TraziZanr.onZanrSearchDone, TraziRezisera.onReziserSearchDone {

    private boolean siriL;
    private boolean izBaze = false;

    ListaZanrovaFragment lzf;
    ListaReziseraFragment lrf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Stetho.initializeWithDefaults(this);
        siriL = false;
        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
        FrameLayout ldugmad = (FrameLayout)findViewById(R.id.mjestoF1);
        DugmadFragment df = (DugmadFragment)fm.findFragmentById(R.id.mjestoF1);
        df = new DugmadFragment();
        fm.beginTransaction().replace(R.id.mjestoF1, df).commit();
        FrameLayout ldodatni  = (FrameLayout)findViewById(R.id.mjestoF3);
        if(ldodatni != null) {
            siriL = true;
            onGlumacItemClicked(0);
        }
        Fragment f = fm.findFragmentById(R.id.mjestoF2);

        FrameLayout lsadrzaj = (FrameLayout)findViewById(R.id.mjestoF2);
        ListaGlumacaFragment lgf = new ListaGlumacaFragment();
        fm.beginTransaction().replace(R.id.mjestoF2, lgf).commit();
    }

    @Override
    public void onButtonClicked(DugmadFragment.Menu m) {
        FragmentManager fm = getFragmentManager();
        if(m == DugmadFragment.Menu.Glumci) {
            fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            ListaGlumacaFragment lgf = new ListaGlumacaFragment();
            fm.beginTransaction().replace(R.id.mjestoF2, lgf).commit();
            if(siriL) {
                onGlumacItemClicked(0);
            }
        } else if(m == DugmadFragment.Menu.Reziseri) {
            lrf = new ListaReziseraFragment();
            fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            fm.beginTransaction().replace(R.id.mjestoF2, lrf).commit();
        } else if(m == DugmadFragment.Menu.Zanrovi) {
            lzf = new ListaZanrovaFragment();
            fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            fm.beginTransaction().replace(R.id.mjestoF2, lzf).commit();
        } else if(m == DugmadFragment.Menu.Ostalo) {
            fm.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE);
            lrf = new ListaReziseraFragment();
            fm.beginTransaction().replace(R.id.mjestoF2, lrf).commit();
            lzf = new ListaZanrovaFragment();
            fm.beginTransaction().replace(R.id.mjestoF3, lzf).commit();

        }
    }

    @Override
    public void onGlumacItemClicked(int item) {
        Bundle arguments = new Bundle();
        arguments.putInt("indeksGlumca", item);
        GlumacFragment gf = new GlumacFragment();
        gf.setArguments(arguments);
        int mjesto;
        if(!siriL) mjesto = R.id.mjestoF2;
        else mjesto = R.id.mjestoF3;
        if(getFragmentManager().findFragmentById(mjesto) instanceof ListaGlumacaFragment)
            getFragmentManager().beginTransaction().replace(mjesto, gf).addToBackStack(null).commit();
        else
            getFragmentManager().beginTransaction().replace(mjesto, gf).commit();

        if(Podaci.glumci.size() > item) {
            Integer id =  Podaci.glumci.get(item).getId();
            if(izBaze) {
                Cursor result = BazaPodataka.getInstance(this).queryReziseraZaGlumca(id + "");
                if(result != null) {
                        Podaci.dodajRezisereGlumcu(id, result);
                }
                result = BazaPodataka.getInstance(this).queryZanrZaGlumca(id + "");
                if(result != null) {
                    Podaci.dodajZanroveGlumcu(id, result);
                }
            }
            else {
                (new TraziFilm(this, this, id)).execute();
            }
        }
        Podaci.promijeniListuZanrova(item);
        if(lzf != null)
            lzf.notificirajAdapter();

        Podaci.promijeniListuRezisera(item);
        if(lrf != null)
            lrf.notificirajAdapter();
    }

    @Override
    public void setIzBaze(boolean izBaze) {
        this.izBaze = izBaze;
    }

    @Override
    public void onDone(Integer id, String zanr) {
        Podaci.dodajZanrGlumcu(id, zanr);
        if(BazaPodataka.getInstance(this).jeUBaziGlumac(id + "")) {
            BazaPodataka.getInstance(this).insertZanr(Podaci.dajZanr(zanr));
            BazaPodataka.getInstance(this).insertGlumcaZanra(Podaci.dajZanr(zanr), Podaci.dajGlumca(id));
        }
        if(lzf != null)
            lzf.notificirajAdapter();
    }

    @Override
    public void onDone(Integer id, Integer rId, String ime, String prezime) {
        Podaci.dodajReziseraGlumcu(id, rId, ime, prezime);
        if(BazaPodataka.getInstance(this).jeUBaziGlumac(id + "")) {
            BazaPodataka.getInstance(this).insertRezisera(Podaci.dajRezisera(rId));
            BazaPodataka.getInstance(this).insertGlumcaRezisera(Podaci.dajRezisera(rId), Podaci.dajGlumca(id));
        }
        if(lrf != null)
            lrf.notificirajAdapter();
    }
}
