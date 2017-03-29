package ba.unsa.etf.rma.amar_buric.zadaca17401.Aktivnosti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import ba.unsa.etf.rma.amar_buric.zadaca17401.Kontroler.ReziserArrayAdapter;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Kontroler.ZanrArrayAdapter;
import ba.unsa.etf.rma.amar_buric.zadaca17401.MainActivity;
import ba.unsa.etf.rma.amar_buric.zadaca17401.R;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Podaci;

public class ListaZanrovaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_zanrova);

        Button zanrovi =(Button)findViewById(R.id.buttonZanrovi3);
        Button reziseri =(Button)findViewById(R.id.buttonReziseri3);
        Button glumci =(Button)findViewById(R.id.buttonGlumci3);

        glumci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ListaZanrovaActivity.this, MainActivity.class);
                ListaZanrovaActivity.this.startActivity(myIntent);
            }
        });

        zanrovi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ListaZanrovaActivity.this, ListaZanrovaActivity.class);
                ListaZanrovaActivity.this.startActivity(myIntent);
            }
        });

        reziseri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ListaZanrovaActivity.this, ListaReziseraActivity.class);
                ListaZanrovaActivity.this.startActivity(myIntent);
            }
        });

        ListView lista = (ListView)findViewById(R.id.listZanrovi);
        final ZanrArrayAdapter adapter = new ZanrArrayAdapter(this, R.layout.element_liste_zanrova,
                Podaci.zanrovi);
        lista.setAdapter(adapter);
    }
}
