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

package br.com.pondionz.control;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;

import java.util.ArrayList;
import java.util.Hashtable;

import br.com.pondionz.R;
import br.com.pondionz.model.Linha;
import br.com.pondionz.model.PontoLinha;
import br.com.pondionz.model.PontoStatic;

/**
 * Created by Iago on 03/02/2016.
 */
public class StableArrayAdapterCheckboxLinhas extends ArrayAdapter<Linha> {
    private static ArrayList<Linha> countryList;
    private Hashtable<Integer, PontoLinha> hashPl = new Hashtable<Integer, PontoLinha>();


    public StableArrayAdapterCheckboxLinhas(Context context, int textViewResourceId,
                                            ArrayList<Linha> countryList) {
        super(context, textViewResourceId, countryList);
        StableArrayAdapterCheckboxLinhas.countryList = new ArrayList<Linha>();
        StableArrayAdapterCheckboxLinhas.countryList.addAll(countryList);
    }


    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater vi = (LayoutInflater) getContext().getSystemService(
                    Context.LAYOUT_INFLATER_SERVICE);
            convertView = vi.inflate(R.layout.checkboxlist, null);
        }
        final CheckBox checkBox = (CheckBox) convertView.findViewById(R.id.checkBox1);

        checkBox.setOnClickListener(new View.OnClickListener() {
            public void onClick(final View v) {
                final CheckBox cb = (CheckBox) v;
                final Linha country = (Linha) cb.getTag();
                AlertDialog alerta;
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                //define o titulo
                if(cb.isChecked()) {
                    builder.setTitle("Sentido");
                    // define a mensagem
                    builder.setMessage("Onde fica o ponto inicial desse ponto?");
                    //define um botão como positivo
                    builder.setPositiveButton(countryList.get(position).getPontoX(), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            checkBox.setChecked(true);
                            countryList.get(position).setSelected(cb.isChecked());
                            country.setSelected(cb.isChecked());
                            Log.i("NewMarker" ,"Sentido x: "+PontoStatic.getPontoStatic().getDirecao() );
                            hashPl.put(countryList.get(position).getIdLinha(), new PontoLinha(countryList.get(position).getIdLinha(),0,"x"));
                            PontoLinha.getLista().add(hashPl.get(countryList.get(position).getIdLinha()));
                            Log.i("NewMarker","Adicionado X "+countryList.get(position).getIdLinha());
                        }
                    }); //define um botão como negativo.
                    builder.setNegativeButton(countryList.get(position).getPontoY(), new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface arg0, int arg1) {
                            checkBox.setChecked(true);
                            countryList.get(position).setSelected(cb.isChecked());
                            country.setSelected(cb.isChecked());
                            Log.i("NewMarker" ,"Sentido y: "+PontoStatic.getPontoStatic().getDirecao() );
                            hashPl.put(countryList.get(position).getIdLinha(), new PontoLinha(countryList.get(position).getIdLinha(),0,"y"));
                            PontoLinha.getLista().add(hashPl.get(countryList.get(position).getIdLinha()));
                            Log.i("NewMarker","Adicionado y");
                        }
                    }); //cria o AlertDialog
                    Log.i("NewMarker" ,"Sentido : "+PontoStatic.getPontoStatic().getDirecao() );
                    alerta = builder.create(); //Exibe
                    alerta.show();
                    checkBox.setChecked(false);
                }else{
                    Log.i("NewMarker","Remover");
                    if (!PontoLinha.getLista().contains(hashPl.get(countryList.get(position).getIdLinha()))) {
                        return;
                    }
                    PontoLinha.getLista().remove(PontoLinha.getLista().indexOf(hashPl.get(countryList.get(position).getIdLinha())));
                    Log.i("NewMarker","RemovidoX");

                }
            }
        });

        Linha country = countryList.get(position);
        checkBox.setText(String.valueOf(country.getName()));
        checkBox.setChecked(country.isSelected());
        checkBox.setTag(country);

        return convertView;

    }
    public static ArrayList<Linha> getLinha(){
        return StableArrayAdapterCheckboxLinhas.countryList;
    }
}

