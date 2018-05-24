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

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Color;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TableRow.LayoutParams;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import br.com.pondionz.dao.DBFHorarios;
import br.com.pondionz.model.ColorHash;
import br.com.pondionz.model.Horario;
import br.com.pondionz.R;
import br.com.pondionz.control.StableArrayAdapterSpinner;
import br.com.pondionz.model.Linha;
import br.com.pondionz.model.TelaMetrics;

/**
 * Created by Iago on 31/12/2015.
 */
//Clase mais feia do meu codigo,ainda pode ser muita melhorada mas nao vai ser agora
public class Horarios extends FragmentActivity {
    private static Linha linha;

    private CustomPagerAdapter mCustomPagerAdapter;
    private ViewPager mViewPager;
    private static int spinnerPosition;

    public Horarios(){}
    public Horarios(Linha linha){
        Horarios.linha = linha;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.horarios);
        if(linha == null)
            this.finish();
        else
            createHorios();
    }

    private void createHorios() {
        Spinner spSentidos = (Spinner) findViewById(R.id.spinnerHorario);
        ArrayList<String> listStringSpinner = new ArrayList<String>();
        if(!linha.getPontoX().equals(linha.getPontoY())){
            listStringSpinner.add("Saindo do(a) "+linha.getPontoX());
            listStringSpinner.add("Saindo do(a) "+linha.getPontoY());
        }else
            listStringSpinner.add("Saindo do(a) "+linha.getPontoX());


        // Chama a o adapter do spinner para poder customizar.
        //nao tinha nescessidade de ser um custom adapter poderia ser o normal msm
        StableArrayAdapterSpinner adapter = new StableArrayAdapterSpinner(this, R.layout.spinner_rows, listStringSpinner);
        spSentidos.setAdapter(adapter);



        spSentidos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                for(int j = 0;j<2;j++) {
                    atualizarTabs();
                }
                spinnerPosition = i;

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        //não sei pq mas com 2 vezes n buga '-'
        for(int j = 0;j<2;j++) {
            atualizarTabs();
        }
    }

    private void atualizarTabs() {
        mCustomPagerAdapter = new CustomPagerAdapter(getSupportFragmentManager(), this);
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mCustomPagerAdapter);

    }

    static class CustomPagerAdapter extends FragmentPagerAdapter {

        Context mContext;

        public CustomPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            mContext = context;
        }


        @Override
        public Fragment getItem(int position) {

            // Create fragment object
            Fragment fragment = new DemoFragment();

            // Attach some data to the fragment
            // that we'll use to populate our fragment layouts
            Bundle args = new Bundle();
            args.putInt("page_position", position + 1);

            // Set the arguments on the fragment
            // that will be fetched in the
            // DemoFragment@onCreateView
            fragment.setArguments(args);

            return fragment;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            if(position+1 == 1) {
                return "Segunda a Sexta";
            }
            else if(position+1 == 2) {
                return "Sabados";
            }
            else if(position+1 == 3) {
                return "Domingos e Feriados";
            }
            return "Page " + (position + 1);
        }
    }

    //A partir daqui somente eu e deus sabe oq acontece talvez no futuro nem eu
    public static class DemoFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            if(linha == null)
                return null;
            // Inflate the layout resource that'll be returned
            Bundle args = getArguments();
            //Tela principal é um scrollview
            ScrollView svPrincipal = new ScrollView(getContext());
            svPrincipal.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.MATCH_PARENT));

            LinearLayout llVertical = new LinearLayout(getContext());
            llVertical.setOrientation(LinearLayout.VERTICAL);
            LayoutParams layoutParams2 = new LayoutParams(LayoutParams.WRAP_CONTENT,
                    LayoutParams.WRAP_CONTENT);
            layoutParams2.setMargins(3, 7, 3, 3);

            List<Horario> listhorarios = new DBFHorarios(getContext()).getRotaHorariosDAO(linha.getIdLinha(), args.getInt("page_position"));
            if (listhorarios.size() == 0) {
                listhorarios = new DBFHorarios(getContext()).getRotaHorariosDAO(linha.getIdLinha(), 4);
            }

            DisplayMetrics metrics = new DisplayMetrics();
            //gabs por ser static
            getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);

            Log.i("Tela", "Tamanho da tela " + metrics.widthPixels);
            //separado em x e y pra organização, mas funcionaria em 1 variavel só
            Hashtable<String, Integer> hashInfoAdX = new Hashtable<String, Integer>();
            Hashtable<String, Integer> hashInfoAdY = new Hashtable<String, Integer>();
            //define a quantidade de textview que cabe na horizontal
            int tamanhoHorizontal = new TelaMetrics().getMetrics(metrics.widthPixels, getResources().getConfiguration().orientation);
            //define a quantidade de text view que cabe na vertical
            int tamanhoVertical = listhorarios.size() / tamanhoHorizontal;
            if (tamanhoVertical == 0 || listhorarios.size() % tamanhoHorizontal > 0) {
                tamanhoVertical++;
            }
            //monte de variaavel que nao sei ao certo pra que ser mais funciona
            int total = 0;
            int totalInfmacoesAdicionais = 0;
            int tamanhohashX = 0;
            int tamanhohashY = 0;
            int tamanhoHorizontal2;
            //hash com cores ate key 6
            ColorHash colorHash = new ColorHash();
          //  Log.i("Tab", String.valueOf(args.getInt("page_position")));
            //aqui acontece a magia
            for (int j = 0; j < tamanhoVertical; j++) {
                //define o painel horizontal
                LinearLayout llHorizontal = new LinearLayout(getContext());
                llHorizontal.setOrientation(LinearLayout.HORIZONTAL);
                //reinicializa a variavel
                tamanhoHorizontal2 = 0;
                //quando chegar no valor horizontal que cabe na tela ele pular pra proxima linha ate definir todos vertical
                while (tamanhoHorizontal != tamanhoHorizontal2) {
                    TextView tv = new TextView(getContext());


                    tv.setPadding(8,1,8,1);
                    tv.setTextColor(Color.parseColor("#000000"));
                    tv.setLayoutParams(layoutParams2);
                    tv.setBackgroundResource(R.drawable.bg_normal);
                    tv.setTypeface(Typeface.DEFAULT_BOLD);
                    tv.setTextSize(18);

                    if (listhorarios.size() > total) {
                        if (spinnerPosition == 0) {
                            if (listhorarios.get(total).getInfoAdicionaisX().length() == 0) {
                                if(listhorarios.get(total).getHorarioX().length() != 0) {
                                    tv.setText(listhorarios.get(total).getHorarioX());
                                    if (tv.getText().length() > 0)
                                        llHorizontal.addView(tv);
                                    tamanhoHorizontal2++;
                                }
                            } else {
                                if(listhorarios.get(total).getHorarioX().length() != 0) {
                                    tv.setText(listhorarios.get(total).getHorarioX());
                                    if (!hashInfoAdX.containsKey(listhorarios.get(total).getInfoAdicionaisX())) {
                                        hashInfoAdX.put(listhorarios.get(total).getInfoAdicionaisX(), tamanhohashX);
                                        tv.setBackgroundResource(colorHash.getColor(tamanhohashX));
                                        tv.setText(String.valueOf(colorHash.getCaracter(tamanhohashX)+tv.getText().toString()));
                                        tv.setTextSize(15);
                                        tamanhohashX++;
                                    } else {
                                        tv.setBackgroundResource(colorHash.getColor(hashInfoAdX.get(listhorarios.get(total).getInfoAdicionaisX())));
                                        tv.setText(String.valueOf(colorHash.getCaracter(hashInfoAdX.get(listhorarios.get(total).getInfoAdicionaisX()))+tv.getText().toString()));
                                        tv.setTextSize(15);
                                    }
                                    if (tv.getText().length() > 0)
                                        llHorizontal.addView(tv);
                                    tamanhoHorizontal2++;
                                    totalInfmacoesAdicionais++;
                                }
                            }

                        } else if (spinnerPosition == 1) {
                            if (listhorarios.get(total).getInfoAdicionaisY().length() == 0) {
                                if(listhorarios.get(total).getHorarioY().length() != 0) {
                                    tv.setText(listhorarios.get(total).getHorarioY());
                                    if (tv.getText().length() > 0)
                                        llHorizontal.addView(tv);
                                    tamanhoHorizontal2++;
                                }
                            } else {
                                if(listhorarios.get(total).getHorarioY().length() != 0) {
                                    tv.setText(listhorarios.get(total).getHorarioY());
                                    if (!hashInfoAdY.containsKey(listhorarios.get(total).getInfoAdicionaisY())) {
                                        //  Log.i("Tamanho da hash", "hashcolor : " + tamanhohashY);
                                        hashInfoAdY.put(listhorarios.get(total).getInfoAdicionaisY(), tamanhohashY);
                                        tv.setBackgroundResource(colorHash.getColor(tamanhohashY));
                                        tv.setText(String.valueOf(colorHash.getCaracter(tamanhohashY)+tv.getText().toString()));
                                        tv.setTextSize(15);
                                        tamanhohashY++;
                                    } else {
                                        tv.setBackgroundResource(colorHash.getColor(hashInfoAdY.get(listhorarios.get(total).getInfoAdicionaisY())));
                                        tv.setText(String.valueOf(colorHash.getCaracter(hashInfoAdY.get(listhorarios.get(total).getInfoAdicionaisY()))+tv.getText().toString()));
                                        tv.setTextSize(15);
                                    }
                                    if (tv.getText().length() > 0)
                                        llHorizontal.addView(tv);
                                        tamanhoHorizontal2++;
                                        totalInfmacoesAdicionais++;
                                }
                            }
                        }
                    } else {
                        if (listhorarios.size() == 0) {
                            tv.setText("Linha não funciona neste dia!");
                            llHorizontal.addView(tv);
                        }
                        break;
                    }
                    total++;

                }
                llVertical.addView(llHorizontal);

            }

            LayoutParams layoutParams3 = new LayoutParams(LayoutParams.MATCH_PARENT,
                    LayoutParams.WRAP_CONTENT);
            layoutParams3.setMargins(0, 5, 0, 5);
            if (totalInfmacoesAdicionais > 0) {
                TextView tv = new TextView(getContext());
                tv.setTextColor(Color.parseColor("#000000"));
                tv.setLayoutParams(layoutParams3);

                tv.setBackgroundResource(R.color.blue50);
                tv.setTypeface(Typeface.DEFAULT_BOLD);
                tv.setText("Informações adicionais:");
                tv.setTextSize(22);
                llVertical.addView(tv);
            }
            if( spinnerPosition == 0){
                int tamanhohashx = hashInfoAdX.size();
                for (int i = 0; i < tamanhohashx; i++) {
                    TextView tv = new TextView(getContext());
                    tv.setTextSize(15);
                    tv.setPadding(20,1,20,1);
                    tv.setTextColor(Color.parseColor("#000000"));
                    tv.setLayoutParams(layoutParams3);
                    tv.setBackgroundResource(colorHash.getColor(i));
                    for (int j = 0; j < listhorarios.size(); j++) {
                        if (spinnerPosition == 0 && hashInfoAdX.containsKey(listhorarios.get(j).getInfoAdicionaisX())) {
                            tv.setText(String.valueOf(colorHash.getCaracter(i)+" - "
                                    +listhorarios.get(j).getInfoAdicionaisX()));
                            hashInfoAdX.remove(listhorarios.get(j).getInfoAdicionaisX());
                            break;
                        }
                    }
                    llVertical.addView(tv);
                }
            }
            else if(spinnerPosition == 1){
                int tamanhohashy = hashInfoAdY.size();
                for(int i=0; i< tamanhohashy;i++){
                    TextView tv = new TextView(getContext());
                    tv.setTextSize(15);
                    tv.setPadding(20,1,20,1);
                    tv.setTextColor(Color.parseColor("#000000"));
                    tv.setLayoutParams(layoutParams3);
                    tv.setBackgroundResource(colorHash.getColor(i));
                    for(int j = 0; j< listhorarios.size(); j++) {
                        if(hashInfoAdY.containsKey(listhorarios.get(j).getInfoAdicionaisY())) {
                            tv.setText(String.valueOf(colorHash.getCaracter(i)+" - "
                                    +listhorarios.get(j).getInfoAdicionaisY()));
                            hashInfoAdY.remove(listhorarios.get(j).getInfoAdicionaisY());
                            break;
                        }
                    }
                    llVertical.addView(tv);
                }
            }

            // the fragment was instantiated in the
            // CustomPagerAdapter
            svPrincipal.addView(llVertical);
            return svPrincipal;
        }
    }
}
