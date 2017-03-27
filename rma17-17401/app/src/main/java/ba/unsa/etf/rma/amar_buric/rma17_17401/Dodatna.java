package ba.unsa.etf.rma.amar_buric.rma17_17401;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import ba.unsa.etf.rma.amar_buric.rma17_17401.Kontroler.ResourceLoader;
import ba.unsa.etf.rma.amar_buric.rma17_17401.Model.Muzicar;
import ba.unsa.etf.rma.amar_buric.rma17_17401.Model.Podaci;

public class Dodatna extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dodatna);

        Muzicar m = Podaci.unosi.get(getIntent().getIntExtra("indeksAutora", 0));

        TextView ime = (TextView)findViewById(R.id.imeDodatna);
        TextView prezime = (TextView)findViewById(R.id.prezimeDodatna);
        TextView zanr = (TextView)findViewById(R.id.zanrDodatna);
        ImageView ikona = (ImageView)findViewById(R.id.dodatnaSlika);
        ListView lista = (ListView)findViewById(R.id.lista);

        ime.setText(m.getIme());
        prezime.setText(m.getPrezime());
        zanr.setText(m.getZanr().toString());
        int zanrResurs = ResourceLoader.dajSlikuZanra(m.getZanr());
        ikona.setImageResource(zanrResurs);
        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, m.dajTop5Pjesama());
        lista.setAdapter(adapter);
    }

}
