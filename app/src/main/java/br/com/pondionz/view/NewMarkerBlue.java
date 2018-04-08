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
