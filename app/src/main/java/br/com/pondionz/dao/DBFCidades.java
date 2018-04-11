/*
 *  Copyright (C) 2016 Iago de Castro Alvarenga <iagodecastro@yahoo.com.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 *
 */

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
