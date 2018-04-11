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

import java.util.LinkedList;
import java.util.List;

import br.com.pondionz.model.Cidade;
import br.com.pondionz.model.Linha;

/**
 * Created by Iago on 14/03/2016.
 */
class DBCidades {
    private static List<ContentValues> insertValues = new LinkedList<ContentValues>();
    public static List<ContentValues> getCidades(){
        insertValues.add(values(new Cidade(1,"São João del Rei")));
        //insertValues.add(values(new Cidade(2,"Divinópolis")));
        insertValues.add(values(new Cidade(3,"Lafaiete")));
        insertValues.add(values(new Cidade(4,"Santa Cruz de Minas")));
        insertValues.add(values(new Cidade(5,"Formiga")));
        return insertValues;
    }
    private static ContentValues values(Cidade cidade){
        ContentValues values = new ContentValues();
        values.put("idCidade", cidade.getIdCidade());
        values.put("NomeCidade", cidade.getNome());
        return values;
    }
}
