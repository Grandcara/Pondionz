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
