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
