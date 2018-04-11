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

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

import br.com.pondionz.R;
import br.com.pondionz.dao.DBFHorarios;
import br.com.pondionz.dao.DBFPonto;
import br.com.pondionz.dao.MySQLiteHelper;
import br.com.pondionz.model.Horario;
import br.com.pondionz.model.Linha;

/**
 * Created by Iago on 03/02/2016.
 */
public class StableArrayAdapterMarker extends ArrayAdapter<Linha> {
    private final Context context;
    private String markerName;
    private final List<Linha> linhas;
    private int contador = 0;
    public StableArrayAdapterMarker(Context context, String markerName, List<Linha> linhas) {
        super(context, R.layout.makeinfobus, linhas);
        this.context = context;
        this.markerName = markerName;
        this.linhas = linhas;

    }


    @Override
    public View getView(int j, View convertView, ViewGroup parent) {
        String direcao;
        LinearLayout scview = new LinearLayout(context);
        scview.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                TableRow.LayoutParams.WRAP_CONTENT));
        scview.setOrientation(LinearLayout.VERTICAL);
        LinearLayout llVertical = new LinearLayout(context);
        llVertical.setOrientation(LinearLayout.VERTICAL);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(4, 4, 4, 4 );
        direcao = new DBFPonto(context).getPontoDirecaoDAO(markerName);

        if(direcao == null){
            direcao = new MySQLiteHelper(context).getDirecaoLinhaPonto(linhas.get(j).getIdLinha(),new DBFPonto(context).getAllPontoIDDAO(markerName));
            Log.i("Verificar", "idlinha: "+linhas.get(j).getIdLinha()+" idPonto: "+new DBFPonto(context).getAllPontoIDDAO(markerName));
        }

        List<Horario> listhorarios= null;
        Calendar calendar =  Calendar.getInstance();
        if (calendar.get(Calendar.DAY_OF_WEEK) >= 2 && calendar.get(Calendar.DAY_OF_WEEK) <= 6) {
            listhorarios = new DBFHorarios(context).getRotaHorariosEspecificosDAO(linhas.get(j).getIdLinha(), calendar.get(Calendar.HOUR_OF_DAY), direcao, 1);
        } else if (calendar.get(Calendar.DAY_OF_WEEK) == 7) { //sabado tipo 2
            listhorarios = new DBFHorarios(context).getRotaHorariosEspecificosDAO(linhas.get(j).getIdLinha(), calendar.get(Calendar.HOUR_OF_DAY), direcao, 2);
        } else if (calendar.get(Calendar.DAY_OF_WEEK) == 1) {//Domingo e feriados tipo 3
            listhorarios = new DBFHorarios(context).getRotaHorariosEspecificosDAO(linhas.get(j).getIdLinha(), calendar.get(Calendar.HOUR_OF_DAY), direcao, 3);
        }

        assert listhorarios != null;
        if (listhorarios.size() > 0) {
            float textSize= 17;
            //    Log.i("Script previa horarios", String.valueOf(listhorarios.size()) +" dia:"+String.valueOf(calendar.get(calendar.DAY_OF_WEEK)));
            //Futuramente criar uma tela dinamica desse horarios

            if (direcao.equals("y")) {
                TextView horarioSaindo = new TextView(context);
                horarioSaindo.setTextColor(Color.parseColor("#000000"));

                horarioSaindo.setLayoutParams(layoutParams);
                horarioSaindo.setText("Saindo do(a) " + linhas.get(j).getPontoY() + " sentido " + linhas.get(j).getPontoX());
                llVertical.addView(horarioSaindo);

                LinearLayout llHorizontal = new LinearLayout(context);
                llHorizontal.setOrientation(LinearLayout.HORIZONTAL);
                llHorizontal.setLayoutParams(layoutParams);

                for (int i = 0; i < listhorarios.size(); i++) {
                    TextView horarios = new TextView(context);
                    horarios.setTextSize(textSize);
                    horarios.setTextColor(Color.parseColor("#000000"));
                   // horarios.setBackgroundResource(R.color.red50);
                    horarios.setLayoutParams(layoutParams);
                    horarios.setText(listhorarios.get(i).getHorarioY());
                    llHorizontal.addView(horarios);
                }
                llVertical.addView(llHorizontal);

            } else if (direcao.equals("x")) {
                TextView horarioSaindo = new TextView(context);
                horarioSaindo.setLayoutParams(layoutParams);
                horarioSaindo.setTextColor(Color.parseColor("#000000"));

                horarioSaindo.setText("Saindo do(a) " + linhas.get(j).getPontoX() + " sentido " + linhas.get(j).getPontoY());
                llVertical.addView(horarioSaindo);

                LinearLayout llHorizontal = new LinearLayout(context);
                llHorizontal.setOrientation(LinearLayout.HORIZONTAL);
                llHorizontal.setLayoutParams(layoutParams);

                for (int i = 0; i < listhorarios.size(); i++) {
                    TextView horarios = new TextView(context);
                    horarios.setTextSize(textSize);
                   // horarios.setBackgroundResource(R.color.red50);
                    horarios.setTextColor(Color.parseColor("#000000"));
                    horarios.setLayoutParams(layoutParams);
                    horarios.setText(listhorarios.get(i).getHorarioX());
                    llHorizontal.addView(horarios);

                }
                llVertical.addView(llHorizontal);

            } else if (direcao.equals("xy")) {
                TextView horarioSaindo = new TextView(context);

                horarioSaindo.setTextColor(Color.parseColor("#000000"));
                horarioSaindo.setLayoutParams(layoutParams);
                horarioSaindo.setText(linhas.get(j).getName() + ", Saindo do(a) " + linhas.get(j).getPontoX());
                llVertical.addView(horarioSaindo);

                LinearLayout llHorizontal = new LinearLayout(context);
                llHorizontal.setOrientation(LinearLayout.HORIZONTAL);
                llHorizontal.setLayoutParams(layoutParams);

                for (int i = 0; i < listhorarios.size(); i++) {
                    TextView horarios = new TextView(context);
                    horarios.setTextSize(textSize);
                   // horarios.setBackgroundResource(R.color.red50);
                    horarios.setTextColor(Color.parseColor("#000000"));
                    horarios.setLayoutParams(layoutParams);
                    horarios.setText(listhorarios.get(i).getHorarioX());
                    llHorizontal.addView(horarios);

                }
                llVertical.addView(llHorizontal);

                TextView horarioSaindo2 = new TextView(context);
                horarioSaindo2.setTextColor(Color.parseColor("#000000"));
                horarioSaindo2.setLayoutParams(layoutParams);
                horarioSaindo2.setText(linhas.get(j).getName() + ", Saindo do(a) " + linhas.get(j).getPontoY());
                llVertical.addView(horarioSaindo2);

                LinearLayout llHorizontal2 = new LinearLayout(context);
                llHorizontal2.setOrientation(LinearLayout.HORIZONTAL);
                llHorizontal2.setLayoutParams(layoutParams);

                for (int i = 0; i < listhorarios.size(); i++) {
                    TextView horarios = new TextView(context);
                    horarios.setTextSize(textSize);
                    //horarios.setBackgroundResource(R.color.red50);
                    horarios.setLayoutParams(layoutParams);
                    horarios.setTextColor(Color.parseColor("#000000"));
                    horarios.setText(listhorarios.get(i).getHorarioY());
                    llHorizontal2.addView(horarios);
                }
                llVertical.addView(llHorizontal2);

            }
            if(j%2 == 0){
                llVertical.setBackgroundResource(R.color.blue50);
            }else
                llVertical.setBackgroundColor(Color.parseColor("#ffffff"));
            scview.addView(llVertical);
        }else contador++;
        if(contador == linhas.size()) {
            TextView horarios = new TextView(context);
            horarios.setText("Nenhum horário previsto");
            horarios.setLayoutParams(layoutParams);
            horarios.setTextColor(Color.parseColor("#000000"));
            horarios.setTextSize(18);
            scview.addView(horarios);
        }

        return scview;
    }

}