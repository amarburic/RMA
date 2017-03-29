package ba.unsa.etf.rma.amar_buric.zadaca17401.Kontroler;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ba.unsa.etf.rma.amar_buric.zadaca17401.Model.Glumac;
import ba.unsa.etf.rma.amar_buric.zadaca17401.R;

/**
 * Created by Amar.B on 28.03.2017..
 */

public class GlumacArrayAdapter extends ArrayAdapter<Glumac> {

    int resurs;
    public GlumacArrayAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Glumac> objects) {
        super(context, resource, objects);
        resurs = resource;
    }

    public View getView(int position, View convertView,
                        ViewGroup parent) {
        LinearLayout newView;
        if (convertView == null) {
            newView = new LinearLayout(getContext());
            String inflater;
            inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater li;
            li = (LayoutInflater)getContext().
                    getSystemService(inflater);
            li.inflate(resurs, newView, true);
        } else {
            newView = (LinearLayout)convertView;
        }

        ImageView slikaGlumca = (ImageView)newView.findViewById(R.id.imageSlikaGlumca);
        TextView nazivGlumca = (TextView) newView.findViewById(R.id.textViewNazivGlumca);
        TextView mjestoRodjenjaGlumca =
                (TextView)newView.findViewById(R.id.textViewMjestoRodjenjaGlumca);
        TextView godinaRodjenjaGlumca = (TextView) newView.findViewById(R.id.textViewGodinaRodjenja);
        TextView rejtingGlumca = (TextView) newView.findViewById(R.id.textViewRejtingGlumca);

        Glumac glumac = getItem(position);

        if(glumac.getSlika() != -1) {
            slikaGlumca.setImageResource(glumac.getSlika());
        }

        nazivGlumca.setText(glumac.getIme() + " " + glumac.getPrezime());
        mjestoRodjenjaGlumca.setText(glumac.getMjestoRodjenja());
        godinaRodjenjaGlumca.setText(glumac.getGodinaRodjenja() + "");
        rejtingGlumca.setText(glumac.getRejting() + "");
        return newView;
    }
}
