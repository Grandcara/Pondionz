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
import java.util.Set;

import br.com.pondionz.model.Linha;
import br.com.pondionz.model.Settings;
import br.com.pondionz.view.MarkerSetMap;

/**
 * Created by Iago on 09/03/2016.
 */
public class DBFSettings extends MySQLiteHelper {
    public DBFSettings(Context context) {
        super(context);
    }
    public void getSettings() {

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM Settings";
        try {
            /** Fill a cursor with the results. */
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()) {
                do {
                    Settings.setIdCidade(cursor.getInt(0));
                    Settings.setIdMostraMarker(cursor.getInt(1));
                    Log.i("DAO", "Settings="+cursor.getInt(0)+" e "+cursor.getInt(1));
                } while (cursor.moveToNext());
            }
            Log.i("DAO", "successfully get all settings.");
        } finally {
            db.close();
        }


    }
    public void InicializeSettings(SQLiteDatabase db) {
        String query = "INSERT INTO Settings VALUES(1,1111)";
        db.execSQL(query);
        Log.i("DAO","Settings inicializado");
    }

    public void UpdateSettings(SQLiteDatabase db,int idCidade) {
        String query = "UPTADE Settings SET idCidade="+idCidade+"";
        db.execSQL(query);
        Log.i("DAO","Settings Update settings "+idCidade);
    }

    public void Save() {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "UPDATE Settings SET idCidade="+Settings.getIdCidade()+",mostrarMarker = "+Settings.getIdMostraMarker()+"";
        try {
            db.execSQL(query);
            Log.i("DAO","Settings Update settings");
        } finally {
            db.close();
        }
    }


}
