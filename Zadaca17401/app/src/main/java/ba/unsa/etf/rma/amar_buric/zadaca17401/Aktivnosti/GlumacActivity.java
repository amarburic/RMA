package ba.unsa.etf.rma.amar_buric.zadaca17401.Aktivnosti;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ba.unsa.etf.rma.amar_buric.zadaca17401.Model.Glumac;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Funkcije;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Podaci;
import ba.unsa.etf.rma.amar_buric.zadaca17401.R;

public class GlumacActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glumac);

        final Glumac g = Podaci.glumci.get(getIntent().getIntExtra("indeksGlumca", 0));

        ImageView slikaGlumca = (ImageView)findViewById(R.id.imageViewSlikaProfilGlumca);
        TextView nazivGlumca = (TextView)findViewById(R.id.textViewNazivProfilGlumca);
        TextView dobGlumca  =
                (TextView)findViewById(R.id.textViewDobProfilGlumca);
        TextView spolGlumca = (TextView) findViewById(R.id.textViewSpolProfilGlumca);
        TextView bioGlumca = (TextView) findViewById(R.id.textViewBioProfilGlumca);
        TextView link = (TextView)findViewById(R.id.textViewImdbLinkProfilGlumca);
        Button podijeliDugme = (Button)findViewById(R.id.buttonPodijeliProfilGlumca);

        //slikaGlumca.setImageResource(g.getSlika());
        nazivGlumca.setText(g.dajImeIPrezime());
        dobGlumca.setText("" + g.getGodinaRodjenja() + " (" + g.getMjestoRodjenja() + ")"
                +  (g.getGodinaSmrti() == -1 ? "" : " - " + g.getGodinaSmrti()));
        spolGlumca.setText(getString(g.dajResIdSpola()));
        bioGlumca.setText(g.getBiografija());
        link.setText(g.getImdbLink());

        switch(g.getSpol()) {
            case M:
                findViewById(android.R.id.content).setBackgroundColor(getResources().
                        getColor(R.color.muskoPozadina));
            break;
            case Z:
                findViewById(android.R.id.content).setBackgroundColor(getResources().
                        getColor(R.color.zenskoPozadina));
            break;
            case O:
                findViewById(android.R.id.content).setBackgroundColor(getResources().
                        getColor(R.color.ostaloPozadina));
            break;
        }

        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = g.getImdbLink();
                if(!url.startsWith("http://"))
                    url = "http://" + url;
                Intent i = new Intent(Intent.ACTION_VIEW);
                i.setData(Uri.parse(url));
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivity(i);
                }
            }
        });

        podijeliDugme.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent sendIntent = new Intent  ();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, g.getBiografija());
                sendIntent.setType("text/plain");
                if (sendIntent.resolveActivity(getPackageManager()) != null) {
                    startActivity(sendIntent);
                }

            }
        });
    }
}
