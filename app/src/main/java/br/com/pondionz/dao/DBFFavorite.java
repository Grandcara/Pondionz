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
