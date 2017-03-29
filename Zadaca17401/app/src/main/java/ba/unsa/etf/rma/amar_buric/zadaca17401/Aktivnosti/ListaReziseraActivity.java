package ba.unsa.etf.rma.amar_buric.zadaca17401.Aktivnosti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import ba.unsa.etf.rma.amar_buric.zadaca17401.Kontroler.GlumacArrayAdapter;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Kontroler.ReziserArrayAdapter;
import ba.unsa.etf.rma.amar_buric.zadaca17401.MainActivity;
import ba.unsa.etf.rma.amar_buric.zadaca17401.R;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Podaci;

public class ListaReziseraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_rezisera);

        Button zanrovi =(Button)findViewById(R.id.buttonZanrovi2);
        Button reziseri =(Button)findViewById(R.id.buttonReziseri2);
        Button glumci =(Button)findViewById(R.id.buttonGlumci2);

        glumci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ListaReziseraActivity.this, MainActivity.class);
                ListaReziseraActivity.this.startActivity(myIntent);
            }
        });

        zanrovi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ListaReziseraActivity.this, ListaZanrovaActivity.class);
                ListaReziseraActivity.this.startActivity(myIntent);
            }
        });

        reziseri.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(ListaReziseraActivity.this, ListaReziseraActivity.class);
                ListaReziseraActivity.this.startActivity(myIntent);
            }
        });

        ListView lista = (ListView)findViewById(R.id.listReziseri);
        final ReziserArrayAdapter adapter = new ReziserArrayAdapter(this, R.layout.element_liste_rezisera,
                Podaci.reziseri);
        lista.setAdapter(adapter);

    }
}
