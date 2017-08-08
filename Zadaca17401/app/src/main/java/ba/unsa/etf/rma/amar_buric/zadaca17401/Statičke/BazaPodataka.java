package ba.unsa.etf.rma.amar_buric.zadaca17401.Statičke;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import ba.unsa.etf.rma.amar_buric.zadaca17401.DbHelperi.GlumacDbOpenHelper;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Model.Glumac;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Model.Reziser;
import ba.unsa.etf.rma.amar_buric.zadaca17401.Model.Zanr;

/**
 * Created by Amar.B on 12.06.2017..
 */

public class BazaPodataka {
    private static BazaPodataka baza = null;
    private SQLiteDatabase glumacBaza;
    private GlumacDbOpenHelper glumacBazaHelper;

    private BazaPodataka(Context context) {
        glumacBazaHelper = new GlumacDbOpenHelper(context);
        glumacBaza = glumacBazaHelper.getWritableDatabase();
    }

    public static BazaPodataka getInstance(Context context) {
        if(baza == null)
            baza = new BazaPodataka(context);
        return baza;
    }

    public synchronized void insertGlumca(Glumac g){
        ContentValues values = new ContentValues();
        values.put(GlumacDbOpenHelper.GLUMAC_API_ID, g.getId());
        values.put(GlumacDbOpenHelper.GLUMAC_IMDB_ID, g.getImdbId());
        values.put(GlumacDbOpenHelper.GLUMAC_RATING, g.getRejting());
        values.put(GlumacDbOpenHelper.GLUMAC_SLIKA, g.getSlika());
        values.put(GlumacDbOpenHelper.GLUMAC_IME, g.getIme());
        values.put(GlumacDbOpenHelper.GLUMAC_PREZIME, g.getPrezime());
        values.put(GlumacDbOpenHelper.GLUMAC_GODINA_RODJENJA, g.getGodinaRodjenja());
        values.put(GlumacDbOpenHelper.GLUMAC_GODINA_SMRTI, g.getGodinaSmrti());
        values.put(GlumacDbOpenHelper.GLUMAC_MJESTO_RODJENJA, g.getMjestoRodjenja());
        values.put(GlumacDbOpenHelper.GLUMAC_SPOL, g.getSpolAsInt());
        values.put(GlumacDbOpenHelper.GLUMAC_BIOGRAFIJA, g.getBiografija());
        glumacBaza.insert(glumacBazaHelper.DATABASE_TABLE_GLUMAC, null, values);

        for(Reziser r : g.dajRezisere()) {
            values = new ContentValues();
            values.put(GlumacDbOpenHelper.REZISER_API_ID, r.getId());
            values.put(GlumacDbOpenHelper.REZISER_IME, r.getIme());
            values.put(GlumacDbOpenHelper.REZISER_PREZIME, r.getPrezime());
            glumacBaza.insert(glumacBazaHelper.DATABASE_TABLE_REZISER, null, values);

            values = new ContentValues();
            values.put(GlumacDbOpenHelper.GLUMAC_REZISER_API_ID_GLUMAC, g.getId());
            values.put(GlumacDbOpenHelper.GLUMAC_REZISER_API_ID_REZISER, r.getId());

            glumacBaza.insert(glumacBazaHelper.DATABASE_TABLE_GLUMAC_REZISER, null, values);
        }

        for(Zanr z : g.dajZanrove()) {
            values = new ContentValues();
            values.put(GlumacDbOpenHelper.ZANR_NAZIV, z.getNaziv());
            glumacBaza.insert(glumacBazaHelper.DATABASE_TABLE_ZANR, null, values);

            values = new ContentValues();
            values.put(GlumacDbOpenHelper.GLUMAC_ZANR_ID_GLUMAC, g.getId());
            values.put(GlumacDbOpenHelper.GLUMAC_ZANR_NAZIV_ZANR, z.getNaziv());
            glumacBaza.insert(glumacBazaHelper.DATABASE_TABLE_GLUMAC_ZANR, null, values);
        }
    }

    public synchronized void insertRezisera(Reziser r) {
        ContentValues values = new ContentValues();
        values.put(GlumacDbOpenHelper.REZISER_API_ID, r.getId());
        values.put(GlumacDbOpenHelper.REZISER_IME, r.getIme());
        values.put(GlumacDbOpenHelper.REZISER_PREZIME, r.getPrezime());
        glumacBaza.insert(glumacBazaHelper.DATABASE_TABLE_REZISER, null, values);
    }

    public synchronized void insertZanr(Zanr z) {
        ContentValues values = new ContentValues();
        values.put(GlumacDbOpenHelper.ZANR_NAZIV, z.getNaziv());
        glumacBaza.insert(glumacBazaHelper.DATABASE_TABLE_ZANR, null, values);
    }

