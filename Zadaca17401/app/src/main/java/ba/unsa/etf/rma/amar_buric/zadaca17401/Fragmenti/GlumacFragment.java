package ba.unsa.etf.rma.amar_buric.zadaca17401.Fragmenti;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import ba.unsa.etf.rma.amar_buric.zadaca17401.Model.Glumac;
import ba.unsa.etf.rma.amar_buric.zadaca17401.R;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke.Podaci;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link GlumacFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link GlumacFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class GlumacFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public GlumacFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment GlumacFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static GlumacFragment newInstance(String param1, String param2) {
        GlumacFragment fragment = new GlumacFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if(getArguments() == null) return;
        final Glumac g = Podaci.glumci.get(getArguments().getInt("indeksGlumca", 0));
        ImageView slikaGlumca = (ImageView)getView().findViewById(R.id.imageViewSlikaProfilGlumca);
        TextView nazivGlumca = (TextView)getView().findViewById(R.id.textViewNazivProfilGlumca);
        TextView dobGlumca  =
                (TextView)getView().findViewById(R.id.textViewDobProfilGlumca);
        TextView spolGlumca = (TextView) getView().findViewById(R.id.textViewSpolProfilGlumca);
        TextView bioGlumca = (TextView) getView().findViewById(R.id.textViewBioProfilGlumca);
        TextView link = (TextView)getView().findViewById(R.id.textViewImdbLinkProfilGlumca);
        Button podijeliDugme = (Button)getView().findViewById(R.id.buttonPodijeliProfilGlumca);

        slikaGlumca.setImageResource(g.getSlika());
        nazivGlumca.setText(g.dajImeIPrezime());
        dobGlumca.setText("" + g.getGodinaRodjenja() + " (" + g.getMjestoRodjenja() + ")"
                +  (g.getGodinaSmrti() == -1 ? "" : " - " + g.getGodinaSmrti()));
        spolGlumca.setText(getString(g.dajResIdSpola()));
        bioGlumca.setText(g.getBiografija());
        link.setText(g.getImdbLink());

        switch (g.getSpol()) {
            case M:
                getView().findViewById(R.id.profilMainView).setBackgroundColor(getResources().
                        getColor(R.color.muskoPozadina));
                break;
            case O:
                getView().findViewById(R.id.profilMainView).setBackgroundColor(getResources().
                        getColor(R.color.ostaloPozadina));
                break;
            case Z:
                getView().findViewById(R.id.profilMainView).setBackgroundColor(getResources().
                        getColor(R.color.zenskoPozadina));

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
                if (i.resolveActivity(getActivity().getPackageManager()) != null) {
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
                if (sendIntent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(sendIntent);
                }

            }
        });
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
        return inflater.inflate(R.layout.fragment_glumac, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnGlumacItemClick");
        }
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
        void onFragmentInteraction(Uri uri);
    }
}
