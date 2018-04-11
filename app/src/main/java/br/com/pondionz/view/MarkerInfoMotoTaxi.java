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
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.model.Marker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import br.com.pondionz.R;
import br.com.pondionz.control.StableArrayAdapterMarker;
import br.com.pondionz.dao.DBFPonto;
import br.com.pondionz.dao.MySQLiteHelper;
import br.com.pondionz.model.Linha;


/**
 * Created by Iago on 29/12/2015.
 */
public class MarkerInfoMotoTaxi extends Activity {
    private static Marker marker;
    public MarkerInfoMotoTaxi(Marker marker){
        MarkerInfoMotoTaxi.marker = marker;
    }
    public MarkerInfoMotoTaxi(){
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.makeinfomototaxi);
        //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        createMarkerInfo();
    }

    private void createMarkerInfo() {
        final ListView listview = (ListView) findViewById(R.id.listmakerinfo);
        String[] values = new String[] {"Editar ponto", "Problemas com o ponto?"};
        if(new DBFPonto(this).getTituloExistenteUsuario(marker.getTitle())) {
            values = new String[]{"Editar ponto", "Problemas com o ponto?", "Excluir Ponto"};
        }
        final ArrayList<String> list = new ArrayList<String>();
        Collections.addAll(list, values);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, list);

        //Define o titulo da janela
        TextView tvTitle = (TextView) findViewById(R.id.tvtitle);
        tvTitle.setText(marker.getTitle());

        //define a descrição do ponto
        TextView tvdescricao = (TextView) findViewById(R.id.tvdescription);
        tvdescricao.setText(marker.getSnippet());


        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(getApplicationContext(),"Em desenvolvimento",Toast.LENGTH_LONG).show();

                        break;
                    case 1:

                        new MailSenderActivity(marker.getTitle(),1);
                        Intent intent2 = new Intent(getApplicationContext(), MailSenderActivity.class);
                        startActivity(intent2);
                        break;
                    case 2:
                        AlertDialog alerta;
                        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
                        //define o titulo
                        builder.setTitle("Excluir!");
                        // define a mensagem
                        builder.setMessage("Deseja realmente excluir esse ponto?");
                        //define um botão como positivo
                        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {
                                new DBFPonto(getApplicationContext()).deletePointUsuario(marker.getTitle());
                                new MarkerSetMap().reloadMarker();
                                finish();
                            }
                        }); //define um botão como negativo.
                        builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface arg0, int arg1) {

                            }
                        }); //cria o AlertDialog
                        alerta = builder.create(); //Exibe
                        alerta.show();
                        break;
                }
            }

        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }


}
