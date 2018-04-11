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

import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.pondionz.R;
import br.com.pondionz.model.Ponto;
import br.com.pondionz.model.Settings;
import br.com.pondionz.wizard.TutorialActivity;

/**
 * Created by Iago on 28/12/2015.
 */
public class MySQLiteHelper extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 31;
    private Context context;
    private AlertDialog alerta;
    private static final String KEY_PREFS_FIRST_LAUNCH = "first_launch";
    SQLiteDatabase dbGlobal = null;
    public MySQLiteHelper(Context context) {
        super(context, "pondionzi.sql", null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        dbGlobal = db;

        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getContext());

        if(sharedPref.getBoolean(KEY_PREFS_FIRST_LAUNCH, true)) {
            context.startActivity(new Intent(context, TutorialActivity.class));
        }

        // SQL statement to create linha
        String CREATE_TABLE_LINHA = "CREATE TABLE Linha(idLinha INTEGER PRIMARY KEY,name TEXT,PontoX TEXT,PontoY TEXT,tarifa REAL,empresa TEXT,idCidade INTEGER)";
        // SQL statement to create horario
        String CREATE_TABLE_HORARIO = "CREATE TABLE Horario(idLinha integer,horarioX TEXT,informaçoesAdicionaisX TEXT, horarioY TEXT,informaçoesAdicionaisY TEXT,tipo INTEGER)";
        // SQL statement to create Pontos
        String CREATE_TABLE_PONTOS = "CREATE TABLE Pontos(idPonto INTEGER PRIMARY KEY,idCidade INTEGER,Lat REAL,Lng REAL,Title Text,Description TEXT,direcao Text,tipo INTEGER)";
        // SQL statement to create PontosLinha
        String CREATE_TABLE_PONTOS_USUARIO = "CREATE TABLE IF NOT EXISTS PontosUsuario(idPonto INTEGER PRIMARY KEY AUTOINCREMENT,idCidade INTEGER,Lat REAL,Lng REAL,Title Text,Description TEXT,direcao Text,tipo INTEGER)";
        // SQL statement to create PontosLinha
        String CREATE_TABLE_PontoLinha = "CREATE TABLE PontoLinha(idLinha INTEGER,idPonto INTEGER,sentido TEXT)";
        // SQL statement to create PontosLinha
        String CREATE_TABLE_PontoLinhaUsuario = "CREATE TABLE IF NOT EXISTS PontoLinhaUsuario(idLinha INTEGER,idPonto INTEGER,sentido TEXT)";
        // SQL statement to create PontosLinha
        String CREATE_TABLE_Favorite = "CREATE TABLE IF NOT EXISTS Favorite(idLinha INTEGER PRIMARY KEY)";

        String CREATE_TABLE_Cidades = "CREATE TABLE Cidades(IdCidade INTEGER PRIMARY KEY,NomeCidade TEXT)";

        String CREATE_TABLE_Settings = "CREATE TABLE IF NOT EXISTS Settings(idCidade INTEGER,mostrarMarker INTERGER)";

        // create  table
        db.execSQL(CREATE_TABLE_LINHA);
        db.execSQL(CREATE_TABLE_HORARIO);
        db.execSQL(CREATE_TABLE_PONTOS);
        db.execSQL(CREATE_TABLE_PONTOS_USUARIO);
        db.execSQL(CREATE_TABLE_PontoLinha);
        db.execSQL(CREATE_TABLE_PontoLinhaUsuario);
        db.execSQL(CREATE_TABLE_Favorite);
        db.execSQL(CREATE_TABLE_Cidades);
        db.execSQL(CREATE_TABLE_Settings);
        new DBStorange(dbGlobal);
        if(db.isOpen()) {
            verificaConflito(db);
        }
        if(sharedPref.getBoolean(KEY_PREFS_FIRST_LAUNCH, true)){
            //Lista de itens
            new DBFSettings(context).InicializeSettings(db);

            final ArrayList<String> cidades = new DBFCidades(context).getAllCidades(db);
            //adapter utilizando um layout customizado (TextView)
            ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.item_alerta, cidades);
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setTitle("Escolha a sua cidade!");
            //define o diálogo como uma lista, passa o adapter.

            builder.setSingleChoiceItems(adapter, 0, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface arg0, int arg1) {
                    Settings.setIdCidade(new DBFCidades(context).getSelectCidade(cidades.get(arg1)));
                    save();
                    alerta.dismiss();
                }
            });
            alerta = builder.create();
            alerta.show();
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed

        db.execSQL("DROP TABLE IF EXISTS Linha");
        db.execSQL("DROP TABLE IF EXISTS Horario");
        db.execSQL("DROP TABLE IF EXISTS Pontos");
        db.execSQL("DROP TABLE IF EXISTS PontoLinha");
        db.execSQL("DROP TABLE IF EXISTS Cidades");
        //db.execSQL("DROP TABLE IF EXISTS Settings");
        //db.execSQL("DROP TABLE IF EXISTS PontosUsuario");
        // create fresh table
        this.onCreate(db);
    }


    public Context getContext() {
        return context;
    }

    private boolean verificaTabelaFavorite(SQLiteDatabase db){
        /* open database, if doesn't exist, create it */
        boolean tableExists = false;
/* get cursor on it */
        try
        {
            db.query("Favorite", null,
                    null, null, null, null, null);
            tableExists = true;
        }
        catch (Exception e) {
    /* fail */

        }

        return tableExists;
    }
    public void addNewLinhaPonto(int ponto, int linha,String sentido) {

        ContentValues values = new ContentValues();

        values.put("idLinha", linha);
        values.put("idPonto", ponto);
        values.put("sentido", sentido);

        SQLiteDatabase db = this.getWritableDatabase();
        try {
            db.insert("PontoLinhaUsuario", null, values);

        }finally {
            db.close();
        }

    }
    //como db ta aberto foi nescessario criar funcoes extras pra verificar esse conflito
    private void verificaConflito(SQLiteDatabase db) {
        DBFPonto d = new DBFPonto(context);
        List<Ponto> allPontosUsuario = d.getAllPontoUsuarioDAO(db);
        for (Ponto p: allPontosUsuario) {
            if(d.getTituloExistente2(p.getTitle(),db)){
                Log.i("MySQLiteHelper", "Conflito :"+p.toString());
                d.deletePointUsuario(p.getTitle(),db);
            }
        }

    }
    public void save() {
        ContentValues cv = new ContentValues();
        SQLiteDatabase db = this.getReadableDatabase();
        cv.put("idCidade",Settings.getIdCidade()); //These Fields should be your String values of actual column names
        try {
            db.update("Settings", cv,null, null);
        } finally {
            db.close();
//            new MarkerSetMap().reloadMarker();
        }
    }

    public String getDirecaoLinhaPonto(int idLinha,int idPonto) {
        String direcao=null;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT sentido FROM PontoLinha where idLinha="+idLinha+" and idPonto="+idPonto+"";
        try {
            /** Fill a cursor with the results. */
            Cursor cursor = db.rawQuery(query, null);
            if(cursor.moveToFirst()) {
                do {
                    direcao = cursor.getString(0);
                    //Log.i("DAO PontoLinha", direcao);
                } while (cursor.moveToNext());
            }
            Log.i("DAO PontoLinha", "successfully get sentido PontosLinha.");
        } finally {
            db.close();
        }
        if(direcao == null){
            SQLiteDatabase db2 = this.getWritableDatabase();
            String query2 = "SELECT sentido FROM PontoLinhaUsuario where idLinha="+idLinha+" and idPonto="+idPonto+"";
            try {
                /** Fill a cursor with the results. */
                Cursor cursor = db2.rawQuery(query2, null);
                if(cursor.moveToFirst()) {
                    do {
                        direcao = cursor.getString(0);
                        Log.i("DAO PontoLinha", direcao);
                    } while (cursor.moveToNext());
                }
                Log.i("DAO PontoLinha", "successfully get direcao PontosLinha.");
            } finally {
                db2.close();
            }
        }

        return direcao;

    }


}
