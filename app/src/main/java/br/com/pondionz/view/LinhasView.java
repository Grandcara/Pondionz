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
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import br.com.pondionz.R;
import br.com.pondionz.control.ExpandableListAdapter;
import br.com.pondionz.dao.DBFCidades;
import br.com.pondionz.dao.DBFLinha;
import br.com.pondionz.dao.DBFSettings;
import br.com.pondionz.dao.MySQLiteHelper;
import br.com.pondionz.model.Cidade;
import br.com.pondionz.model.Linha;
import br.com.pondionz.model.Settings;

/**
 * Created by Iago on 30/12/2015.
 */
public class LinhasView extends Activity {
    private static List<Linha> linhas;
    public LinhasView(List<Linha> linhas){
        LinhasView.linhas = linhas;
    }
    public LinhasView(){

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new DBFSettings(this).getSettings();
        if(linhas != null && linhas.size() != 0) {
            setContentView(R.layout.listlinha);
        }else {
            setContentView(R.layout.listlinhageral);
            //aqui deve ser mudado para receber cidades

            Spinner spinner = (Spinner) findViewById(R.id.spinner);
            linhas = new DBFLinha(getApplicationContext()).getAllLinhaDAO(Settings.getIdCidade());

            final ArrayList<String> cidadesName = new DBFCidades(this).getAllCidadesName();
            final ArrayList<Cidade> cidades = new DBFCidades(this).getAllCidades();
            //gabs que mantei a cidade do settings sempre na posição 0
            cidadesName.remove(cidadesName.indexOf(new DBFCidades(this).getSelectCidade(Settings.getIdCidade())));
            cidadesName.add(0,new DBFCidades(this).getSelectCidade(Settings.getIdCidade()));

            final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinnercolorlistview, cidadesName);

            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            spinner.setAdapter(adapter);

            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) { Log.e("NullPoitnListView", "Falhou em buscar "+cidades.get(position).getIdCidade());
                  linhas = new DBFLinha(getApplicationContext()).getAllLinhaDAO(cidades.get(position).getIdCidade());

                    crearInfo();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }
        crearInfo();

    }
    private void crearInfo(){

        final ExpandableListView listview = (ExpandableListView) findViewById(R.id.lvLinha);

        final ArrayList<String> list = new ArrayList<String>();

        for (int i = 0; i < linhas.size(); ++i) {
            list.add(linhas.get(i).getName());
        }

        Map<String, Linha> catcollection= new LinkedHashMap<String, Linha>();

        for(int i=0; i<linhas.size();i++){
            catcollection.put(list.get(i),linhas.get(i));
        }

        final ExpandableListAdapter adapter = new ExpandableListAdapter(this,
                list,catcollection);
        listview.setAdapter(adapter);
        Log.i("LV",String.valueOf(Settings.getIdCidade())+linhas.size());
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        finish();
    }

    public void limpar(){
        if(linhas != null)
             linhas.clear();
    }

}
