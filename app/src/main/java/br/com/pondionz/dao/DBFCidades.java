package br.com.pondionz.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.pondionz.model.Cidade;
import br.com.pondionz.model.Linha;
import br.com.pondionz.model.Settings;

/**
 * Created by Iago on 09/03/2016.
 */
public class DBFCidades extends MySQLiteHelper {
    public DBFCidades(Context context) {
        super(context);
    }

    public ArrayList<String> getAllCidades(SQLiteDatabase db) {
        ArrayList<String> CidadeList = new ArrayList<String>();
        String query = "SELECT NomeCidade FROM Cidades";
        /** Fill a cursor with the results. */
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()) {
            do {
                CidadeList.add(cursor.getString(0));
                Log.i("DAO", "Cidades="+cursor.getInt(0));
            } while (cursor.moveToNext());
        }
        Log.i("DAO", "successfully get all Cidades.");

        return CidadeList;
    }


    public ArrayList<String> getAllCidadesName() {
        ArrayList<String> CidadeList = new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT NomeCidade FROM Cidades";
        try {
            /** Fill a cursor with the results. */
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()) {
                do {
                    CidadeList.add(cursor.getString(0));
                    Log.i("DAO", "Cidades="+cursor.getInt(0));
                } while (cursor.moveToNext());
            }

            Log.i("DAO", "successfully get all Cidades.");
        } finally {
            db.close();
        }

        return CidadeList;
    }

    public ArrayList<Cidade> getAllCidades() {
        ArrayList<Cidade> cidadeList = new ArrayList<Cidade>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM Cidades";
        try {

            /** Fill a cursor with the results. */
            Cursor cursor = db.rawQuery(query, null);

            if(cursor.moveToFirst()) {
                do {
                    if(cursor.getInt(0) == Settings.getIdCidade())
                        cidadeList.add(new Cidade(cursor.getInt(0),cursor.getString(1)));
                    Log.i("DAO", "Cidades="+cursor.getInt(0));
                } while (cursor.moveToNext());
            }
            if(cursor.moveToFirst()) {
                do {
                    if(cursor.getInt(0) != Settings.getIdCidade())
                        cidadeList.add(new Cidade(cursor.getInt(0),cursor.getString(1)));
                    Log.i("DAO", "Cidades="+cursor.getInt(0));
                } while (cursor.moveToNext());
            }
            Log.i("DAO", "successfully get all Cidades.");
        } finally {
            db.close();
        }

        return cidadeList;
    }

    public String getSelectCidade(int id) {
        String selectCidadeId="bugnodb null";

            SQLiteDatabase db = this.getWritableDatabase();
            String query = "SELECT NomeCidade FROM Cidades where IdCidade = "+id+"";

            try {
                /** Fill a cursor with the results. */
                Cursor cursor = db.rawQuery(query, null);
                if(cursor.moveToFirst()) {
                    do {
                        selectCidadeId = cursor.getString(0);
                    } while (cursor.moveToNext());
                }
                Log.i("DAO Linhas", "successfully get all Cidade selecionadas. id "+id);
            } finally {
                db.close();
            }

        return selectCidadeId;
    }
    public int getSelectCidade(String id) {
        int selectCidadeId=-1;

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT IdCidade FROM Cidades where NomeCidade = '"+id+"'";

        try {
            /** Fill a cursor with the results. */
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()) {
                do {
                    selectCidadeId = cursor.getInt(0);
                } while (cursor.moveToNext());
            }
            Log.i("DAO Linhas", "successfully get all Cidade selecionadas. id "+id);
        } finally {
            db.close();
        }

        return selectCidadeId;
    }
}
