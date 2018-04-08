package br.com.pondionz.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.List;

import br.com.pondionz.model.Ponto;

/**
 * Created by Iago on 09/03/2016.
 */
public class DBFPonto extends MySQLiteHelper {
    public DBFPonto(Context context) {
        super(context);
    }
    //Retorna todos os pontos
    public ArrayList<Ponto> getAllPontoDAO(int idCidade) {
        ArrayList<Ponto> pontoList = new ArrayList<Ponto>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM Pontos WHERE idCidade ="+idCidade;
        try {
            /** Fill a cursor with the results. */
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()) {
                do {
                    pontoList.add(new Ponto(cursor.getInt(0),cursor.getInt(1),new LatLng(cursor.getDouble(2),cursor.getDouble(3)),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getInt(7)));
                } while (cursor.moveToNext());
            }
            Log.i("DAO", "successfully get all Pontos.");
        } finally {
            db.close();
        }

        return pontoList;
    }
    //Retorna todos os pontos usuario
    public List<Ponto> getAllPontoUsuarioDAO(int idCidade) {
        List<Ponto> pontoList = new ArrayList<Ponto>();
        SQLiteDatabase db;
        db = this.getWritableDatabase();
        String query = "SELECT * FROM PontosUsuario WHERE idCidade ="+idCidade;
        try {
            /** Fill a cursor with the results. */
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()) {
                do {
                    pontoList.add(new Ponto(cursor.getInt(0),cursor.getInt(1),new LatLng(cursor.getDouble(2),cursor.getDouble(3)),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getInt(7)));
                } while (cursor.moveToNext());
            }
            Log.i("DAO", "successfully get all Pontos.");
        } finally {
            db.close();
        }
        return pontoList;
    }
    //Retorna todos os pontos usuario
    public List<Ponto> getAllPontoUsuarioDAO(SQLiteDatabase db) {
        List<Ponto> pontoList = new ArrayList<Ponto>();

        String query = "SELECT * FROM PontosUsuario";
        /** Fill a cursor with the results. */
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()) {
            do {
                pontoList.add(new Ponto(cursor.getInt(0),cursor.getInt(1),new LatLng(cursor.getDouble(2),cursor.getDouble(3)),cursor.getString(4),cursor.getString(5),cursor.getString(6),cursor.getInt(7)));
            } while (cursor.moveToNext());
        }
        Log.i("DAO", "successfully get all Pontos.");

        return pontoList;
    }
    public String getPontoDirecaoDAO(String namePonto) {
        String direcao=null;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT direcao FROM Pontos where Title='"+namePonto+"'";
        try {
            /** Fill a cursor with the results. */
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()) {
                do {
                    direcao = cursor.getString(0);
                } while (cursor.moveToNext());
            }
            Log.i("DAO Ponto", "successfully get direcao Pontos.");
        } finally {
            db.close();
        }
        if(direcao == null){
            SQLiteDatabase db2 = this.getWritableDatabase();
            String query2 = "SELECT direcao FROM PontosUsuario where Title='"+namePonto+"'";
            try {
                /** Fill a cursor with the results. */
                Cursor cursor = db2.rawQuery(query2, null);
                if(cursor.moveToFirst()) {
                    do {
                        direcao = cursor.getString(0);
                    } while (cursor.moveToNext());
                }
                Log.i("DAO Ponto", "successfully get direcao Pontos.");
            } finally {
                db2.close();
            }
        }

        return direcao;
    }
    public boolean getTituloExistente(String namePonto) {
        boolean existe = true;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT Count(idPonto) FROM Pontos where Title='"+namePonto+"'";
        try {
            /** Fill a cursor with the results. */
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()) {
                if (cursor.getInt(0) > 0) {
                    existe = false;
                }
            }

            Log.i("DAO Ponto", "successfully get direcao Pontos.");
        } finally {
            db.close();
        }
        if(existe){
            SQLiteDatabase db2 = this.getWritableDatabase();
            String query2 = "SELECT Count(idPonto) FROM PontosUsuario  where Title='"+namePonto+"'";
            try {
                /** Fill a cursor with the results. */
                Cursor cursor = db2.rawQuery(query2, null);
                if(cursor.moveToFirst()) {
                    if (cursor.getInt(0) > 0) {
                        existe = false;
                    }
                }

                Log.i("DAO Ponto", "successfully get direcao Pontos.");
            } finally {
                db2.close();
            }
        }

        return existe;
    }
    public boolean getTituloExistenteUsuario(String namePonto) {
        boolean existe = false;
        SQLiteDatabase db2 = this.getWritableDatabase();
        String query2 = "SELECT Count(idPonto) FROM PontosUsuario  where Title='"+namePonto+"'";
        try {
            /** Fill a cursor with the results. */
            Cursor cursor = db2.rawQuery(query2, null);
            if(cursor.moveToFirst()) {
                if (cursor.getInt(0) > 0) {
                    existe = true;
                }
            }

            Log.i("DAO Ponto", "successfully get direcao Pontos.");
        } finally {
            db2.close();
        }

        return existe;
    }
    public boolean getTituloExistente2(String namePonto,SQLiteDatabase db2) {
        boolean existe = false;

        String query2 = "SELECT Count(idPonto) FROM Pontos  where Title='"+namePonto+"'";
        /** Fill a cursor with the results. */
        Cursor cursor = db2.rawQuery(query2, null);
        if(cursor.moveToFirst()) {
            if (cursor.getInt(0) > 0) {
                existe = true;
            }
        }

        Log.i("DAO Ponto", "successfully get direcao Pontos.");

        return existe;
    }
    public boolean getTituloExistente2(String namePonto) {
        boolean existe = false;
        SQLiteDatabase db2 = this.getWritableDatabase();
        String query2 = "SELECT Count(idPonto) FROM Pontos  where Title='"+namePonto+"'";
        try {
            /** Fill a cursor with the results. */
            Cursor cursor = db2.rawQuery(query2, null);
            if(cursor.moveToFirst()) {
                if (cursor.getInt(0) > 0) {
                    existe = true;
                }
            }

            Log.i("DAO Ponto", "successfully get direcao Pontos.");
        } finally {
            db2.close();
        }

        return existe;
    }
    //Retorna todos os pontos
    public int getAllPontoIDDAO(String nomePonto) {
        int a=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT idPonto FROM PontosUsuario where Title='"+nomePonto+"'";
        try {
            /** Fill a cursor with the results. */
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()) {
                do {
                    a=cursor.getInt(0);
                } while (cursor.moveToNext());
            }
            Log.i("DAO Ponto", "successfully get all Pontos.");
        } finally {
            db.close();
        }

        return a;
    }
    private int getAllPontoIDDAO(String nomePonto, SQLiteDatabase db) {
        int a=-1;

        String query = "SELECT idPonto FROM PontosUsuario where Title='"+nomePonto+"'";
        /** Fill a cursor with the results. */
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()) {
            do {
                a=cursor.getInt(0);
            } while (cursor.moveToNext());
        }
        Log.i("DAO Ponto", "successfully get all Pontos.");

        return a;
    }
    //Retorna todos os pontos
    public void deletePointUsuario(String nomePonto) {
        int a = getAllPontoIDDAO(nomePonto);
        SQLiteDatabase db = this.getWritableDatabase();
        // String query = "DELETE FROM PontosUsuario" + "WHERE nomePonto = '"+nomePonto+"'";
        try {

            db.delete("PontosUsuario", "Title = ?", new String[] {String.valueOf(nomePonto)});
            if(a != -1) {
                db.delete("PontoLinhaUsuario", "idPonto = ?", new String[]{String.valueOf(a)});
            }
        } finally {
            db.close();
        }

    }
    //Retorna todos os pontos
    public void deletePointUsuario(String nomePonto,SQLiteDatabase db) {
        int a = getAllPontoIDDAO(nomePonto,db);

        // String query = "DELETE FROM PontosUsuario" + "WHERE nomePonto = '"+nomePonto+"'";

        db.delete("PontosUsuario", "Title = ?", new String[] {String.valueOf(nomePonto)});
        if(a != -1) {
            db.delete("PontoLinhaUsuario", "idPonto = ?", new String[]{String.valueOf(a)});
        }

    }
    //Retorna todos os pontos
    public int getPontoTipoDAO(String nomePonto) {
        int a=-1;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT tipo FROM Pontos where Title='"+nomePonto+"'";
        try {
            /** Fill a cursor with the results. */
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()) {
                do {
                    a=cursor.getInt(0);
                } while (cursor.moveToNext());
            }
            Log.i("DAO Ponto", "successfully get all Pontos.");
        } finally {
            db.close();
        }
        if(a == -1){
            SQLiteDatabase db2 = this.getWritableDatabase();
            String query2 = "SELECT tipo FROM PontosUsuario where Title='"+nomePonto+"'";
            try {
                /** Fill a cursor with the results. */
                Cursor cursor2 = db2.rawQuery(query2, null);
                if(cursor2.moveToFirst()) {
                    do {
                        a=cursor2.getInt(0);
                    } while (cursor2.moveToNext());
                }
                Log.i("DAO Ponto", "successfully get all Pontos.");
            } finally {
                db2.close();
            }
        }
        return a;
    }
    //Retorna todos os pontos
    public int getAllQuantidadePontoDAO() {
        int a=0;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT idPonto FROM Pontos" ;
        try {
            /** Fill a cursor with the results. */
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()) {
                do {
                    a++;
                } while (cursor.moveToNext());
            }
            Log.i("DAO Ponto", "successfully get all Pontos.");
        } finally {
            db.close();
        }
        a++;
        return a;
    }

    public void addNewMarker(Ponto pontoStatic) {

        ContentValues values = new ContentValues();
        values.put("idCidade", pontoStatic.getIdCidade());
        values.put("Lat", pontoStatic.getLatLng().latitude);
        values.put("Lng", pontoStatic.getLatLng().longitude);
        values.put("Title", pontoStatic.getTitle());
        values.put("Description", pontoStatic.getDescription());
        values.put("direcao", pontoStatic.getDirecao());
        values.put("tipo", pontoStatic.getTipo());
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.insert("PontosUsuario", null, values);
            Log.i("Insere Marker", "Nome: "+pontoStatic.toString());
        }finally {
            db.close();
        }

    }
}
