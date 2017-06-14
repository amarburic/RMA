package ba.unsa.etf.rma.amar_buric.zadaca17401.Fragmenti;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SearchView;

import java.util.List;

import ba.unsa.etf.rma.amar_buric.zadaca17401.Kontroler.ReziserArrayAdapter;
import ba.unsa.etf.rma.amar_buric.zadaca17401.R;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.BazaPodataka;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Podaci;
import ba.unsa.etf.rma.amar_buric.zadaca17401.WebServis.TraziFilmPoRijeci;
import ba.unsa.etf.rma.amar_buric.zadaca17401.WebServis.TraziGlumca;
import ba.unsa.etf.rma.amar_buric.zadaca17401.WebServis.TraziRezisera;
import ba.unsa.etf.rma.amar_buric.zadaca17401.WebServis.TraziZanr;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListaFilmovaFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListaFilmovaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListaFilmovaFragment extends android.app.Fragment implements TraziFilmPoRijeci.onFilmSearchDone {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    ArrayAdapter<String> adapter;

    public ListaFilmovaFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ListaFilmovaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ListaFilmovaFragment newInstance(String param1, String param2) {
        ListaFilmovaFragment fragment = new ListaFilmovaFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        mListener = (OnFragmentInteractionListener)getActivity();

        ListView lista = (ListView)getView().findViewById(R.id.listFilmovi);
        adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1,
                Podaci.filmovi);
        lista.setAdapter(adapter);

        Button trazi = (Button)getView().findViewById(R.id.buttonTraziFilm);
        trazi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String queryString = ((SearchView)getView().findViewById(R.id.searchViewTraziFilm)).getQuery().toString();
                Podaci.obrisiListuFilmova();
                adapter.notifyDataSetChanged();
                (new TraziFilmPoRijeci((TraziFilmPoRijeci.onFilmSearchDone)ListaFilmovaFragment.this)).execute(queryString);
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mListener.onFilmClicked(Podaci.dajImeFilma(position));
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_filmova, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFilmClicked(String name);
    }


    @Override
    public void onDone(List<String> rezultat) {
        Podaci.postaviListuFilmova(rezultat);
        adapter.notifyDataSetChanged();
    }



}
