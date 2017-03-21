package ba.unsa.etf.rma.amar_buric.rma17_17401.Kontroler;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import ba.unsa.etf.rma.amar_buric.rma17_17401.Model.Muzicar;
import ba.unsa.etf.rma.amar_buric.rma17_17401.R;

/**
 * Created by Amar.B on 20.03.2017..
 */

public class MojArrayAdapter extends ArrayAdapter<Muzicar> {

    int resource;

    public MojArrayAdapter(@NonNull Context context, @LayoutRes int _resource, List<Muzicar> items) {
        super(context, _resource, items);
        resource = _resource;
    }

    @Override
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
            li.inflate(resource, newView, true);
        } else {
            newView = (LinearLayout)convertView;
        }
        Muzicar classInstance = getItem(position);
        TextView imePolje = (TextView)newView.findViewById(R.id.ImeMuzicara);
        imePolje.setText(classInstance.getIme() + " " +  classInstance.getPrezime());
        TextView zanrPolje = (TextView)newView.findViewById(R.id.Zanr);
        zanrPolje.setText(classInstance.getZanr());
        return newView;
    }
}

