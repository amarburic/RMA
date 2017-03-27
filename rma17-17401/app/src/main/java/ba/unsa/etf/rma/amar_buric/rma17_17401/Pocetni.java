package ba.unsa.etf.rma.amar_buric.rma17_17401;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import ba.unsa.etf.rma.amar_buric.rma17_17401.Kontroler.MojArrayAdapter;
import ba.unsa.etf.rma.amar_buric.rma17_17401.Model.Muzicar;
import ba.unsa.etf.rma.amar_buric.rma17_17401.Model.Podaci;

public class Pocetni extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pocetni);

        Button dugme = (Button)findViewById(R.id.button);
        final TextView tekstPolje = (TextView)findViewById(R.id.editText);
        ListView lista = (ListView)findViewById(R.id.listView);

        //Hardkodirani unosi
        final MojArrayAdapter adapter;
        adapter = new MojArrayAdapter(this, R.layout.element_liste, Podaci.unosi);

        lista.setAdapter(adapter);

        dugme.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //unosi.add(0,tekstPolje.getText().toString());
                adapter.notifyDataSetChanged();
                tekstPolje.setText("");
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent myIntent = new Intent(Pocetni.this, Dodatna.class);
                myIntent.putExtra("indeksAutora", position);
                Pocetni.this.startActivity(myIntent);
            }
        });

        }
}
