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
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.pondionz.R;
import br.com.pondionz.dao.DBFCidades;
import br.com.pondionz.dao.MySQLiteHelper;
import br.com.pondionz.model.Cidade;

/**
 * Created by Iago on 04/04/2016.
 */
public class Settings extends Activity {
    private AlertDialog alerta;
    Button tvCidade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.settings);

    }
    @Override
    protected void onResume() {
        super.onResume();

        createSettings(this);
    }
    @Override
    protected void onStop() {
        super.onStop();
        super.finish();
    }

    private void createSettings(final Context context) {
        tvCidade = (Button) findViewById(R.id.tvCidade);
        tvCidade.setText(new DBFCidades(this).getSelectCidade(br.com.pondionz.model.Settings.getIdCidade()));
        tvCidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ArrayList<String> cidadesName = new DBFCidades(context).getAllCidadesName();
                final ArrayList<Cidade> cidades = new DBFCidades(context).getAllCidades();
                Log.d("iago cidades:",cidades.toString());
                cidadesName.remove(cidadesName.indexOf(new DBFCidades(context).getSelectCidade(br.com.pondionz.model.Settings.getIdCidade())));
                cidadesName.add(0,new DBFCidades(context).getSelectCidade(br.com.pondionz.model.Settings.getIdCidade()));

                //adapter utilizando um layout customizado (TextView)
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, R.layout.item_alerta, cidadesName);
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Escolha a sua cidade!");
                //define o diálogo como uma lista, passa o adapter.

                builder.setSingleChoiceItems(adapter, 0, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface arg0, int arg1) {
                        br.com.pondionz.model.Settings.setIdCidade(cidades.get(arg1).getIdCidade());
                        //new MySQLiteHelper(getApplicationContext()).save();
                        tvCidade.setText(new DBFCidades(context).getSelectCidade(br.com.pondionz.model.Settings.getIdCidade()));
                        new MySQLiteHelper(context).save();
                        new MarkerSetMap().reloadMarker();
                        alerta.dismiss();
                    }
                });
                alerta = builder.create();
                alerta.show();
            }
        });
    }

}
