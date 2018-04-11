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

import br.com.pondionz.model.Linha;

/**
 * Created by Iago on 09/03/2016.
 */
public class DBFFavorite extends MySQLiteHelper {
    public DBFFavorite(Context context) {
        super(context);
    }
    public List<Integer> getAllFavorite() {
        List<Integer> FavoriteList = new ArrayList<Integer>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM Favorite";
        try {
            /** Fill a cursor with the results. */
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()) {
                do {
                    FavoriteList.add(cursor.getInt(0));
                    Log.i("DAO", "Favoritos="+cursor.getInt(0));
                } while (cursor.moveToNext());
            }
            Log.i("DAO", "successfully get all favorite.");
        } finally {
            db.close();
        }

        return FavoriteList;
    }
    public void addFavorite(int favoriteId) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "INSERT INTO Favorite VALUES("+favoriteId+")";
        try {
            db.execSQL(query);
            Log.i("DAO","Favorito "+favoriteId+" adicionado com sucesso");
        } finally {
            db.close();
        }
    }
    public void removeFavorite(int favoriteId) {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "DELETE FROM Favorite WHERE idLinha="+favoriteId ;

        try {
            db.execSQL(query);
            Log.i("DAO","Favorito "+favoriteId+" removido com sucesso");
        } finally {
            db.close();
        }
    }
    public List<Linha> getAllLinhaFavoriteDAO() {
        List<Linha> linhaList = new ArrayList<Linha>();
        List<Integer> list = getAllFavorite();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM Linha";
        try {
            /** Fill a cursor with the results. */
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()) {
                do {
                    if(list.contains(cursor.getInt(0))) {
                        linhaList.add(new Linha(cursor.getInt(0), cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getDouble(4), cursor.getString(5), cursor.getInt(6)));
                    }
                } while (cursor.moveToNext());
            }
            Log.i("DAO Linhas", "successfully get all Linhas.");
        } finally {
            db.close();
        }

        return linhaList;
    }


}
