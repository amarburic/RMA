package ba.unsa.etf.rma.amar_buric.rma17_17401;

import android.content.Intent;
import android.net.Uri;
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
        TextView link = (TextView)findViewById(R.id.linkStranice);

        ime.setText(m.getIme());
        prezime.setText(m.getPrezime());
        zanr.setText(m.getZanr().toString());

        final String linkTekst = m.getLink();

        link.setText(linkTekst);
        int zanrResurs = ResourceLoader.dajSlikuZanra(m.getZanr());
        ikona.setImageResource(zanrResurs);
        final ArrayAdapter<String> adapter;
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, m.dajTop5Pjesama());
        lista.setAdapter(adapter);


        link.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String url = linkTekst;
                if(!url.startsWith("http://"))
                    url = "http://" + url;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivity(i);
                }

            }
        });

    }

}
