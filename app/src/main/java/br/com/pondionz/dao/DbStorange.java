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
import android.database.sqlite.SQLiteDatabase;

import com.google.android.gms.maps.model.LatLng;

import java.util.LinkedList;
import java.util.List;

import br.com.pondionz.model.Horario;
import br.com.pondionz.model.Ponto;
import br.com.pondionz.model.PontoLinha;
import br.com.pondionz.model.Linha;

/**
 * Created by Iago on 28/12/2015.
 */
final class DBStorange {
    DBStorange(SQLiteDatabase db){
        Linha(db);
        Pontos(db);
        PontoLinha(db);
        Horarios(db);
        Cidades(db);

    }

    /*Os horarios são string(nao sei se foi uma boa ideia) mas Horario é atribuido com Id da linha, horarioX,OBSX, HorarioY, OBSY e uma tag que define 1:seg a sexta 2:sabados 3:Domingos 4: todos*/
    private void Horarios(SQLiteDatabase db) {
            for(ContentValues v : DBHorarios.getHorarios()) {
                db.insert("Horario", // table
                        null, //nullColumnHack
                        v);
            }
    }

    /*Ponto linha nao é um bom nome mas define qual Linha de onibus passa naquele ponto assim IdDaLinha e o IdDoPonto */
    private void PontoLinha(SQLiteDatabase db){
        for(ContentValues v : DBPontoLinha.getPontoLinhas()) {
            db.insert("PontoLinha", // table
                    null, //nullColumnHack
                    v);
        }
    }

    /*Os pontos sao definidos por pontos(cordenadas geograficas) na qual existe uma logitude e uma latitute, os parametros sao definidos por ID, LatLng, NOME, OBS */
    private void Pontos(SQLiteDatabase db){
        for(ContentValues v : DBPontos.getPontos()) {
            db.insert("Pontos", // table
                    null, //nullColumnHack
                    v);
        }
    }

    /*As linhas sao definidas pelo id da linha , o nome, X, Y  onde geralmente uso X vai pra Y e Y vai pra X, isso é importante por algumas coisas no banco de dados tem um relacionamento com X e Y a definição errado desse parametros podem trazer falhas ao app */
    private void  Linha(SQLiteDatabase db){
        for(ContentValues v : DBLinhas.getLinhas()) {
            db.insert("Linha", // table
                    null, //nullColumnHack
                    v);
        }
    }
    private void Cidades(SQLiteDatabase db) {
        for(ContentValues v : DBCidades.getCidades()) {
            db.insert("Cidades", // table
                    null, //nullColumnHack
                    v);
        }
    }
}
