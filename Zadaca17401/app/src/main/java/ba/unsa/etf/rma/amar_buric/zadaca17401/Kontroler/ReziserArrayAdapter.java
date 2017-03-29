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
import ba.unsa.etf.rma.amar_buric.zadaca17401.Model.Reziser;
import ba.unsa.etf.rma.amar_buric.zadaca17401.R;

/**
 * Created by Amar.B on 29.03.2017..
 */

public class ReziserArrayAdapter extends ArrayAdapter<Reziser> {

    int resurs;
    public ReziserArrayAdapter(@NonNull Context context, @LayoutRes int resource,
                               @NonNull List<Reziser> objects) {
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

        TextView nazivRezisera = (TextView) newView.findViewById(R.id.textViewNazivRezisera);

        Reziser reziser = getItem(position);

        nazivRezisera.setText(reziser.getIme() + " " + reziser.getPrezime());
        return newView;
    }
}
