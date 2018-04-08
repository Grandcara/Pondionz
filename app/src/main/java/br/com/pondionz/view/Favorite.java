package br.com.pondionz.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.List;

import br.com.pondionz.control.StableArrayAdapterFavorite;
import br.com.pondionz.dao.DBFFavorite;
import br.com.pondionz.dao.DBFLinha;
import br.com.pondionz.dao.MySQLiteHelper;
import br.com.pondionz.R;
import br.com.pondionz.model.Linha;
import br.com.pondionz.model.Settings;

/**
 * Created by Iago on 31/12/2015.
 */
//Aqui é seção (nos ajude) para os usuarios, esperamos que muitos nos ajudem!
public class Favorite extends Activity {
    private AlertDialog alerta;
    private List<Integer> valuesFavorite ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.favorite);
        valuesFavorite = new DBFFavorite(this). getAllFavorite();
        createList();
    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    private void createList() {
        final ListView listview = (ListView) findViewById(R.id.lvfavorite);

        //aqui deve mudar para receber varias cidades
        String[] values = new DBFLinha(this).getAllNameLinhaDAO(Settings.getIdCidade());
        final List<Linha> valuesLinhas = new DBFLinha(this).getAllLinhaDAO(Settings.getIdCidade());
        final StableArrayAdapterFavorite adapter = new StableArrayAdapterFavorite(this, values,valuesFavorite,valuesLinhas);
        listview.setAdapter(adapter);
        //Cria o gerador do AlertDialog
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    final int position, long id) {
                //verificar se já ta nos favoritos
                Log.i("position", "position="+position);
                if(!valuesFavorite.contains(valuesLinhas.get(position).getIdLinha())) {
                    //define o titulo
                    builder.setTitle("Favoritos");
                    // define a mensagem
                    builder.setMessage("Deseja Adicionar aos favoritos?");
                    //define um botão como positivo
                    builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            new DBFFavorite(getApplicationContext()).addFavorite(valuesLinhas.get(position).getIdLinha());
                            Toast.makeText(Favorite.this, "Adicionado", Toast.LENGTH_SHORT).show();
                            attValoresFavorite();
                            adapter.atualizarLista(valuesFavorite);


                        }
                    }); //define um botão como negativo.
                    builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            Toast.makeText(Favorite.this, "Cancelado", Toast.LENGTH_SHORT).show();
                        }
                    }); //cria o AlertDialog
                    alerta = builder.create(); //Exibe
                    alerta.show();
                }else{
                    //define o titulo
                    builder.setTitle("Favoritos");
                    // define a mensagem
                    builder.setMessage("Deseja remover dos favoritos?");
                    //define um botão como positivo
                    builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            new DBFFavorite(getApplicationContext()).removeFavorite(valuesLinhas.get(position).getIdLinha());
                            Toast.makeText(Favorite.this, "Removido", Toast.LENGTH_SHORT).show();
                            attValoresFavorite();
                            adapter.atualizarLista(valuesFavorite);
                        }
                    }); //define um botão como negativo.
                    builder.setNegativeButton("Não", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            Toast.makeText(Favorite.this, "Cancelado", Toast.LENGTH_SHORT).show();
                        }
                    }); //cria o AlertDialog
                    alerta = builder.create(); //Exibe
                    alerta.show();
                }


            }

        });
    }

    private void attValoresFavorite() {
        valuesFavorite.clear();
        valuesFavorite = new DBFFavorite(getApplicationContext()). getAllFavorite();
    }
}
