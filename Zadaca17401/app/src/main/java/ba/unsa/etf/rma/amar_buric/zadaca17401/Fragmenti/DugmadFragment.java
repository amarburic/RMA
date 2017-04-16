package ba.unsa.etf.rma.amar_buric.zadaca17401.Fragmenti;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import ba.unsa.etf.rma.amar_buric.zadaca17401.Aktivnosti.ListaReziseraActivity;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Aktivnosti.ListaZanrovaActivity;
import ba.unsa.etf.rma.amar_buric.zadaca17401.MainActivity;
import ba.unsa.etf.rma.amar_buric.zadaca17401.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * Use the {@link DugmadFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DugmadFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnButtonClick obc;

    public DugmadFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DugmadFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DugmadFragment newInstance(String param1, String param2) {
        DugmadFragment fragment = new DugmadFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Button zanrovi =(Button)getView().findViewById(R.id.buttonZanrovi);
        Button reziseri =(Button)getView().findViewById(R.id.buttonReziseri);
        Button glumci =(Button)getView().findViewById(R.id.buttonGlumci);
        Button ostalo = (Button)getView().findViewById(R.id.buttonOstalo);
        obc = (OnButtonClick)getActivity();

        glumci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               obc.onButtonClicked(Menu.Glumci);
            }
        });
        if(zanrovi != null) {
            zanrovi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    obc.onButtonClicked(Menu.Zanrovi);
                }
            });
            reziseri.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    obc.onButtonClicked(Menu.Reziseri);
                }
            });
        } else if(ostalo != null) {
            ostalo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    obc.onButtonClicked(Menu.Ostalo);
                }
            });
        }

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_dugmad, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        obc = null;
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
    public enum Menu {
        Glumci, Reziseri, Zanrovi, Ostalo
    }

    public interface OnButtonClick {
       public void onButtonClicked(Menu m);
    }

}