    public synchronized void insertGlumcaRezisera(Reziser r, Glumac g) {
        ContentValues values = new ContentValues();
        values.put(GlumacDbOpenHelper.GLUMAC_REZISER_API_ID_GLUMAC, g.getId());
        values.put(GlumacDbOpenHelper.GLUMAC_REZISER_API_ID_REZISER, r.getId());

        glumacBaza.insert(glumacBazaHelper.DATABASE_TABLE_GLUMAC_REZISER, null, values);
    }

    public synchronized void insertGlumcaZanra(Zanr z, Glumac g) {
        ContentValues values = new ContentValues();
        values.put(GlumacDbOpenHelper.GLUMAC_ZANR_NAZIV_ZANR, z.getNaziv());
        values.put(GlumacDbOpenHelper.GLUMAC_ZANR_ID_GLUMAC, g.getId());
        glumacBaza.insert(glumacBazaHelper.DATABASE_TABLE_GLUMAC_ZANR, null, values);
    }

    public Cursor queryGlumca() {
        String[] cols = new String[] {GlumacDbOpenHelper.GLUMAC_API_ID,
                GlumacDbOpenHelper.GLUMAC_IMDB_ID,
                GlumacDbOpenHelper.GLUMAC_RATING,
                GlumacDbOpenHelper.GLUMAC_SLIKA,
                GlumacDbOpenHelper.GLUMAC_IME,
                GlumacDbOpenHelper.GLUMAC_PREZIME,
                GlumacDbOpenHelper.GLUMAC_GODINA_RODJENJA,
                GlumacDbOpenHelper.GLUMAC_GODINA_SMRTI,
                GlumacDbOpenHelper.GLUMAC_MJESTO_RODJENJA,
                GlumacDbOpenHelper.GLUMAC_SPOL,
                GlumacDbOpenHelper.GLUMAC_BIOGRAFIJA};
        Cursor mCursor = glumacBaza.query(true, GlumacDbOpenHelper.DATABASE_TABLE_GLUMAC,cols,null
                , null, null, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor; // iterate to get each value.
    }

    public Cursor queryGlumcaPoImenu(String name) {
        String where = GlumacDbOpenHelper.GLUMAC_IME + " LIKE ? || '%' OR "
                + GlumacDbOpenHelper.GLUMAC_PREZIME + " LIKE ? || '%' ;";
        String whereArgs[] = {name, name};
        Cursor mCursor = glumacBaza.query(GlumacDbOpenHelper.DATABASE_TABLE_GLUMAC, null, where,
                whereArgs, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor; // iterate to get each value.
    }

    public Cursor queryReziseraPoImenu(String name) {
        String where = GlumacDbOpenHelper.REZISER_IME + " LIKE ? || '%' OR "
                + GlumacDbOpenHelper.REZISER_PREZIME + " LIKE ? || '%' ;";
        String whereArgs[] = {name, name};
        Cursor mCursor = glumacBaza.query(GlumacDbOpenHelper.DATABASE_TABLE_REZISER, null, where,
                whereArgs, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor; // iterate to get each value.
    }

    public Cursor queryGlumcaPoId(String api_id) {
        String where = GlumacDbOpenHelper.GLUMAC_API_ID + " = ? ;";
        String whereArgs[] = {api_id};
        Cursor mCursor = glumacBaza.query(GlumacDbOpenHelper.DATABASE_TABLE_GLUMAC, null, where,
                whereArgs, null, null, null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor; // iterate to get each value.
    }

    public boolean jeUBaziGlumac(String api_id) {
        String where = GlumacDbOpenHelper.GLUMAC_API_ID + " = ? ;";
        String whereArgs[] = {api_id};
        Cursor mCursor = glumacBaza.query(GlumacDbOpenHelper.DATABASE_TABLE_GLUMAC, null, where,
                whereArgs, null, null, null);
        return mCursor.moveToFirst();
    }

    public void obrisiGlumcaPoId(String api_id) {

        Cursor mCursor = glumacBaza.query(GlumacDbOpenHelper.DATABASE_TABLE_GLUMAC_REZISER,
                null, null, null, null, null, null, null);
        List<String> svi_reziseri_id = new ArrayList<String>();
        if(mCursor.moveToFirst()) {
            Integer kolona_id = mCursor.getColumnIndex(GlumacDbOpenHelper.GLUMAC_REZISER_API_ID_REZISER);
            do {
                svi_reziseri_id.add(mCursor.getString(kolona_id));
            } while(mCursor.moveToNext());
        }
        String where = GlumacDbOpenHelper.GLUMAC_REZISER_API_ID_GLUMAC + " = ? ;";
        String[] whereArgs = {api_id};
        mCursor = glumacBaza.query(GlumacDbOpenHelper.DATABASE_TABLE_GLUMAC_REZISER, null, where,
                whereArgs, null, null, null);
        if(mCursor.moveToFirst()) {
            Integer kolona_id = mCursor.getColumnIndex(GlumacDbOpenHelper.GLUMAC_REZISER_API_ID_REZISER);
            List<String> reziseri_id = new ArrayList<String>();
            do {
                reziseri_id.add(mCursor.getString(kolona_id));
            } while(mCursor.moveToNext());

            for(String reziser_api_id : reziseri_id) {
                if(Collections.frequency(svi_reziseri_id, reziser_api_id) == 1)
                    obrisiReziseraPoId(reziser_api_id);
                obrisiGlumacReziseraPoId(reziser_api_id, api_id);
            }

        }


        mCursor = glumacBaza.query(GlumacDbOpenHelper.DATABASE_TABLE_GLUMAC_ZANR,
                null, null, null, null, null, null, null);
        List<String> svi_zanrovi_naziv = new ArrayList<String>();
        if(mCursor.moveToFirst()) {
            Integer kolona_id = mCursor.getColumnIndex(GlumacDbOpenHelper.GLUMAC_ZANR_NAZIV_ZANR);
            do {
                svi_zanrovi_naziv.add(mCursor.getString(kolona_id));
            } while(mCursor.moveToNext());
        }
        where = GlumacDbOpenHelper.GLUMAC_ZANR_ID_GLUMAC + " = ? ;";
        mCursor = glumacBaza.query(GlumacDbOpenHelper.DATABASE_TABLE_GLUMAC_ZANR, null, where,
                whereArgs, null, null, null);
        if(mCursor.moveToFirst()) {
            Integer kolona_id = mCursor.getColumnIndex(GlumacDbOpenHelper.GLUMAC_ZANR_NAZIV_ZANR);
            List<String> zanrovi_naziv = new ArrayList<String>();
            do {
                zanrovi_naziv.add(mCursor.getString(kolona_id));
            } while(mCursor.moveToNext());

            for(String zanr_naziv : zanrovi_naziv) {
                if(Collections.frequency(svi_zanrovi_naziv, zanr_naziv) == 1)
                    obrisiZanrPoNazivu(zanr_naziv);
                obrisiGlumacZanra(zanr_naziv, api_id);
            }

        }

        where = GlumacDbOpenHelper.GLUMAC_API_ID + " = ? ;";
        String[] whereArgs2 = {api_id};
        glumacBaza.delete(GlumacDbOpenHelper.DATABASE_TABLE_GLUMAC, where, whereArgs2);


    }

    public void obrisiGlumacReziseraPoId(String api_id_reziser, String api_id_glumac) {
        String where = GlumacDbOpenHelper.GLUMAC_REZISER_API_ID_REZISER + " = ? AND "
        + GlumacDbOpenHelper.GLUMAC_REZISER_API_ID_GLUMAC + " = ?;" ;
        String[] whereArgs = {api_id_reziser, api_id_glumac};
        glumacBaza.delete(GlumacDbOpenHelper.DATABASE_TABLE_GLUMAC_REZISER, where, whereArgs);
    }

    public void obrisiGlumacZanra(String zanr_naziv, String api_id_glumac) {
        String where = GlumacDbOpenHelper.GLUMAC_ZANR_NAZIV_ZANR + " LIKE ? AND "
                + GlumacDbOpenHelper.GLUMAC_ZANR_ID_GLUMAC + " = ?;" ;
        String[] whereArgs = {zanr_naziv, api_id_glumac};
        glumacBaza.delete(GlumacDbOpenHelper.DATABASE_TABLE_GLUMAC_ZANR, where, whereArgs);
    }

    public void obrisiReziseraPoId(String api_id) {
        String where = GlumacDbOpenHelper.REZISER_API_ID + " = ? ;";
        String[] whereArgs = {api_id};
        glumacBaza.delete(GlumacDbOpenHelper.DATABASE_TABLE_REZISER, where, whereArgs);
    }

    public void obrisiZanrPoNazivu(String zanr_naziv) {
        String where = GlumacDbOpenHelper.ZANR_NAZIV + " LIKE ? ;";
        String[] whereArgs = {zanr_naziv};
        glumacBaza.delete(GlumacDbOpenHelper.DATABASE_TABLE_ZANR, where, whereArgs);
    }

    public Cursor queryReziseraZaGlumca(String api_id) {
        String where = GlumacDbOpenHelper.GLUMAC_REZISER_API_ID_GLUMAC + " = ? ;";
        String whereArgs[] = {api_id};
        Cursor mCursor = glumacBaza.query(GlumacDbOpenHelper.DATABASE_TABLE_GLUMAC_REZISER, null, where,
                whereArgs, null, null, null);
        if(!mCursor.moveToFirst())
            return null;
        Integer kolona_id = mCursor.getColumnIndex(GlumacDbOpenHelper.GLUMAC_REZISER_API_ID_REZISER);
        List<String> reziseri_id = new ArrayList<String>();
        do {
            reziseri_id.add(mCursor.getString(kolona_id));
        } while(mCursor.moveToNext());
        if(reziseri_id.size() == 0)
            return null;
        where = GlumacDbOpenHelper.REZISER_API_ID + " IN (";
        for(int i = 0; i < reziseri_id.size(); i++)
            where += (i == 0 ? "" : ", ") + "?";
         where += ");";
        whereArgs = reziseri_id.toArray(whereArgs);
        mCursor = glumacBaza.query(GlumacDbOpenHelper.DATABASE_TABLE_REZISER, null,
                where, whereArgs, null, null, null);
        if(mCursor.moveToFirst())
            return mCursor;
        return null;

    }

    public Cursor queryZanrZaGlumca(String api_id) {
        String where = GlumacDbOpenHelper.GLUMAC_ZANR_ID_GLUMAC + " = ? ;";
        String whereArgs[] = {api_id};
        Cursor mCursor = glumacBaza.query(GlumacDbOpenHelper.DATABASE_TABLE_GLUMAC_ZANR, null, where,
                whereArgs, null, null, null);
        if(!mCursor.moveToFirst())
            return null;
        Integer kolona_id = mCursor.getColumnIndex(GlumacDbOpenHelper.GLUMAC_ZANR_NAZIV_ZANR);
        List<String> zanr_nazivi = new ArrayList<String>();
        do {
            zanr_nazivi.add(mCursor.getString(kolona_id));
        } while(mCursor.moveToNext());
        if(zanr_nazivi.size() == 0)
            return null;
        where = GlumacDbOpenHelper.ZANR_NAZIV + " IN (";
        for(int i = 0; i < zanr_nazivi.size(); i++)
            where += (i == 0 ? "" : ", ") + "?";
        where += ");";
        whereArgs = zanr_nazivi.toArray(whereArgs);
        mCursor = glumacBaza.query(GlumacDbOpenHelper.DATABASE_TABLE_ZANR, null,
                where, whereArgs, null, null, null);
        if(mCursor.moveToFirst())
            return mCursor;
        return null;
    }

    public Cursor queryGlumcaPoImenuRezisera(String ime_rezisera) {
        Cursor reziseri = queryReziseraPoImenu(ime_rezisera);
        List<String> reziseri_id = new ArrayList<String>();
        Integer k_id = reziseri.getColumnIndex(GlumacDbOpenHelper.REZISER_API_ID);
        if(!reziseri.moveToFirst())
            return null;
        do {
            reziseri_id.add(reziseri.getString(k_id));
        } while(reziseri.moveToNext());
        if(reziseri_id.size() != 0) {
                String where = GlumacDbOpenHelper.GLUMAC_REZISER_API_ID_REZISER + " IN (";
                for(int i = 0; i < reziseri_id.size(); i++)
                    where += (i == 0 ? "" : ", ") + "?";
                where += ");";
                String[] whereArgs = {"test"};
                whereArgs = reziseri_id.toArray(whereArgs);
                Cursor mCursor = glumacBaza.query(GlumacDbOpenHelper.DATABASE_TABLE_GLUMAC_REZISER, null, where,
                        whereArgs, null, null, null);
                if(!mCursor.moveToFirst())
                    return null;
                Integer kolona_id = mCursor.getColumnIndex(GlumacDbOpenHelper.GLUMAC_REZISER_API_ID_GLUMAC);
                List<String> glumci_id = new ArrayList<String>();
                do {
                    if(!glumci_id.contains(mCursor.getString(kolona_id)))
                        glumci_id.add(mCursor.getString(kolona_id));
                } while(mCursor.moveToNext());
                if(glumci_id.size() == 0)
                    return null;
                where = GlumacDbOpenHelper.GLUMAC_API_ID + " IN (";
                for(int i = 0; i < glumci_id.size(); i++)
                    where += (i == 0 ? "" : ", ") + "?";
                where += ");";
                whereArgs = glumci_id.toArray(whereArgs);
                mCursor = glumacBaza.query(GlumacDbOpenHelper.DATABASE_TABLE_GLUMAC, null,
                        where, whereArgs, null, null, null);
                if(mCursor.moveToFirst())
                    return mCursor;

        }
        return null;
    }
}
