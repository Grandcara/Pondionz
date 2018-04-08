package br.com.pondionz.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.pondionz.model.Horario;

/**
 * Created by Iago on 09/03/2016.
 */
public class DBFHorarios extends MySQLiteHelper {
    public DBFHorarios(Context context) {
        super(context);
    }

    /*é quase uma banbs no codigo mas é nessesario verificar quantos tipos tem de horario pra denifir na tela se sao seg a sex sabados e domingos */
    public int getQuantidadeTipoHorarioDAO(int idLinha) {
        int n = 0;
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT COUNT(distinct tipo) FROM Horario where idLinha = "+idLinha;
        try {
            /** Fill a cursor with the results. */
            Cursor cursor = db.rawQuery(query, null);
            cursor.moveToFirst();
            n = cursor.getInt(0);

            Log.i("DAO horarios", "successfully get quantidade de tipos dos horarios.");
        } finally {
            db.close();
        }

        return n;
    }


    //Retorna uma lista de horarios de acordo com a Linha pedida
    public List<Horario> getRotaHorariosDAO(int idLinha) {
        List<Horario> Horario = new ArrayList<Horario>();
        SQLiteDatabase db = this.getWritableDatabase();

        try {
            /** Fill a cursor with the results. */
            Cursor c = db.query(true,
                    "Horario",                        /**< Table name. */
                    null,                             /**< All the fields that you want the
                     cursor to contain; null means all.*/
                    "idLinha =?",                         /**< WHERE statement without the WHERE clause. */
                    new String[]{String.valueOf(idLinha)},    /**< Selection arguments. */
                    null, null, null, null);

            c.moveToFirst();
            if(c.moveToFirst()) {
                do {
                    Horario.add(new Horario(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getInt(5)));
                } while (c.moveToNext());
            }
            Log.i("DAO Food", "successfully get all foods Name.");
        } finally {
            db.close();
        }

        return Horario;
    }
    //Retorna uma lista de horarios de acordo com a Linha pedida
    public List<Horario> getRotaHorariosDAO(int idLinha,int tipo) {
        List<Horario> Horario = new ArrayList<Horario>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM Horario where idLinha="+idLinha+" and tipo="+tipo;

        try {
            Cursor c = db.rawQuery(query, null);

            if(c.moveToFirst()) {
                do {
                    Horario.add(new Horario(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getInt(5)));
                    Log.i("DAO Food", c.getInt(0)+" "+c.getString(1)+" "+c.getString(2)+" "+c.getString(3)+" "+c.getString(4)+" "+c.getInt(5));
                } while (c.moveToNext());
            }
            Log.i("DAO Food", "successfully get all foods Name.");
        } finally {
            db.close();
        }

        return Horario;
    }
    //Função mais complicada, ela é uma previsão dos proximos horarios a partir de uma hora, como o sistema retorna a hora um pouco errada foi necessario criar 2 query iguais só que resolvendo esse problema da hora
    //Tentativas de melhorar a query = 1
    public List<Horario> getRotaHorariosEspecificosDAO(int idLinha,int hour,String direção,int tipo) {
        List<Horario> rotas = new ArrayList<Horario>();
        SQLiteDatabase db = this.getWritableDatabase();
        String query;

        if(direção.equals("xy")) {
            if (hour > 4 && hour < 10) {
                query = "SELECT * FROM Horario where idLinha=" + idLinha + " and Tipo=" + tipo + " and ((horarioX LIKE '0" + String.valueOf(hour) + ":%' or horarioX LIKE '0" + String.valueOf(hour + 1) + ":%')or(horarioY LIKE '0" + String.valueOf(hour) + ":%' or horarioY LIKE '0" + String.valueOf(hour + 1) + ":%')) LIMIT 5 ";
            } else if (hour > 9 && hour < 24)
                query = "SELECT * FROM Horario where idLinha=" + idLinha + " and Tipo=" + tipo + " and ((horarioX LIKE '" + String.valueOf(hour) + ":%' or horarioX LIKE '" + String.valueOf(hour + 1) + ":%')or(horarioY LIKE '" + String.valueOf(hour) + ":%' or horarioY LIKE '" + String.valueOf(hour + 1) + ":%')) LIMIT 5 ";
            else
                query = "";
        }else if(direção.equals("x")){
            if (hour > 4 && hour < 10) {
                query = "SELECT * FROM Horario where idLinha=" + idLinha + " and Tipo=" + tipo + " and (horarioX LIKE '0" + String.valueOf(hour) + ":%' or horarioX LIKE '0" + String.valueOf(hour + 1) + ":%') LIMIT 5 ";
            } else if (hour > 9 && hour < 24)
                query = "SELECT * FROM Horario where idLinha=" + idLinha + " and Tipo=" + tipo + " and (horarioX LIKE '" + String.valueOf(hour) + ":%' or horarioX LIKE '" + String.valueOf(hour + 1) + ":%') LIMIT 5 ";
            else
                query = "";
        }else{
            if (hour > 4 && hour < 10) {
                query = "SELECT * FROM Horario where idLinha=" + idLinha + " and Tipo=" + tipo + " and (horarioY LIKE '0" + String.valueOf(hour) + ":%' or horarioY LIKE '0" + String.valueOf(hour + 1) + ":%') LIMIT 5 ";
            } else if (hour > 9 && hour < 24)
                query = "SELECT * FROM Horario where idLinha=" + idLinha + " and Tipo=" + tipo + " and (horarioY LIKE '" + String.valueOf(hour) + ":%' or horarioY LIKE '" + String.valueOf(hour + 1) + ":%') LIMIT 5 ";
            else
                query = "";
        }
        Log.i("query",query);
        if(query.length() > 0){
            try {
                Cursor c = db.rawQuery(query, null);
                c.moveToFirst();
                if(c.moveToFirst()) {
                    do {
                        rotas.add(new Horario(c.getInt(0),c.getString(1),c.getString(2),c.getString(3),c.getString(4),c.getInt(5)));
                    } while (c.moveToNext());
                }
                Log.i("DAO Food", "successfully get all foods Name.");
            } finally {
                db.close();
            }
        }

        return rotas;
    }
}
