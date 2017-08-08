package ba.unsa.etf.rma.amar_buric.zadaca17401.Fragmenti;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import ba.unsa.etf.rma.amar_buric.zadaca17401.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FilmFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FilmFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FilmFragment extends android.app.Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FilmFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FilmFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static FilmFragment newInstance(String param1, String param2) {
        FilmFragment fragment = new FilmFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        String name =  getArguments().getString("imeFilma", "");
        final TextView imeFilma = (TextView)getView().findViewById(R.id.nazivFilmaTextView);
        imeFilma.setText(name);
        Button save = (Button)getView().findViewById(R.id.buttonSpasi);
        final DatePicker datePicker = (DatePicker)getView().findViewById(R.id.datePickerFilm);
        final EditText info = (EditText)getView().findViewById(R.id.ediTextInfoFilm);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // The indices for the projection array above.

                // Here, thisActivity is the current activity
                if (ContextCompat.checkSelfPermission(FilmFragment.this.getActivity(),
                        Manifest.permission.READ_CALENDAR)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(FilmFragment.this.getActivity(),
                            new String[]{Manifest.permission.READ_CALENDAR},
                            0);
                }

                if (ContextCompat.checkSelfPermission(FilmFragment.this.getActivity(),
                        Manifest.permission.WRITE_CALENDAR)
                        != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(FilmFragment.this.getActivity(),
                            new String[]{Manifest.permission.WRITE_CALENDAR},
                            0);
                }

                final String[] EVENT_PROJECTION = new String[] {
                        CalendarContract.Calendars._ID,                           // 0
                        CalendarContract.Calendars.ACCOUNT_NAME,                  // 1
                        CalendarContract.Calendars.CALENDAR_DISPLAY_NAME,         // 2
                        CalendarContract.Calendars.OWNER_ACCOUNT                  // 3
                };

                final int PROJECTION_ID_INDEX = 0;
                final int PROJECTION_ACCOUNT_NAME_INDEX = 1;
                final int PROJECTION_DISPLAY_NAME_INDEX = 2;
                final int PROJECTION_OWNER_ACCOUNT_INDEX = 3;

                Cursor cur = null;
                long calID = 0;
                ContentResolver cr = FilmFragment.this.getActivity().getContentResolver();
                Uri uri = CalendarContract.Calendars.CONTENT_URI;
                try {
                    cur = cr.query(uri, EVENT_PROJECTION, null, null, null);
                } catch(Exception e) {
                    e.printStackTrace();
                }
                 if(!cur.moveToFirst() || cur.getCount() == 0) {
                     ContentValues values = new ContentValues();
                     values.put(CalendarContract.Calendars.CALENDAR_DISPLAY_NAME, "Prvi");
                     values.put(CalendarContract.Calendars.NAME, "Prvi");
                     Uri updateUri = CalendarContract.Calendars.CONTENT_URI;
                     try {
                         Uri uri2 = FilmFragment.this.getActivity().getContentResolver().insert(updateUri, values);
                     } catch (SecurityException e) {
                         e.printStackTrace();
                     }

                 }/*
                     try {
                         cur = cr.query(uri, EVENT_PROJECTION, null, null, null);
                     } catch (Exception e) {
                         e.printStackTrace();
                     }
                 do {
                     calID = cur.getLong(PROJECTION_ID_INDEX);
                     String displayName = cur.getString(PROJECTION_DISPLAY_NAME_INDEX);
                     String accountName = cur.getString(PROJECTION_ACCOUNT_NAME_INDEX);
                     String ownerName = cur.getString(PROJECTION_OWNER_ACCOUNT_INDEX);


                     int year = datePicker.getYear();
                     int month = datePicker.getMonth();
                     int day = datePicker.getDayOfMonth();
                     long startMillis = new Date(year, month, day).getTime();
                     long endMillis = startMillis;
                     TimeZone timeZone = TimeZone.getDefault();
                     cr = FilmFragment.this.getActivity().getContentResolver();
                     ContentValues values = new ContentValues();
                     values.put(CalendarContract.Events.DTSTART, startMillis);
                     values.put(CalendarContract.Events.DTEND, endMillis + 1);
                     values.put(CalendarContract.Events.TITLE, imeFilma.getText().toString());
                     values.put(CalendarContract.Events.DESCRIPTION, info.getText().toString());
                     values.put(CalendarContract.Events.CALENDAR_ID, calID);
                     values.put(CalendarContract.Events.EVENT_TIMEZONE, timeZone.getID());
                     try {
                         Uri uri3 = cr.insert(CalendarContract.Events.CONTENT_URI, values);
                     } catch (SecurityException e) {
                         e.printStackTrace();
                     }
                 }while(cur.moveToNext());*/

                int year = datePicker.getYear();
                int month = datePicker.getMonth();
                int day = datePicker.getDayOfMonth();
                long startMillis = new Date(year, month, day).getTime();
                long endMillis = startMillis;

                Calendar beginTime = Calendar.getInstance();
                beginTime.set(year, month, day);
                Calendar endTime = Calendar.getInstance();
                endTime.set(year, month, day);
                Intent intent = new Intent(Intent.ACTION_INSERT)
                        .setData(CalendarContract.Events.CONTENT_URI)
                        .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, beginTime.getTimeInMillis())
                        .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, endTime.getTimeInMillis())
                        .putExtra(CalendarContract.Events.TITLE, imeFilma.getText().toString())
                        .putExtra(CalendarContract.Events.DESCRIPTION, info.getText().toString());
                if (intent.resolveActivity(FilmFragment.this.getActivity().getPackageManager()) != null) {
                    startActivity(intent);
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
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_film, container, false);
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
