package ba.unsa.etf.rma.amar_buric.zadaca17401.DbHelperi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Amar.B on 12.06.2017..
 */

public class GlumacDbOpenHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "mojaBaza.db";

    public static final String DATABASE_TABLE_GLUMAC = "Glumac";
    public static final String DATABASE_TABLE_REZISER = "Reziser";
    public static final String DATABASE_TABLE_GLUMAC_REZISER = "GlumacReziser";
    public static final String DATABASE_TABLE_ZANR = "Zanr";
    public static final String DATABASE_TABLE_GLUMAC_ZANR = "GlumacZanr";
    public static final int DATABASE_VERSION = 5;

    public static final String GLUMAC_ID = "_id";
    public static final String GLUMAC_API_ID = "api_id";
    public static final String GLUMAC_IMDB_ID = "imdb_id";
    public static final String GLUMAC_RATING = "rating";
    public static final String GLUMAC_SLIKA ="slika";
    public static final String GLUMAC_IME ="ime";
    public static final String GLUMAC_PREZIME ="prezime";
    public static final String GLUMAC_GODINA_RODJENJA ="godina_rodjenja";
    public static final String GLUMAC_GODINA_SMRTI ="godina_smrti";
    public static final String GLUMAC_MJESTO_RODJENJA ="mjesto_rodjenja";
    public static final String GLUMAC_SPOL = "spol";
    public static final String GLUMAC_BIOGRAFIJA ="biografija";

    public static final String REZISER_ID = "_id";
    public static final String REZISER_API_ID = "api_id";
    public static final String REZISER_IME ="ime";
    public static final String REZISER_PREZIME ="prezime";

    public static final String ZANR_ID = "_id";
    public static final String ZANR_NAZIV = "naziv";

    //public static final String GLUMAC_REZISER_ID = "_id";
    public static final String GLUMAC_REZISER_API_ID_GLUMAC = "api_id_glumac";
    public static final String GLUMAC_REZISER_API_ID_REZISER = "api_id_reziser";

    public static final String GLUMAC_ZANR_ID_GLUMAC = "id_glumac";
    public static final String GLUMAC_ZANR_NAZIV_ZANR = "naziv_zanr";

    private static final String DATABASE_CREATE_GLUMAC = "create table " +
            DATABASE_TABLE_GLUMAC + " (" + GLUMAC_ID +
            " integer primary key autoincrement, " +
            GLUMAC_API_ID + " integer unique, " +
            GLUMAC_IMDB_ID + " integer, " +
            GLUMAC_RATING + " integer, " +
            GLUMAC_SLIKA + " text, " +
            GLUMAC_IME + " text, " +
            GLUMAC_PREZIME + " text, " +
            GLUMAC_GODINA_RODJENJA + " integer, " +
            GLUMAC_GODINA_SMRTI + " integer, " +
            GLUMAC_MJESTO_RODJENJA + " text, " +
            GLUMAC_SPOL + " integer, " +
            GLUMAC_BIOGRAFIJA + " text);";

    private static final String DATABASE_CREATE_REZISER = "create table " +
            DATABASE_TABLE_REZISER + " (" + REZISER_ID +
            " integer primary key autoincrement, " +
            REZISER_API_ID + " integer unique, " +
            REZISER_IME + " text, " +
            REZISER_PREZIME + " text);";

    private static final String DATABASE_CREATE_GLUMAC_REZISER  = "create table " +
            DATABASE_TABLE_GLUMAC_REZISER + " (" +
            GLUMAC_REZISER_API_ID_GLUMAC + " integer not null, " +
            GLUMAC_REZISER_API_ID_REZISER + " integer not null, " +
            "FOREIGN KEY(" + GLUMAC_REZISER_API_ID_GLUMAC + ") REFERENCES " + DATABASE_TABLE_GLUMAC
            + "(" + GLUMAC_API_ID + " ), " +
            "FOREIGN KEY(" + GLUMAC_REZISER_API_ID_REZISER + ") REFERENCES " + DATABASE_TABLE_REZISER
            + "(" + REZISER_API_ID + " ), " +
            "PRIMARY KEY(" + GLUMAC_REZISER_API_ID_GLUMAC + ", " + GLUMAC_REZISER_API_ID_REZISER
            + ")); ";

    private static final String DATABASE_CREATE_ZANR = "create table " +
            DATABASE_TABLE_ZANR + " (" + ZANR_ID +
            " integer primary key autoincrement, " +
            ZANR_NAZIV + " text unique);";

    private static final String DATABASE_CREATE_GLUMAC_ZANR = "create table " +
            DATABASE_TABLE_GLUMAC_ZANR + " (" +
            GLUMAC_ZANR_ID_GLUMAC + " integer not null, " +
            GLUMAC_ZANR_NAZIV_ZANR + " text not null, " +
            "FOREIGN KEY(" + GLUMAC_ZANR_ID_GLUMAC + ") REFERENCES " + DATABASE_TABLE_GLUMAC
            + "(" + GLUMAC_API_ID + " ), " +
            "FOREIGN KEY(" + GLUMAC_ZANR_NAZIV_ZANR + ") REFERENCES " + DATABASE_TABLE_ZANR
            + "(" + ZANR_NAZIV + " ), " +
            "PRIMARY KEY(" + GLUMAC_ZANR_ID_GLUMAC + ", " + GLUMAC_ZANR_NAZIV_ZANR
            + ")); ";

    public GlumacDbOpenHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_GLUMAC);
        db.execSQL(DATABASE_CREATE_REZISER);
        db.execSQL(DATABASE_CREATE_ZANR);
        db.execSQL(DATABASE_CREATE_GLUMAC_REZISER);
        db.execSQL(DATABASE_CREATE_GLUMAC_ZANR);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_GLUMAC + ";");
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_REZISER + ";");
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_ZANR + ";");
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_GLUMAC_REZISER + ";");
        db.execSQL("DROP TABLE IF EXISTS " + DATABASE_TABLE_GLUMAC_ZANR + ";");
        onCreate(db);
    }

}
