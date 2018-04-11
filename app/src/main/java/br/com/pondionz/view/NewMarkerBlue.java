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

package br.com.pondionz.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.pondionz.R;
import br.com.pondionz.control.StableArrayAdapterCheckboxLinhas;
import br.com.pondionz.dao.DBFLinha;
import br.com.pondionz.dao.DBFPonto;
import br.com.pondionz.dao.MySQLiteHelper;
import br.com.pondionz.model.Linha;
import br.com.pondionz.model.Ponto;
import br.com.pondionz.model.PontoLinha;
import br.com.pondionz.model.PontoStatic;
import br.com.pondionz.model.Settings;

/**
 * Created by Iago on 28/02/2016.
 */
public class NewMarkerBlue extends Activity {
    private static StableArrayAdapterCheckboxLinhas dataAdapter = null;

    public NewMarkerBlue(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cadastro_marker);
        creatMarker();
    }

    private void creatMarker() {
        final EditText edTitulo = (EditText) findViewById(R.id.editText);
        final EditText edDescricao = (EditText) findViewById(R.id.editText2);
        ArrayList<Linha> arrayListPonto;
        arrayListPonto = new DBFLinha(this).getAllLinhaDAO(Settings.getIdCidade());
        //create an ArrayAdaptar from the String Array

        PontoLinha.getLista().clear();
        dataAdapter = new StableArrayAdapterCheckboxLinhas(this,
                R.layout.cadastro_marker, arrayListPonto);
        ListView listView = (ListView) findViewById(R.id.listView);
        // Assign adapter to ListView
        listView.setAdapter(dataAdapter);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(String.valueOf(edTitulo.getText()).length() != 0 && String.valueOf(edDescricao.getText()).length() !=0 ) {
                    if(PontoLinha.getLista().size()!=0) {
                        if (new DBFPonto(getApplicationContext()).getTituloExistente(String.valueOf(edTitulo.getText()).toUpperCase())) {
                            //começa a cadastrar aqui e termina la

                            PontoStatic.getPontoStatic().setTitle(String.valueOf(edTitulo.getText()).toUpperCase());
                            PontoStatic.getPontoStatic().setIdCidade(Settings.getIdCidade());
                            PontoStatic.getPontoStatic().setDescription(String.valueOf(edDescricao.getText()));
                            MarkerSetMap.addNewMarker();
                            finish();
                        }else
                            Toast.makeText(getApplication(), "Titulo já existe!", Toast.LENGTH_SHORT).show();
                    }else
                        Toast.makeText(getApplication(), "Selecione alguma linha a esse ponto!", Toast.LENGTH_SHORT).show();
                }else
                    Toast.makeText(getApplication(), "Titulo descrição não podem estar em branco!", Toast.LENGTH_SHORT).show();

            }
        });
    }

}
