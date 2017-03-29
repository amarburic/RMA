package ba.unsa.etf.rma.amar_buric.zadaca17401;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import ba.unsa.etf.rma.amar_buric.zadaca17401.Aktivnosti.GlumacActivity;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Aktivnosti.ListaReziseraActivity;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Aktivnosti.ListaZanrovaActivity;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Kontroler.GlumacArrayAdapter;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Podaci;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lista = (ListView)findViewById(R.id.listGlumci);
        final GlumacArrayAdapter adapter = new GlumacArrayAdapter(this, R.layout.element_liste_glumaca,
                Podaci.glumci);
        lista.setAdapter(adapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(MainActivity.this, GlumacActivity.class);
                myIntent.putExtra("indeksGlumca", position);
                MainActivity.this.startActivity(myIntent);
            }
        });

        Button zanrovi =(Button)findViewById(R.id.buttonZanrovi);
        Button reziseri =(Button)findViewById(R.id.buttonReziseri);
        Button glumci =(Button)findViewById(R.id.buttonGlumci);

        glumci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, MainActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        zanrovi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ListaZanrovaActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });

        reziseri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(MainActivity.this, ListaReziseraActivity.class);
                MainActivity.this.startActivity(myIntent);
            }
        });


    }
}
