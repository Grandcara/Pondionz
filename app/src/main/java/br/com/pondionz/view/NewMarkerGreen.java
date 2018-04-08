package br.com.pondionz.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import br.com.pondionz.R;
import br.com.pondionz.dao.DBFPonto;
import br.com.pondionz.dao.MySQLiteHelper;
import br.com.pondionz.model.PontoStatic;

/**
 * Created by Iago on 28/02/2016.
 */
public class NewMarkerGreen extends Activity {
    public NewMarkerGreen(){

    }
    public NewMarkerGreen(int tipo){
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.cadastro_marker_taxi);
        creatMarker();
    }

    private void creatMarker() {
        final EditText edTitulo = (EditText) findViewById(R.id.editText);
        final EditText edDescricao = (EditText) findViewById(R.id.editText2);
        final EditText edTelefone = (EditText) findViewById(R.id.editText4);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(String.valueOf(edTitulo.getText()).length() != 0 && String.valueOf(edDescricao.getText()).length() !=0) {
                    if(new DBFPonto(getApplicationContext()).getTituloExistente(String.valueOf(edTitulo.getText()).toUpperCase())) {
                        //começa a cadastrar aqui e termina la
                        String msg = String.valueOf(edDescricao.getText())+"\n\nTelefone:\n   "+String.valueOf(edTelefone.getText());
                        PontoStatic.getPontoStatic().setTitle(String.valueOf(edTitulo.getText()).toUpperCase());
                        PontoStatic.getPontoStatic().setDescription(msg);
                        MarkerSetMap.addNewMarker();
                        finish();
                    }else     Toast.makeText(getApplication(), "Titulo já existe.", Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(getApplication(), "Titulo ou descrição não podem estar em branco.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}
